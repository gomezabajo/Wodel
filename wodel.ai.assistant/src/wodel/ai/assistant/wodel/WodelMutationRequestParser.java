package wodel.ai.assistant.wodel;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Deterministic parser for the most useful Wodel execution parameters. It is
 * deliberately independent of the LLM so normal mutation execution does not
 * require an API key.
 */
public final class WodelMutationRequestParser {
    private static final Pattern PROGRAM_KV = Pattern.compile(
        "(?i)\\b(?:program|mutator|file)\\s*[:=]\\s*(?:\"([^\"]+)\"|'([^']+)'|([^\\s]+))");
    private static final Pattern PROGRAM_NL = Pattern.compile(
        "(?i)\\b(?:program|mutator)\\s+(?:named\\s+)?(?:\"([^\"]+)\"|'([^']+)'|([A-Za-z0-9_./\\\\-]+\\.mutator))");
    private static final Pattern MUTATOR_FILE_NL = Pattern.compile(
        "(?i)([A-Za-z0-9_./\\\\-]+\\.mutator)\\b");
    private static final Pattern MUTANTS_KV = Pattern.compile(
        "(?i)\\b(?:mutants?|number\\s*of\\s*mutants?|numMutants)\\s*[:=]\\s*(\\d+)\\b");
    private static final Pattern MUTANTS_NL = Pattern.compile(
        "(?i)\\b(?:generate|create|produce|make)\\s+(\\d+)\\s+(?:wodel\\s+)?mutants?\\b");
    private static final Pattern ATTEMPTS_KV = Pattern.compile(
        "(?i)\\b(?:attempts?|maxAttempts|max\\s*attempts?)\\s*[:=]\\s*(\\d+)\\b");
    private static final Pattern ATTEMPTS_NL = Pattern.compile(
        "(?i)\\b(?:with|using|up\\s+to)?\\s*(\\d+)\\s+(?:maximum\\s+|max\\s+)?attempts?\\b");
    private static final Pattern SEED = Pattern.compile(
        "(?i)\\b(?:execution\\s+seed|seed)\\s*[:=]?\\s*(-?\\d+)\\b");
    private static final Pattern BLOCKS_KV = Pattern.compile(
        "(?i)\\b(?:blocks?|operators?)\\s*[:=]\\s*(?:\\[([^]]*)\\]|\"([^\"]*)\"|'([^']*)'|([^\\s]+))");
    private static final Pattern BLOCKS_NL = Pattern.compile(
        "(?i)\\b(?:for|of|using)?\\s*(?:blocks?|operators?)\\s+(?:named\\s+)?(.+?)(?=\\s+(?:with|using|seed|execution\\s+seed|attempts?|max\\s+attempts?|registry|metrics|debug\\s+metrics|serialize|serialization|program|mutator|file)\\b|$)");

    private WodelMutationRequestParser() {
    }

    public static WodelMutationRequest parse(String text) {
        String input = text == null ? "" : text.trim();

        String programName = parseProgram(input);
        Integer numMutants = firstInteger(input, MUTANTS_KV, MUTANTS_NL);
        Integer maxAttempts = firstInteger(input, ATTEMPTS_KV, ATTEMPTS_NL);
        Long seed = firstLong(input, SEED);
        List<String> blocks = parseBlocks(input);
        Boolean registry = parseBoolean(input, "registry");
        Boolean metrics = parseBoolean(input, "metrics");
        Boolean debugMetrics = parseBoolean(input, "debug metrics", "debugMetrics");
        Boolean serialize = parseBoolean(input, "serialize", "serialization");

        return new WodelMutationRequest(
            programName,
            numMutants,
            maxAttempts,
            seed,
            blocks,
            registry,
            metrics,
            debugMetrics,
            serialize);
    }

    public static boolean looksLikeParameterizedMutation(String text) {
        if (text == null || text.isBlank()) {
            return false;
        }
        String lower = text.toLowerCase(Locale.ROOT);
        boolean mutationVerb = lower.contains("mutant")
            || lower.contains("mutation")
            || lower.contains("mutator")
            || lower.contains("generate")
            || lower.contains("execute")
            || lower.contains("run");
        return mutationVerb && parse(text).hasOverrides();
    }

    private static String parseProgram(String input) {
        for (Pattern pattern : List.of(PROGRAM_KV, PROGRAM_NL, MUTATOR_FILE_NL)) {
            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()) continue;
            for (int i = 1; i <= matcher.groupCount(); i++) {
                String value = matcher.group(i);
                if (value != null && !value.isBlank()) return value.trim();
            }
        }
        return null;
    }

    private static Integer firstInteger(String input, Pattern... patterns) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                return Integer.valueOf(matcher.group(1));
            }
        }
        return null;
    }

    private static Long firstLong(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        return matcher.find() ? Long.valueOf(matcher.group(1)) : null;
    }

    private static List<String> parseBlocks(String input) {
        Matcher kv = BLOCKS_KV.matcher(input);
        if (kv.find()) {
            for (int i = 1; i <= kv.groupCount(); i++) {
                if (kv.group(i) != null) {
                    return splitNames(kv.group(i));
                }
            }
        }

        Matcher natural = BLOCKS_NL.matcher(input);
        if (natural.find()) {
            String raw = natural.group(1).trim();
            // Avoid treating generic phrases such as "all blocks" as a literal block.
            if (raw.equalsIgnoreCase("all") || raw.equalsIgnoreCase("all available")) {
                return List.of();
            }
            return splitNames(raw);
        }
        return List.of();
    }

    private static List<String> splitNames(String raw) {
        if (raw == null || raw.isBlank()) {
            return List.of();
        }
        String normalized = raw
            .replaceAll("(?i)\\s+and\\s+", ",")
            .replace(';', ',');
        Set<String> names = new LinkedHashSet<>();
        for (String token : normalized.split(",")) {
            String name = token.trim();
            if ((name.startsWith("\"") && name.endsWith("\""))
                    || (name.startsWith("'") && name.endsWith("'"))) {
                name = name.substring(1, name.length() - 1).trim();
            }
            if (!name.isBlank()) {
                names.add(name);
            }
        }
        return new ArrayList<>(names);
    }

    private static Boolean parseBoolean(String input, String... keys) {
        for (String key : keys) {
            String escaped = Pattern.quote(key);
            Pattern keyValue = Pattern.compile(
                "(?i)\\b" + escaped + "\\s*[:=]\\s*(true|false|yes|no|on|off)\\b");
            Matcher kv = keyValue.matcher(input);
            if (kv.find()) {
                return parseBooleanToken(kv.group(1));
            }

            Pattern disabled = Pattern.compile(
                "(?i)\\b(?:without|disable|disabled|no)\\s+" + escaped + "\\b");
            if (disabled.matcher(input).find()) {
                return Boolean.FALSE;
            }

            Pattern enabled = Pattern.compile(
                "(?i)\\b(?:with|enable|enabled)\\s+" + escaped + "\\b");
            if (enabled.matcher(input).find()) {
                return Boolean.TRUE;
            }
        }
        return null;
    }

    private static Boolean parseBooleanToken(String token) {
        return switch (token.toLowerCase(Locale.ROOT)) {
            case "true", "yes", "on" -> Boolean.TRUE;
            case "false", "no", "off" -> Boolean.FALSE;
            default -> null;
        };
    }
}
