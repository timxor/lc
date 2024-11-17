//// https://learn.microsoft.com/en-us/azure/architecture/patterns/sidecar
//
//
//// MainService.java
//public class MainService {
//    public void start() {
//        // Your main service logic here
//    }
//}
//
//// SidecarService.java
//public class SidecarPattern {
//    public void start() {
//        // Your sidecar service logic here
//    }
//}
//
//// Launcher.java
//public class Launcher {
//    public static void main(String[] args) {
//        MainService mainService = new MainService();
//        SidecarPattern sidecarService = new SidecarPattern();
//
//        mainService.start();
//        sidecarService.start();
//    }
//}
