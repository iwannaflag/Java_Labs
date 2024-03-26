package Labs.Lab03;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        Employee manager = new Manager(r.next(), r.nextInt(), r.nextDouble());
        Employee seller = new Seller(r.next(), r.nextInt(), r.nextInt(), r.nextDouble());
        r.close();
        SalaryService salaryService = new SalaryService(manager, seller);
        double salary = salaryService.getTotalSalaries();
        System.out.printf("薪资总额: %.2f", salary);
    }
}

interface Workable{
    double salary = 0;

    void updateName(String NewName);
    double calculateSalary();
}

abstract class Employee implements Workable{
    String EmployeeName;
    int BasicPay;

    public Employee(String employeeName, int basicPay) {
        this.EmployeeName = employeeName;
        this.BasicPay = basicPay;
    }

    @Override
    public void updateName(String NewName){
        this.EmployeeName = NewName;
    }
}

class Manager extends Employee{
    double rank;

    public Manager(String employeeName, int basicPay, double rank) {
        super(employeeName, basicPay);
        this.rank = rank;
    }

    @Override
    public double calculateSalary() {
        double salary;
        salary = this.BasicPay * this.rank * 0.8;
        return salary;
    }
}
class Seller extends Employee{
    int Sales_volume;
    double Sales_commission;
    public Seller(String employeeName, int basicPay, int sales_volume, double sales_commission) {
        super(employeeName, basicPay);
        Sales_volume = sales_volume;
        Sales_commission = sales_commission;
    }
    @Override
    public double calculateSalary() {
        double salary;
        salary = this.BasicPay + this.Sales_volume * this.Sales_commission;
        return salary;
    }
}

class SalaryService {
    Employee manager;
    Employee seller;

    public SalaryService(Employee manager, Employee seller) {
        this.manager = manager;
        this.seller = seller;
    }
    double getTotalSalaries(){
        double TotalSalaries;
        TotalSalaries = this.manager.calculateSalary() + this.seller.calculateSalary();
        return TotalSalaries;
    }
}
