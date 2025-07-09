package org.JuegoApothecaryDiaries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameState {
    private Set<String> flags = new HashSet<>();
    private Map<String, Integer> scores = new HashMap<>();

    boolean evaluate(String condition) {
        if (condition == null || condition.isEmpty()) return true;
        for (String part : condition.split("&&")) {
            part = part.trim();
            if (part.startsWith("!")) {
                if (flags.contains(part.substring(1))) return false;
            } else {
                if (!flags.contains(part)) return false;
            }
        }
        return true;
    }

    void applyWeight(String key, int value) {
        scores.put(key, scores.getOrDefault(key, 0) + value);
    }

    int getScore(String key) {
        return scores.getOrDefault(key, 0);
    }
}