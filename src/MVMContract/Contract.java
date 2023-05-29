package MVMContract;

import java.io.Serializable;
import java.time.LocalDate;


public class Contract implements Serializable {
    private Customer name;
    private LocalDate accOpeningTime;
    private int sumOfPaidIn;
    private LocalDate nextInvoiceDate;
    private String contractID;

    public Contract(){

    }

    public Contract(Customer name, LocalDate accOpeningTime, LocalDate nextInvoiceDate, String contractID) {
        this.name = name;
        this.accOpeningTime = accOpeningTime;
        this.sumOfPaidIn = 0;
        this.nextInvoiceDate = nextInvoiceDate;
        this.contractID = contractID;
    }

    public String createContractNum(LocalDate accOpeningTime){
        int y = accOpeningTime.getYear();
        int m = accOpeningTime.getMonthValue();
        int d = accOpeningTime.getDayOfMonth();

        String yStr = Integer.toString(y);
        String mStr = Integer.toString(m);
        String dStr = Integer.toString(d);

        return dStr + mStr + yStr;
    }

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

    public String getContractNumber() {
        return contractID;
    }

    public void setContractNumber(String contractID) {
        this.contractID = contractID;
    }
}
