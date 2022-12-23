import java.util.ArrayList;
import java.util.List;

public class Request {

    private int requestNumber;
    private String requestDate;
    private List<Module> moduleList=new ArrayList<>();
    private int noOfModules;

    public Request(int requestNumber, String requestDate) {
        this.requestNumber = requestNumber;
        this.requestDate = requestDate;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public String getRequestDate() {
        return requestDate;
    }
    public void addModule(Module module){
//        if(moduleList.size() > 1) {
//            System.out.println("You're attempting to add more ride types than one");
//        }
        if(moduleList.size() < 20){
            moduleList.add(module);
        }
    }

    public void printModules() {
        moduleList.forEach(
                module -> {
                    System.out.println("Module: " + module.getModuleName());
                }
        );
    }

}
