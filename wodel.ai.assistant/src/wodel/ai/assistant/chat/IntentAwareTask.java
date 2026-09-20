package wodel.ai.assistant.chat;

import java.util.Collection;
import java.util.Locale;

/**
 * Optional deterministic intent metadata used by the chat planner before an
 * LLM classification is attempted.
 */
public interface IntentAwareTask {
    Collection<String> getIntentAliases();

    /**
     * Returns the first matching position in the user utterance, or -1 when
     * this task does not match deterministically.
     */
    default int matchIndex(String userUtterance) {
        if (userUtterance == null || userUtterance.isBlank()) {
            return -1;
        }
        String text = userUtterance.toLowerCase(Locale.ROOT);
        int first = Integer.MAX_VALUE;
        for (String alias : getIntentAliases()) {
            if (alias == null || alias.isBlank()) {
                continue;
            }
            int index = text.indexOf(alias.toLowerCase(Locale.ROOT));
            if (index >= 0 && index < first) {
                first = index;
            }
        }
        return first == Integer.MAX_VALUE ? -1 : first;
    }

    /**
     * Tasks in the same non-empty group are mutually exclusive. The planner
     * retains the highest-priority deterministic match in each group.
     */
    default String getIntentGroup() {
        return "";
    }

    /** Higher values win inside the same intent group. */
    default int getIntentPriority() {
        return 0;
    }
}
