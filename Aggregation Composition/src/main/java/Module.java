public class Module {

    private String moduleName;
    private double moduleCost;

    public Module(String moduleName, double moduleCost) {
        this.moduleName = moduleName;
        this.moduleCost = moduleCost;
    }

    public String getModuleName() {
        return moduleName;
    }

    public double getModuleCost() {
        return moduleCost;
    }
}
