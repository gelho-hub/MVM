package MVMContract;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Running {
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
            //System.out.println(" 2 - Számlák listázása");
            System.out.println(" 3 - Saját adatok kilistázása");
            System.out.println(" 4 - Adatmódosítás");
            //System.out.println(" 5 - Szerződés létrehozása");
            System.out.println(" 6 - Számla létrehozása");
            //System.out.println(" 7 - Befizetés");
            //System.out.println(" 8 - Hátralévő befizetések");
            System.out.println(" 9 - Kijelentkezés");
            System.out.println("10 - Kilépés");
            
            command = Integer.parseInt(sc.nextLine());
            switch (command) {
                case 1:
                    getContractData();
                    break;
                case 2:
                    listContracts();
                    break;
                case 3:
                    listOwnData();
                    break;
                    //todo --> list own data
                case 4:
                    editData();
                    break;
                case 6:
                    createInvoice();
                case 9:
                    loginMenu();
                case 10:
                    sc.close();
                    System.exit(0);
                    break;
                default:
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

    private void editingMenu(){

    }

    private void readInvoices(String filename){
        invoice = Invoice.read(filename);
        if(invoice == null){
            invoice = new Invoice();
        }
    }


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
            System.out.println("Még nincs szerződésed");
        }else{
            System.out.println("Név: " + customer.getContract().getContractNumber() + "\nJelszó: " + customer.getPassword()
                    + "\nBecenév: " + customer.getNickname());
        }
    }

    private void listContracts(){
        //todo
    }

    private void listOwnData(){
        Scanner sc = new Scanner(System.in);
        for (Customer customer1 : customers.getCustomers()){
            System.out.println("Név: "+customer1.getName() +"\n"+"Felhaszálónév: "+ customer1.getNickname() +"\n"+
                    "Email cím: "+ customer1.getEmail() +"\n"+"Születési dátum: "+ customer1.getYearOfBirth());
        }
        System.out.println("Kilépéshez: v");
        if(sc.nextLine().equals("v")){
            return;
        }
        sc.close();
    }
    private void createInvoice(){

        Random rnd = new Random();
        int min = 5000;
        int max = 30000;

        readInvoices("invoices.ser");
        LocalDate date = LocalDate.now();
        int newRndNum = rnd.nextInt(max - min + 1) + max;

        customer.addInvoice(new Invoice(invoice.getOwner(), newRndNum, date,
                date.plusWeeks(1), true, invoice.createInvoiceID(date)));
        customer.write("invoices.ser");

    }



    private void createContract(){

    }
    private void editData(){
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Név");
        System.out.println("2 - Becenév");
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
            case "4":
                modifyEMAIL();
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


        System.out.println("Új név: ");
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
