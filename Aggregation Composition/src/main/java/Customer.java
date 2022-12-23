import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerName;
    private String customerAddress;
    private int noOfRequests;
    private List<Request> requestList=new ArrayList<>();

    public Customer(String customerName, String customerAddress) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void addRequest(Request request){
        if(requestList.size() < 3) {
            requestList.add(request);
        }
    }

    public void printRequests(){
        requestList.forEach(
                requestObj -> {
                    System.out.println("Request Date: " + requestObj.getRequestDate());
                    System.out.println("Request Number: " + requestObj.getRequestNumber());
                    requestObj.printModules();
                }
        );
    }
}
