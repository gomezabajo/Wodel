package wodel.ai.assistant.wodel;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

import wodel.ai.assistant.MTTask;
import wodel.ai.assistant.chat.IntentAwareTask;

public class EclipseCommandTask extends MTTask implements IntentAwareTask {
    private final String commandId;
    private final String successMessage;
    private final List<String> aliases;
    private final String intentGroup;
    private final int intentPriority;

    public EclipseCommandTask(String id, String description, String commandId,
            String successMessage, Collection<String> aliases) {
        this(id, description, commandId, successMessage, aliases, "", 0);
    }

    public EclipseCommandTask(String id, String description, String commandId,
            String successMessage, Collection<String> aliases,
            String intentGroup, int intentPriority) {
        super(description);
        this.id = id;
        this.commandId = commandId;
        this.successMessage = successMessage;
        this.aliases = List.copyOf(aliases);
        this.intentGroup = intentGroup == null ? "" : intentGroup;
        this.intentPriority = intentPriority;
    }

    @Override public Collection<String> getIntentAliases() { return aliases; }
    @Override public String getIntentGroup() { return intentGroup; }
    @Override public int getIntentPriority() { return intentPriority; }

    @Override
    public Object executeWithInput(String userInput) throws Exception {
        if (!PlatformUI.isWorkbenchRunning()) return "This Wodel workflow requires a running Eclipse workbench.";

        AtomicReference<String> result = new AtomicReference<>();
        AtomicReference<Exception> failure = new AtomicReference<>();
        Runnable execute = () -> {
            try {
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if (window == null) {
                    result.set("No active Eclipse workbench window is available.");
                    return;
                }
                IHandlerService handlers = window.getService(IHandlerService.class);
                if (handlers == null) {
                    result.set("The Eclipse command service is not available in the active window.");
                    return;
                }
                handlers.executeCommand(commandId, null);
                result.set(successMessage);
            } catch (Exception e) {
                failure.set(e);
            }
        };

        var display = PlatformUI.getWorkbench().getDisplay();
        if (display == null || display.isDisposed()) {
            return "The Eclipse UI display is not available.";
        }
        if (display.getThread() == Thread.currentThread()) execute.run();
        else display.syncExec(execute);

        if (failure.get() != null) throw failure.get();
        return result.get() == null ? successMessage : result.get();
    }
}
