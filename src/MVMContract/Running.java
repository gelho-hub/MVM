package MVMContract;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Running implements Serializable {
    private Customers customers;
    private Register register;
    private Login login;
    private String username;
    private Customer customer;
    private Invoice invoice;
    
    public void run(){
        readCustomers("customers.ser");
        int command;
        loginMenu();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" 1 - Szerződés adatai");
            System.out.println(" 2 - Számlák listázása");
            System.out.println(" 3 - Saját adatok kilistázása");
            System.out.println(" 4 - Adatmódosítás");
            System.out.println(" 5 - Számla létrehozása");
            System.out.println(" 6 - Kijelentkezés");
            System.out.println(" 7 - Kilépés");
            
            command = Integer.parseInt(sc.nextLine());
            switch (command) {
                case 1:
                    getContractData(); //todo modosit
                    break;
                case 2:
                    listInvoices();
                    break;
                case 3:
                    listOwnData(); //todo modosit
                    break;
                    //todo --> list own data
                case 4:
                    editData();
                    customers.write("customers.ser");
                    break;
                case 5:
                    createInvoice();
                    break;
                case 6:
                    loginMenu();
                    customers.write("customers.ser");
                    break;
                case 7:
                    sc.close();
                    customers.write("customers.ser");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont, kérlek a fentiekből válassz!");
                    break;
            }
        }
    }

    private int runLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Felhasználónév: ");
        username = sc.nextLine();
        System.out.print("Jelszó: ");
        String password = sc.nextLine();
        login = new Login(username, password, customers);
        int returnCode = login.login();
        System.out.println(returnCode);
        return returnCode;
    }

    private int runRegister() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Felhasználónév: ");
        String username = sc.nextLine();
        System.out.print("Jelszó: ");
        String password = sc.nextLine();
        register = new Register(username, password, customers);
        int returnCode = register.register();
        System.out.println(returnCode);
        return returnCode;
    }

    private void loginMenu() {
        boolean isLogged = false;
        int command;
        Scanner sc = new Scanner(System.in);
        while (!isLogged) {
            System.out.println("Üdv a programban, válassz az alábbi lehetőségek közül: ");
            System.out.println("1 - Bejelentkezés");
            System.out.println("2 - Regisztráció");

            command = sc.nextInt();
            switch (command) {
                case 1:
                    switch (runLogin()) {
                        case 404:
                            System.out.println("Még nem regisztáltál!");
                            break;
                        case 401:
                            System.out.println("Sikertelen belépés, próbáld újra");
                            break;
                        case 200:
                            System.out.println("Sikeres belépés!");

                            customer = customers.getCustomer(username);
                            isLogged = true;
                        default:
                            break;
                    } 
                    break;
                case 2:
                    switch (runRegister()) {
                        case 400:
                            System.out.println("A felhasználó már regisztrálva van!");
                            break;
                        case 200:
                            System.out.println("Sikeresen regisztrálva!\nInditsd ujra a programot!");
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /*private void readInvoices(String filename){
        invoice = Customer.read(filename);
        if(invoice == null){
            invoice = new Invoice();
        }
    }*/


    private void readCustomers(String filename){
        customers = Customers.read(filename);
        if (customers == null) {
            customers = new Customers();
        }
        System.out.println("Eddig regisztrált felhasználók: ");

        for (Customer customer : customers.getCustomers()) {
            System.out.println(customer.getName());
        }
        System.out.println(" ");
    }

    private void getContractData(){
        if(customer.getContract() == null){
            System.out.println("Még nincs szerződésed"); //todo itt modosult
        }else{
            System.out.println("Szerződésszám: " + customer.getContract().getContractNumber() + "\n" +
                    "Szerződéskötés ideje: " + customer.getContract().getAccOpeningTime() + " --- " +
                    customer.getContract().getTime().getHour() +":"+customer.getContract().getTime().getMinute() + "\n" +
                    "Név: " + customer.getName()
                    + "\nFelhasználónév: " + customer.getNickname());

            System.out.println(" ");
        }
    }

    private void listInvoices(){
        if (customer.getInvoices().size() == 0){
            System.out.println("Még nincs számlád létrehozva.");
        }else{
            /*for (int i = 0; i < customer.getInvoices().size(); i++) {
                System.out.println(*//*"ID: " + customer.getInvoices().get(i).getInvoiceID() +*//* "Név: " +
                        customer.getInvoices().get(i).getOwner().getName() + " "+ customer.getInvoices().get(i).getDateOFIssue() + " "+
                        "Határidő: " + customer.getInvoices().get(i).getDeadline() + " " + customer.getInvoices().get(i).getActualAmountOfPayable());
            }*/
            for (int i = 0; i < customer.getInvoices().size(); i++) {
                System.out.println("NÉV: "+ customer.getInvoices().get(i).getOwner().getName()+" " +"Dátum: " + //todo mod
                        customer.getInvoices().get(i).getDateOFIssue()+" "+"Határidő: " +
                        customer.getInvoices().get(i).getDeadline()+ " "+"Fizetendő összeg: " +
                        customer.getInvoices().get(i).getActualAmountOfPayable());
            }
            System.out.println(" ");
        }
        //todo
    }

    private void listOwnData(){
        Scanner sc = new Scanner(System.in);

        customer = customers.getCustomer(username); //todo itt az egyik mod

        System.out.println("Név: " + customer.getName());
        System.out.println("Felhasználónév: " + customer.getNickname());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Születési dátum: " + customer.getYearOfBirth());

        System.out.println(" ");
        System.out.println("Kilépéshez: v");
        if(sc.nextLine().equals("v")){
            return;
        }
        sc.close();
    }
    private void createInvoice() {

        Random rnd = new Random();
        int min = 5000;
        int max = 30000;

        LocalDate date = LocalDate.now();
        int newRndNum = rnd.nextInt(max - min + 1) /*+ max*/;

        if (customer.getContract() == null){
            System.out.println("Még nincs szerződésed, hozz létre egyet, hogy kiállíthass számlát!");
            return;
        }
        customer.setInvoice(new Invoice(customer, newRndNum, date,
                date.plusWeeks(1), false));

        System.out.println("Számla sikeresen létrehozva!");
        System.out.println(" ");
    }
    /*private void createContract(){ //todo létrehozni Szerződést!
        customer.getContract();

    }*/
    private void editData(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Név");
        System.out.println("2 - Felhasználónév");
        System.out.println("3 - Jelszó");
        System.out.println("4 - Email");
        System.out.println("0 - Kilépés");


        String command = sc.nextLine();

        switch (command){
            case "0":
                return;
            case "1":
                modifyNAME();
                break;
            case "2":
                modifyNICKNAME();
                break;
            case "3":
                modifyPASSWORD();
                break;
            case "4":
                modifyEMAIL();
                break;
            default:
                return;
        }
        sc.close();
    }

    private void modifyNAME(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Új név: ");
        String newName = sc.nextLine();



        customers.removeCustomer(/*customer*/);

        customer.setName(newName);
        customers.addCustomer(new Customer(username, customer.getPassword(), customer.getEmail(),
                newName, customer.getYearOfBirth()));

        customers.write("customers.ser");
        System.out.println("Kérlek indítsd újra a programot!");
        sc.close();
        System.exit(0);
    }

    private void modifyNICKNAME(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Új felhasználónév: ");
        String newNickName = sc.nextLine();



        customers.removeCustomer(/*customer*/);

        customer.setNickname(newNickName);
        customers.addCustomer(new Customer(newNickName, customer.getPassword(), customer.getEmail(),
                customer.getName(), customer.getYearOfBirth()));
        customers.write("customers.ser");
        System.out.println("Kérlek indítsd újra a programot!");
        sc.close();
        System.exit(0);
    }

    private void modifyPASSWORD(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Új név: ");
        String newPassword = sc.nextLine();

        customers.removeCustomer(/*customer*/);

        customer.setNickname(newPassword);
        customers.addCustomer(new Customer(username, newPassword, customer.getEmail(),
                customer.getName(), customer.getYearOfBirth()));
        customers.write("customers.ser");
        System.out.println("Kérlek indítsd újra a programot!");
        sc.close();
        System.exit(0);
    }
    private void modifyEMAIL(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Új név: ");
        String newEMAIL = sc.nextLine();



        customers.removeCustomer(/*customer*/);

        customer.setNickname(newEMAIL);
        customers.addCustomer(new Customer(username, customer.getPassword(), newEMAIL,
                customer.getName(), customer.getYearOfBirth()));

        customers.write("customers.ser");
        System.out.println("Kérlek indítsd újra a programot!");
        sc.close();
        System.exit(0);
    }

     public static void main(String[] args) {
        Running running  = new Running();
        running.run();
     }
}
