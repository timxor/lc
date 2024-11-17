//public class HashTableExample {
//    private LinkedList<String>[] buckets;
//
//    public HashTableExample(int size) {
//        buckets = new LinkedList[size];
//        for (int i = 0; i < size; i++) {
//            buckets[i] = new LinkedList<>();
//        }
//    }
//
//    public void add(String value) {
//        int bucketIndex = value.hashCode() % buckets.length;
//        buckets[bucketIndex].add(value);
//    }
//
//    public boolean contains(String value) {
//        int bucketIndex = value.hashCode() % buckets.length;
//        return buckets[bucketIndex].contains(value);
//    }
//}
//
