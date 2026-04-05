package wodel.utils.manager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HTMLUtils {

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