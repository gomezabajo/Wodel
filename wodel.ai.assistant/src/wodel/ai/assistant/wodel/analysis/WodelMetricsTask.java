package wodel.ai.assistant.wodel.analysis;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;
import wodel.ai.assistant.wodel.analysis.WodelAnalysisService.AnalysisContext;
import wodel.utils.manager.ModelManager;

/** Conversational facade over Wodel's registry and optional metrics bundles. */
public final class WodelMetricsTask extends MTTask implements IntentAwareTask {
    private static final int MAX_RENDERED_NODES = 220;
    private final WodelAnalysisService analysis = new WodelAnalysisService();

    public WodelMetricsTask() {
        super("Summarize applied-mutation counts and, when installed/generated, Wodel command/static, net-dynamic and debug footprint metrics");
        this.id = "SummarizeWodelMutationMetrics";
    }

    @Override
    public Collection<String> getIntentAliases() {
        return List.of(
            "wodel metrics",
            "mutation metrics",
            "mutant metrics",
            "static footprint",
            "dynamic footprint",
            "debug footprint",
            "mutation footprint");
    }

    @Override
    public String getIntentGroup() { return "mutation-analysis"; }

    @Override
    public int getIntentPriority() { return 110; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        final AnalysisContext context;
        try {
            context = analysis.resolve(userInput);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return e.getMessage();
        }

        String lower = userInput == null ? "" : userInput.toLowerCase(Locale.ROOT);
        boolean explicitCommand = lower.contains("command") || lower.contains("static");
        boolean explicitDynamic = lower.contains("dynamic") || lower.contains("net footprint");
        boolean explicitDebug = lower.contains("debug");
        boolean all = lower.contains("all") || !(explicitCommand || explicitDynamic || explicitDebug);

        StringBuilder out = new StringBuilder();
        out.append("Wodel mutation metrics for ").append(context.source().getProjectRelativePath()).append('\n');
        out.append("\nAPPLIED-MUTATION / ADEQUACY METRICS\n")
            .append(analysis.adequacyReport(context));

        if (all || explicitCommand) {
            out.append("\n\nCOMMAND / STATIC FOOTPRINT METRICS\n")
                .append(commandMetrics(context));
        }
        if (all || explicitDynamic) {
            out.append("\n\nNET DYNAMIC FOOTPRINT METRICS\n")
                .append(dynamicMetrics(context, false));
        }
        if (all || explicitDebug) {
            out.append("\n\nDEBUG FOOTPRINT METRICS\n")
                .append(dynamicMetrics(context, true));
        }
        return out.toString();
    }

    private String commandMetrics(AnalysisContext context) {
        try {
            Bundle bundle = Platform.getBundle("wodel.metrics.command");
            if (bundle == null) return "Optional bundle wodel.metrics.command is not installed.";
            Class<?> type = bundle.loadClass("wodel.metrics.command.CommandMutatorMetrics");
            Method method = type.getMethod("createWodelCommandMetrics", String.class, String.class);
            Object result = method.invoke(null, context.project().getName(), context.metamodel());
            return renderMetricTree(result);
        } catch (Exception e) {
            return "Command metrics could not be read: " + safeMessage(e);
        }
    }

    private String dynamicMetrics(AnalysisContext context, boolean debug) {
        String bundleName = debug ? "wodel.metrics.debug" : "wodel.metrics.dynamic";
        String className = debug
            ? "wodel.metrics.debug.DebugMutatorMetrics"
            : "wodel.metrics.dynamic.NetMutatorMetrics";
        String methodName = debug ? "createWodelDebugMetrics" : "createWodelDynamicMetrics";
        try {
            Bundle bundle = Platform.getBundle(bundleName);
            if (bundle == null) return "Optional bundle " + bundleName + " is not installed.";

            List<String> metricModels = metricModels(context, debug);
            if (metricModels.isEmpty()) {
                return "No " + (debug ? "debug" : "net") + " footprint model is present under " + context.outputFolder()
                    + ". Enable the corresponding Wodel footprint preference and regenerate mutants.";
            }

            Bundle modelsBundle = Platform.getBundle("wodel.models");
            URL metricsEcore = modelsBundle.getEntry("/model/MutatorMetrics.ecore");
            List<EPackage> metricPackages = ModelManager.loadMetaModel(FileLocator.resolve(metricsEcore).getFile());
            List<EPackage> domainPackages = ModelManager.loadMetaModel(context.metamodel());

            Class<?> type = bundle.loadClass(className);
            Method method = null;
            for (Method candidate : type.getMethods()) {
                if (candidate.getName().equals(methodName)
                        && Modifier.isStatic(candidate.getModifiers())
                        && candidate.getParameterCount() == 3
                        && List.class.isAssignableFrom(candidate.getParameterTypes()[0])) {
                    method = candidate;
                    break;
                }
            }
            if (method == null) return "The expected metrics API " + className + "." + methodName + " was not found.";
            Object result = method.invoke(null, metricModels, metricPackages, domainPackages);
            return renderMetricTree(result);
        } catch (Exception e) {
            return (debug ? "Debug" : "Dynamic") + " metrics could not be read: " + safeMessage(e);
        }
    }

    private List<String> metricModels(AnalysisContext context, boolean debug) {
        List<String> result = new ArrayList<>();
        File[] files = context.outputFolder().toFile().listFiles();
        if (files == null) return result;
        for (File file : files) {
            if (!file.isFile()) continue;
            String name = file.getName();
            if (debug) {
                if (name.endsWith("_debugMetrics.model")) result.add(file.getPath());
            } else if (name.endsWith("_metrics.model") && !name.endsWith("_debugMetrics.model")) {
                result.add(file.getPath());
            }
        }
        return result;
    }

    private String renderMetricTree(Object root) {
        if (root == null) return "No metrics were returned.";
        StringBuilder out = new StringBuilder();
        int[] count = {0};
        if (root.getClass().isArray()) {
            int length = Array.getLength(root);
            for (int i = 0; i < length; i++) renderNode(Array.get(root, i), out, "", count);
        } else {
            renderNode(root, out, "", count);
        }
        if (out.length() == 0) return "No metrics were returned.";
        if (count[0] >= MAX_RENDERED_NODES) out.append("\n... metric output truncated by the assistant");
        return out.toString();
    }

    private void renderNode(Object node, StringBuilder out, String indent, int[] count) {
        if (node == null || count[0] >= MAX_RENDERED_NODES) return;
        count[0]++;
        String name = invokeString(node, "getName");
        if (name == null || name.isBlank()) name = node.getClass().getSimpleName();
        out.append(indent).append("- ").append(name)
            .append(" [create=").append(readMetric(node, "creation", "ccreation"))
            .append(", modify=").append(readMetric(node, "modification", "mmodification", "cmodification"))
            .append(", delete=").append(readMetric(node, "deletion", "ddeletion", "cdeletion"))
            .append("]\n");
        Object children = invoke(node, "getChildren");
        if (children != null && children.getClass().isArray()) {
            int length = Array.getLength(children);
            for (int i = 0; i < length; i++) renderNode(Array.get(children, i), out, indent + "  ", count);
        }
    }

    private int readMetric(Object node, String... fieldNames) {
        for (String fieldName : fieldNames) {
            try {
                Field field = node.getClass().getField(fieldName);
                Object value = field.get(node);
                if (value instanceof Number number) return number.intValue();
            } catch (Exception ignored) {
            }
        }
        return 0;
    }

    private String invokeString(Object target, String methodName) {
        Object value = invoke(target, methodName);
        return value == null ? null : String.valueOf(value);
    }

    private Object invoke(Object target, String methodName) {
        try {
            return target.getClass().getMethod(methodName).invoke(target);
        } catch (Exception e) {
            return null;
        }
    }

    private String safeMessage(Throwable e) {
        Throwable current = e;
        while (current.getCause() != null) current = current.getCause();
        String message = current.getMessage();
        return message == null || message.isBlank() ? current.getClass().getSimpleName() : message;
    }
}
