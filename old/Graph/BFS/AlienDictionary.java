package Graph.BFS;
import java.util.*;

// https://leetcode.com/problems/alien-dictionary/
// approach 1: bfs
//

public class AlienDictionary {
    public String alienOrder(String[] words) {

        // Step 0: Create data structures and find all unique letters.
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            // Find the first non match and insert the correcponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        // Step 2: BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (Character c : counts.keySet()) {

            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }

        while(!queue.isEmpty()) {

            Character c = queue.remove();
            sb.append(c);

            for (Character next : adjList.get(c)) {

                counts.put(next, counts.get(next) - 1);

                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }

        return sb.toString();
    }
}
