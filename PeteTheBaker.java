import java.util.Map;

public class PeteTheBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int maxCakes = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            String ingredient = entry.getKey();
            if (!available.containsKey(ingredient)) return 0;
            maxCakes = Math.min(maxCakes, available.get(ingredient) / entry.getValue());
        }

        return maxCakes;
    }

    public static void main(String[] args) {
        Map<String, Integer> recipe1 = Map.of("flour", 500, "sugar", 200, "eggs", 1);
        Map<String, Integer> available1 = Map.of("flour", 1200, "sugar", 1200, "eggs", 5, "milk", 200);
        System.out.println(cakes(recipe1, available1));  // Expected output: 2

        Map<String, Integer> recipe2 = Map.of("apples", 3, "flour", 300, "sugar", 150, "milk", 100, "oil", 100);
        Map<String, Integer> available2 = Map.of("sugar", 500, "flour", 2000, "milk", 2000);
        System.out.println(cakes(recipe2, available2));  // Expected output: 0
    }
}
