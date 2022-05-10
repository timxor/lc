package Design;


/*
    google top 50
    https://leetcode.com/problem-list/top-google-questions/

    https://leetcode.com/problems/detect-squares/



 */


import java.util.HashMap;
import java.util.Map;

class DetectSquares {

    Map<Integer, Map<Integer, Integer>> locs;

    public DetectSquares() {
        locs = new HashMap<>();
    }

    public void add(int[] point) {

        int x= point[0];
        int y = point[1];

        locs.putIfAbsent(x, new HashMap<>());
        locs.get(x).put(y, locs.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0], y = point[1];
        if (!locs.containsKey(x)) return 0;
        int ret = 0;

        for (int key : locs.get(x).keySet()) {

            if (y == key) continue;
            int len = Math.abs(y - key);

            if (locs.containsKey(x - len)) {

                if (locs.get(x - len).containsKey(key) && locs.get(x - len).containsKey(y)) {

                    ret += locs.get(x).get(key) * locs.get(x - len).get(key) * locs.get(x - len).get(y);
                }
            }

            if (locs.containsKey(x + len)) {

                if (locs.get(x + len).containsKey(key) && locs.get(x + len).containsKey(y)) {

                    ret += locs.get(x).get(key) * locs.get(x + len).get(key) * locs.get(x + len).get(y);
                }
            }
        }
        return ret;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */

/*

Input
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]

Output
[null, null, null, null, 1, 0, null, 2]

Explanation
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points



 */