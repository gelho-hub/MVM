package MVMContract;

import java.util.ArrayList;
import java.time.LocalDate;

public class Customer {
    private String nickname;
    private String password;
    private String email;
    private String name;
    private LocalDate yearOfBirth;
    private Contract contract;
    private Invoice invoice;



    public static ArrayList<Contract> contracts = new ArrayList<>();
    public static ArrayList<Invoice> invoices = new ArrayList<>();

    // static: mindenhonnan elérhető
    // public static ArrayList<Customer> profiles = new ArrayList<>();

    public Customer(){

    }

    public Customer(String nickname, String password, String email, String name, LocalDate yearOfBirth, // constructor with contract and invoice
                    Contract contract, Invoice invoice){
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.contract = contract;
        this.invoice = invoice;
    }
    public Customer(String email){
        this.email = email;
    }

    public Customer(String nickname, String password, String email, String name, LocalDate yearOfBirth){
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    // methods

    public static boolean hasInvoice(MVMContainer container){
        for (int i = 0; i < MVMContainer.customers.size(); i++) {
            if(MVMContainer.customers.get(i).getName().equals(invoices.get(i).getName().toString())){
                return true;
            }
        }
        return false;
    }

    // getters, setters
    public static ArrayList<Contract> getContracts() {
        return contracts;
    }

    public static void setContracts(ArrayList<Contract> contracts) {
        Customer.contracts = contracts;
    }

    public static ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(ArrayList<Invoice> invoices) {
        Customer.invoices = invoices;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
