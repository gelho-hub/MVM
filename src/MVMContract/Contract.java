package MVMContract;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Contract implements Serializable {
    private Customer name;
    private LocalDate accOpeningDate;
    private LocalDateTime time;
    private int sumOfPaidIn;
    private LocalDate nextInvoiceDate;
    private String contractID;

    public Contract(){

    }

    public Contract(Customer name, LocalDate accOpeningDate, LocalDateTime time, String contractID) {
        this.name = name;
        this.accOpeningDate = accOpeningDate;
        this.time = time;
        this.sumOfPaidIn = 0;
        this.contractID = contractID;
    }

    public String createContractNum(LocalDate accOpeningDate){
        int y = accOpeningDate.getYear();
        int m = accOpeningDate.getMonthValue();
        int d = accOpeningDate.getDayOfMonth();

        String yStr = Integer.toString(y);
        String mStr = Integer.toString(m);
        String dStr = Integer.toString(d);

        return dStr + mStr + yStr;
    }


    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Customer getName() {
        return name;
    }

    public void setName(Customer name) {
        this.name = name;
    }

    public LocalDate getAccOpeningTime() {
        return accOpeningDate;
    }

    public void setAccOpeningTime(LocalDate accOpeningDate) {
        this.accOpeningDate = accOpeningDate;
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

    public String getContractNumber() {
        return contractID;
    }

    public void setContractNumber(String contractID) {
        this.contractID = contractID;
    }
}
