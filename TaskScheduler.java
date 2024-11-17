//// https://leetcode.com/problems/task-scheduler/description/
//// https://www.youtube.com/watch?v=ySTQCRya6B0
//
//class TaskScheduler {
//
//  public int leastInterval(char[] tasks, int n) {
//         HashMap<Character, Integer> map = new HashMap<>();
//
//       for(char c : tasks) {
//         map.put(c, map.getOrDefault(c,0)+1);
//       }
//
//       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
//
//       maxHeap.addAll(map.values());
//
//       int cycles = 0;
//
//       while(!maxHeap.isEmpty()) {
//
//         List<Integer> tmp = new ArrayList<>();
//
//         for(int i = 0; i < n+1;i++) {
//
//           if(!maxHeap.isEmpty()) {
//             tmp.add(maxHeap.remove());
//           }
//         }
//
//       for(int i : tmp) {
//         if(--i > 0) {
//           maxHeap.add(i);
//         }
//       }
//
//       cycles += maxHeap.isEmpty() ? tmp.size() : n + 1;
//
//    }
//    return cycles;
//    }
//}