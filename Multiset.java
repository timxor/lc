import java.util.HashMap;
import java.util.Map;

public class Multiset<T> {
    private final Map<T, Integer> map = new HashMap<>();

    public void add(T element) {
        map.put(element, map.getOrDefault(element, 0) + 1);
    }

    public void remove(T element) {
        map.put(element, Math.max(0, map.getOrDefault(element, 0) - 1));
    }

    public int count(T element) {
        return map.getOrDefault(element, 0);
    }
}
