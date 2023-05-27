package MVMContract;

import java.time.LocalDate;
public class Invoice {
    private Customer name;
    private Customer email; // tulaj, akinek szól
    private int actualAmountOfPayable;
    private LocalDate dateOFIssue; // idopont, amikor befizetesre kerult sor
    private LocalDate deadline; // hatarido
    private boolean isFulfilled; // whether paid in or not
    private MVMContract.Customer customer;

    //public static ArrayList<Invoice> invoices = new ArrayList<>();

    public Invoice(Customer name, Customer email, int actualAmountOfPayable, LocalDate dateOFIssue, LocalDate deadline, boolean isFulfilled,
                   MVMContract.Customer Customer) {
        this.name = name;
        this.email = email;
        this.actualAmountOfPayable = actualAmountOfPayable;
        this.dateOFIssue = dateOFIssue;
        this.deadline = deadline;
        this.isFulfilled = isFulfilled;
        this.customer = Customer;
    }

    // Methods:

    public static int delayedPayment(LocalDate dateOfIssue, LocalDate actualPaymentDate){
        return 5;
    }

    public static Invoice createNewInvoice(Customer name, Customer email, int actualAmountOfPayable,
                                           LocalDate dateOFIssue, LocalDate deadline, boolean isFulfilled, MVMContract.Customer customer){
        return new Invoice(name, email, actualAmountOfPayable, dateOFIssue, deadline, isFulfilled, customer);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }

    public Customer getName() {
        return name;
    }

    public void setName(Customer name) {
        this.name = name;
    }
    public Customer getEmail() {
        return email;
    }

    public void setEmail(Customer email) {
        this.email = email;
    }
    public int getActualAmountOfPayable() {
        return actualAmountOfPayable;
    }

    public void setActualAmountOfPayable(int actualAmountOfPayable) {
        this.actualAmountOfPayable = actualAmountOfPayable;
    }

    public LocalDate getDateOFIssue() {
        return dateOFIssue;
    }

    public void setDateOFIssue(LocalDate dateOFIssue) {
        this.dateOFIssue = dateOFIssue;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Customer getOwner(){
        return email;
    }
    public void setOwner(Customer email){
        this.email = email;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean isFulfilled) {
        this.isFulfilled = isFulfilled;
    }


}
