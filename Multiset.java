import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Multiset<T> {
    private Map<T, Integer> map;

    public Multiset() {
        map = new HashMap<>();
    }

    public void add(T element) {
        map.put(element, map.getOrDefault(element, 0) + 1);
    }

    public void remove(T element) {
        if (map.containsKey(element)) {
            int count = map.get(element);
            if (count == 1) {
                map.remove(element);
            } else {
                map.put(element, count - 1);
            }
        }
    }

    public int count(T element) {
        return map.getOrDefault(element, 0);
    }

    public Set<T> elementSet() {
        return map.keySet();
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public static void main(String[] args) {
        Multiset<String> multiset = new Multiset<>();
        multiset.add("apple");
        multiset.add("banana");
        multiset.add("apple");

        System.out.println("Multiset: " + multiset);
        System.out.println("Count of 'apple': " + multiset.count("apple"));

        multiset.remove("apple");
        System.out.println("Multiset after removing one 'apple': " + multiset);

        multiset.remove("apple");
        System.out.println("Multiset after removing another 'apple': " + multiset);
    }
}

