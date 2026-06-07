package wodel.utils.manager;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HTMLUtils {
	
	private static final Map<Character, String> HTML_ENTITIES = new LinkedHashMap<>();

    static {
        HTML_ENTITIES.put('&', "&amp;");
        HTML_ENTITIES.put('<', "&lt;");
        HTML_ENTITIES.put('>', "&gt;");
        HTML_ENTITIES.put('"', "&quot;");
        HTML_ENTITIES.put('\'', "&#39;");

        HTML_ENTITIES.put('á', "&aacute;");
        HTML_ENTITIES.put('é', "&eacute;");
        HTML_ENTITIES.put('í', "&iacute;");
        HTML_ENTITIES.put('ó', "&oacute;");
        HTML_ENTITIES.put('ú', "&uacute;");

        HTML_ENTITIES.put('Á', "&Aacute;");
        HTML_ENTITIES.put('É', "&Eacute;");
        HTML_ENTITIES.put('Í', "&Iacute;");
        HTML_ENTITIES.put('Ó', "&Oacute;");
        HTML_ENTITIES.put('Ú', "&Uacute;");

        HTML_ENTITIES.put('à', "&agrave;");
        HTML_ENTITIES.put('è', "&egrave;");
        HTML_ENTITIES.put('ì', "&igrave;");
        HTML_ENTITIES.put('ò', "&ograve;");
        HTML_ENTITIES.put('ù', "&ugrave;");

        HTML_ENTITIES.put('À', "&Agrave;");
        HTML_ENTITIES.put('È', "&Egrave;");
        HTML_ENTITIES.put('Ì', "&Igrave;");
        HTML_ENTITIES.put('Ò', "&Ograve;");
        HTML_ENTITIES.put('Ù', "&Ugrave;");

        HTML_ENTITIES.put('ä', "&auml;");
        HTML_ENTITIES.put('ë', "&euml;");
        HTML_ENTITIES.put('ï', "&iuml;");
        HTML_ENTITIES.put('ö', "&ouml;");
        HTML_ENTITIES.put('ü', "&uuml;");

        HTML_ENTITIES.put('Ä', "&Auml;");
        HTML_ENTITIES.put('Ë', "&Euml;");
        HTML_ENTITIES.put('Ï', "&Iuml;");
        HTML_ENTITIES.put('Ö', "&Ouml;");
        HTML_ENTITIES.put('Ü', "&Uuml;");

        HTML_ENTITIES.put('ñ', "&ntilde;");
        HTML_ENTITIES.put('Ñ', "&Ntilde;");
        HTML_ENTITIES.put('¿', "&iquest;");
        HTML_ENTITIES.put('¡', "&iexcl;");
    }

    public static String toHtmlEntities(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : text.toCharArray()) {
            String entity = HTML_ENTITIES.get(c);
            sb.append(entity != null ? entity : c);
        }

        return sb.toString();
    }

	private static final Pattern PRE_BLOCK =
            Pattern.compile("(?is)(<pre\\b[^>]*>)(.*?)(</pre>)");

    public static String normalizePreBlocks(String html) {
        Matcher matcher = PRE_BLOCK.matcher(html);
        StringBuffer out = new StringBuffer();

        while (matcher.find()) {
            String openTag = matcher.group(1);
            String inner = normalizeNewlines(matcher.group(2));
            String closeTag = matcher.group(3);

            String cleaned = isLineNumberBlock(inner)
                    ? normalizeLineNumberBlock(inner)
                    : normalizeCodeBlock(inner);

            matcher.appendReplacement(
                    out,
                    Matcher.quoteReplacement(openTag + cleaned + closeTag)
            );
        }

        matcher.appendTail(out);
        return out.toString();
    }

    private static boolean isLineNumberBlock(String s) {
        String[] lines = s.split("\n", -1);
        boolean sawNonBlank = false;

        for (String line : lines) {
            String trimmed = stripLeadingSpacesAndTabs(line);
            if (trimmed.isBlank()) {
                continue;
            }
            sawNonBlank = true;

            if (!trimmed.matches("<span\\s+class=\"normal\">\\d+</span>")) {
                return false;
            }
        }
        return sawNonBlank;
    }

    private static String normalizeLineNumberBlock(String s) {
        String[] lines = s.split("\n", -1);
        for (int i = 0; i < lines.length; i++) {
            lines[i] = stripLeadingSpacesAndTabs(lines[i]);
        }
        return String.join("\n", lines);
    }

    private static String normalizeCodeBlock(String s) {
        String[] lines = s.split("\n", -1);

        if (lines.length <= 1) {
            return s;
        }

        int minIndent = Integer.MAX_VALUE;

        // Keep line 1 exactly as generated.
        // For the remaining lines, remove the common artificial padding.
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            if (line.isBlank()) {
                continue;
            }
            minIndent = Math.min(minIndent, countLeadingSpacesAndTabs(line));
        }

        if (minIndent == Integer.MAX_VALUE) {
            minIndent = 0;
        }

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].isBlank()) {
                lines[i] = "";
            } else {
                lines[i] = removeLeadingSpacesAndTabs(lines[i], minIndent);
            }
        }

        return String.join("\n", lines);
    }

    private static String normalizeNewlines(String s) {
        return s.replace("\r\n", "\n").replace('\r', '\n');
    }

    private static int countLeadingSpacesAndTabs(String s) {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ' || c == '\t') {
                i++;
            } else {
                break;
            }
        }
        return i;
    }

    private static String stripLeadingSpacesAndTabs(String s) {
        return removeLeadingSpacesAndTabs(s, countLeadingSpacesAndTabs(s));
    }

    private static String removeLeadingSpacesAndTabs(String s, int n) {
        int i = 0;
        int removed = 0;

        while (i < s.length() && removed < n) {
            char c = s.charAt(i);
            if (c == ' ' || c == '\t') {
                i++;
                removed++;
            } else {
                break;
            }
        }
        return s.substring(i);
    }
}