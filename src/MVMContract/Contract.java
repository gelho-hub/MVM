package MVMContract;

import java.time.LocalDate;


public class Contract{
    private Customer name;
    private LocalDate accOpeningTime;
    private int sumOfPaidIn;
    private LocalDate nextInvoiceDate;

    public Contract(Customer name, LocalDate accOpeningTime, LocalDate nextInvoiceDate) {
        this.name = name;
        this.accOpeningTime = accOpeningTime;
        this.sumOfPaidIn = 0;
        this.nextInvoiceDate = nextInvoiceDate;
    }

    /*public static void createContract(){
        String name = IO.sc.nextLine();
        LocalDate
        Contract contract = new Contract()

    }*/
    public Customer getName() {
        return name;
    }

    public void setName(Customer name) {
        this.name = name;
    }

    public LocalDate getAccOpeningTime() {
        return accOpeningTime;
    }

    public void setAccOpeningTime(LocalDate accOpeningTime) {
        this.accOpeningTime = accOpeningTime;
    }

    public int getSumOfPaidIn() {
        return sumOfPaidIn;
    }

    public void setSumOfPaidIn(int sumOfPaidIn) {
        this.sumOfPaidIn = sumOfPaidIn;
    }

    public LocalDate getNextInvoiceDate() {
        return nextInvoiceDate;
    }

    public void setNextInvoiceDate(LocalDate nextInvoiceDate) {
        this.nextInvoiceDate = nextInvoiceDate;
    }
}
