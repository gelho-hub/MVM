package MVMContract;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Invoice {
    private Customer owner; // tulaj, akinek szól
    private int actualAmountOfPayable;
    private LocalDate dateOFIssue; // idopont, amikor befizetesre kerult sor
    private LocalDate deadline; // hatarido --> ez megy a Contract osztály
    private boolean isFulfilled; // whether paid in or not
    private String invoiceID;

    public Invoice(Customer owner, int actualAmountOfPayable, LocalDate dateOFIssue, LocalDate deadline, boolean isFulfilled, String invoiceID) {
        this.owner = owner;
        this.actualAmountOfPayable = actualAmountOfPayable;
        this.dateOFIssue = dateOFIssue;
        this.deadline = deadline;
        this.isFulfilled = false;
        this.invoiceID = invoiceID;
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

    public static Invoice read(String fileName){
        Invoice readInvoices;
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream obj = new ObjectInputStream(f);
            readInvoices = (Invoice)obj.readObject();
            obj.close();
            return readInvoices;
        }
        catch (FileNotFoundException e){
            return null;
        }
        catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

    public int delayedPayment(LocalDate dateOfIssue, LocalDate actualPaymentDate){
        return 5;
    }

    public static Invoice createNewInvoice(Customer name, int actualAmountOfPayable,
                                           LocalDate dateOFIssue, LocalDate deadline, boolean isFulfilled, String invoiceID){
        return new Invoice(name, actualAmountOfPayable, dateOFIssue, deadline, isFulfilled, invoiceID);
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
