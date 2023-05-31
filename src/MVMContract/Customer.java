package MVMContract;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class Customer implements Serializable{
    private String nickname;
    private String password;
    private String email;
    private String name;
    private LocalDate yearOfBirth;
    private Contract contract;
    private Invoice invoice;

    private ArrayList<Invoice> invoices = new ArrayList<>();

    public Customer(){

    }

    public Customer(String nickname, String password, String email, String name, LocalDate yearOfBirth, // constructor with contract
                    Contract contract){
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.contract = contract;
    }
    /*public Customer(String nickname, String password, String email, String name, LocalDate yearOfBirth, // constructor with invoice
                   Invoice invoice){
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.invoice = invoice;
    }*/
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

    /*public void addInvoice(Invoice invoice){ // ezzel fogunk egy újonnan létrehozott számlát hozzáadni a listához
        invoices.add(invoice);
    }*/

    public Invoice getInvoice(String name){
        for (Invoice invoice : invoices){
            if(name.equals(invoice.getOwner().name)) return invoice;
        }
        return null;
    }

    /*public void write(String fileName){
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(this);
            out.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            System.err.println("Sikertelen írás");
        }
    }*/

    /*public static Invoice read(String fileName){ // újonnan létrehozott metódus ami a számlákat hivatott kiírni fájlba
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
    }*/



    // getters, setters
    public ArrayList<Invoice> getInvoices() {
        return invoices;
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
        invoices.add(invoice);
    }

    public void createContract(){
        Contract newContract = new Contract();
    }
}
