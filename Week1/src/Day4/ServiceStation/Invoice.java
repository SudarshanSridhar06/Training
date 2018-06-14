/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day4.ServiceStation;

/**
 *
 * @author cb-sudarshan
 */
public class Invoice {
    private static int count = 100;
    private final int invoive_no;
    private final Person customer;
    private final Person employee;
    private final int total_amount;

    public Invoice(Person customer, Person employee) {
        this.invoive_no = ++Invoice.count;
        this.customer = customer;
        this.employee = employee;
        total_amount = customer.getVehicle().getEmployee_charge() + customer.getVehicle().getService_charge();
    }
    
    public void display(){
        System.out.println("\nInvoice No : " + this.invoive_no + " Customer Name : " + this.customer.getName());
        System.out.println("Total Amount : " + this.total_amount + " Employee Name : " + this.employee.getName());
        System.out.println("Service Vehicle : " + this.customer.getVehicle().getType() + " Service Type : " + this.customer.getVehicle().getService() );
        System.out.println("Customer Id : " + this.customer.getCustomer_id() + " Employee id : " + this.employee.getEmployee_id());
    }
    
}
