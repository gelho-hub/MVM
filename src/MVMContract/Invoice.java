package MVMContract;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Invoice implements Serializable {
    private Customer owner; // tulaj, akinek szól
    private int actualAmountOfPayable;
    private LocalDate dateOFIssue; // idopont, amikor befizetesre kerult sor
    private LocalDate deadline; // hatarido --> ez megy a Contract osztály
    private boolean isFulfilled; // befizette vagy sem
    private String invoiceID;

    public Invoice(Customer owner, int actualAmountOfPayable, LocalDate dateOFIssue, LocalDate deadline, boolean isFulfilled) {
        this.owner = owner;
        this.actualAmountOfPayable = actualAmountOfPayable;
        this.dateOFIssue = dateOFIssue;
        this.deadline = deadline;
        this.isFulfilled = false;
    }

    public Invoice(){

    }

    // Methods:

    public String createInvoiceID(LocalDate dateOFIssue){
        int year = dateOFIssue.getYear();
        int month = dateOFIssue.getMonthValue();
        int day = dateOFIssue.getDayOfMonth();

        String y = Integer.toString(year);
        String m = Integer.toString(month);
        String d = Integer.toString(day);

        return d + m + y;
    }



    public int delayedPayment(LocalDate dateOfIssue, LocalDate actualPaymentDate){
        return 5;
    }

    public static Invoice createNewInvoice(Customer name, int actualAmountOfPayable,
                                           LocalDate dateOFIssue, LocalDate deadline, boolean isFulfilled){
        return new Invoice(name, actualAmountOfPayable, dateOFIssue, deadline, isFulfilled);
    }

    public Customer getOwner(){
        return owner;
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

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean isFulfilled) {
        this.isFulfilled = isFulfilled;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }
}
