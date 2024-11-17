//// Target Interface
//interface Target {
//    void request();
//}
//
//// Adaptee: The class we want to adapt
//class Adaptee {
//    void specificRequest() {
//        System.out.println("Specific Request called!");
//    }
//}
//
//// Adapter: Wraps the Adaptee to fit the Target interface
//class AdapterPattern implements Target {
//    private Adaptee adaptee;
//
//    public AdapterPattern(Adaptee adaptee) {
//        this.adaptee = adaptee;
//    }
//
//    @Override
//    public void request() {
//        adaptee.specificRequest();
//    }
//}
//
//// Client code
//public class Client {
////    public static void main(String[] args) {
//        Adaptee adaptee = new Adaptee();
//        Target target = new AdapterPattern(adaptee);
//        target.request();  // This will internally call specificRequest of Adaptee
//    }
//}
