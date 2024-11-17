//
//// https://learn.microsoft.com/en-us/azure/architecture/patterns/ambassador?source=docs
//
//
//// Main service interface
//interface AmbassadorService {
//    int performOperation();
//}
//
//// Real service implementation
//class RealService implements AmbassadorService {
//    @Override
//    public int performOperation() {
//        return 42;  // Just a mock operation
//    }
//}
//
//// Ambassador implementation
//// class ServiceAmbassador implements Service {
//class AmbassadorPattern implements AmbassadorService {
//    private final AmbassadorService realService;
//
//    public ServiceAmbassador() {
//        this.realService = new RealService();
//    }
//
//    @Override
//    public int performOperation() {
//        int response = -1;
//
//        try {
//            // Here you can add features like retries, logging, circuit breaking, etc.
//            response = realService.performOperation();
//        } catch(Exception e) {
//            // Handle the exception, log, retry, etc.
//        }
//
//        return response;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        AmbassadorService service = new AmbassadorPattern();
//        System.out.println(service.performOperation());
//    }
//}
