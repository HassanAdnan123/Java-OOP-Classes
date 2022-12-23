import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        BasePlusCommissionedEmployee A = new BasePlusCommissionedEmployee();
        A.executePayroll();
    }
}

class Employee {
    public String firstName;
    public String lastName;
    public double NIC;
    public int pay;

    public Employee(String firstName, String lastName, double NIC) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.NIC = NIC;
    }
    public void executePayroll(){
        System.out.println("Your salary cannot be determined. Please select your type.");
    }
    public Employee(){

    }
}

class SalariedEmployee extends Employee{

    int totalSalary = 0;

    Scanner sc = new Scanner(System.in);

    @Override
    public void executePayroll() {
        System.out.println("Your base salary? ");
        totalSalary += sc.nextInt();
        System.out.println("Your allowance? ");
        totalSalary += sc.nextInt();
        System.out.println("Any bonuses? ");
        totalSalary += sc.nextInt();
        System.out.println("TOTAL SALARY FOR THIS MONTH: "+totalSalary);
    }
}
class CommissionedEmployee extends Employee{

    int perProjectCost = 0;
    int commission = 0; // percentage
    int noOfProjects = 0;

    int totalCommissionedPay;

    Scanner sc = new Scanner(System.in);

    @Override
    public void executePayroll() {
        System.out.println("What is project cost? ");
        perProjectCost = sc.nextInt();
        System.out.println("Your commission percentage: ");
        commission = sc.nextInt();
        System.out.println("How many did you sell? ");
        noOfProjects = sc.nextInt();
        System.out.println("Commission per single project: "+ ((commission * perProjectCost)/100));
        totalCommissionedPay = ((commission * perProjectCost)/100)*noOfProjects;
        System.out.println("Total pay after all commissions: "+ totalCommissionedPay);
    }

}
class HourlyEmployee extends Employee{
    int hourlyRate = 0;
    int totalHoursGiven = 0;
    Scanner sc = new Scanner(System.in);

    @Override
    public void executePayroll() {
        System.out.println("How much do you charge per hour: ");
        hourlyRate = sc.nextInt();
        System.out.println("How many hours did you work? ");
        totalHoursGiven = sc.nextInt();
        System.out.println("Total hourly salary: "+ (hourlyRate*totalHoursGiven));
    }

}
class BasePlusCommissionedEmployee extends CommissionedEmployee{

    int totalPayAfterCommissionsAndBase = 0;
    @Override
    public void executePayroll() {
        super.executePayroll();
        System.out.println("Your base pay (other than commissions): ");
        totalPayAfterCommissionsAndBase = totalCommissionedPay + sc.nextInt();
        System.out.println("Base + Commissioned Pay = "+totalPayAfterCommissionsAndBase);
    }

}
