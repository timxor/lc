
import java.util.*;

public class Review {
    
    void main() {
        System.out.println("");
        System.out.println("Review.java");
        System.out.println("");
        

        Map<Integer, Integer> count = new HashMap();
        
        List<List<Integer>> res = new ArrayList<>();

        var seen = new HashSet<Integer>();

        LinkedList<Integer> stack = new LinkedList<>();

        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));


        HashMap<String, HashMap<String, Integer[]>> tickerToExchangeToPrice = new HashMap<String, HashMap<String, Integer[]>>();

        


    }
}
