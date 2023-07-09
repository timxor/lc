package Graph.DFS;

// https://leetcode.com/problems/reconstruct-itinerary/
// hard
// approach 1: backtracking + greedy
// approach 2: hierholzers algorithm (postorder DFS)

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ReconstructItinerary {
    // origin -> list of destinations
    HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    LinkedList<String> result = null;

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1). build the graph first
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.flightMap.containsKey(origin)) {
                LinkedList<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }

        // Step 2). order the destinations
        this.flightMap.forEach((key, value) -> Collections.sort(value));

        this.result = new LinkedList<String>();
        // Step 3). post-order DFS
        this.DFS("JFK");
        return this.result;
    }

    protected void DFS(String origin) {
        // Visit all the outgoing edges first.
        if (this.flightMap.containsKey(origin)) {
            LinkedList<String> destList = this.flightMap.get(origin);
            while (!destList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.
                String dest = destList.pollFirst();
                DFS(dest);
            }
        }
        // add the airport to the head of the itinerary
        this.result.offerFirst(origin);
    }
}