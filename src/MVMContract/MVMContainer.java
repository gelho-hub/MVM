package MVMContract;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MVMContainer {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();


    public static void createProfile(){
        System.out.println("Add meg a következő adataid: ");
        System.out.println(" ");

        System.out.println("Email címed: ");

        String email = IO.sc.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            while(true){
                if(customers.get(i).getEmail().equals(email)){
                    System.out.printf("Ilyen email címmel [ %s ] már regisztráltak profilt, kérlek próbáld újra%n!", email);
                    email = IO.sc.nextLine();
                }else{break;}
            }
        }
        System.out.println("Jelszó: ");
        String password = IO.sc.nextLine();

        System.out.println("Név: ");
        String name = IO.sc.nextLine();

        System.out.println("Becenév: ");
        String nickname = IO.sc.nextLine();

        System.out.println("Születési dátum: (YYYY, MM, DD) formátumban");

        String birthday = IO.sc.nextLine();
        DateValidator.checkDate(birthday);

        System.out.println("A formátum eddig jó. ");// just for self-check
        String[] birthdayElements = birthday.split(", ");

        LocalDate localbirthday = DateValidator.splitDateElements(birthdayElements);
        // String nickname, String password, String email, String name, LocalDate yearOfBirth
        Customer newCustomer = new Customer(nickname, password, email, name, localbirthday); // constructor without contract and any invoices

        customers.add(newCustomer); // itt történik a profil hozzáadása a listához

        System.out.println("Profil sikeresen létrehozva!✅");
        System.out.println(" ");
        System.out.printf("Üdv a programban %s!%n", nickname);
        System.out.println("Kérlek a folytatáshoz jelentkezz be!");
    }

    public static boolean logIn(){

        String emailaddress = "";
        String password = "";
        while(customers.isEmpty()){

            System.out.printf("Email cím: %n");
            emailaddress = IO.sc.nextLine();

            if(emailaddress.equals("1")){
                return false;
            }

            System.out.printf("Jelszó: %n");
            password = IO.sc.nextLine();
            System.out.println("Email cím vagy jelszó nem helyes, próbáld újra, vagy lépj vissza (1)");

        }


        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("Email cím: %n");
            emailaddress = IO.sc.nextLine();

            System.out.printf("Jelszó: %n");
            password = IO.sc.nextLine();


            Iterator<Customer> iterator = customers.iterator();
            while (iterator.hasNext()) {
                Customer customer = iterator.next();

                // Check if email and password match
                if (customer.getEmail().equals(emailaddress) && customer.getPassword().equals(password)) {
                    System.out.println("Sikeres bejelentkezés");
                    String choice = afterLogin();
                    return choice.equals("2") || choice.equals("n");
                }
            }
        }
        Customer c = new Customer(emailaddress);

        System.out.println(" ");
        System.out.println("Sikeres bejelentkezés");
        String choice = afterLogin();
        if(choice.equals("2") || choice.equals("n")){
            return true;
        }
        return false;
    }

    public static String afterLogin(/*Customer customer*/){
        String answer = "";
        if(Customer.invoices.isEmpty() && Customer.contracts.isEmpty()){
            System.out.println("Még nincs számlád és szerződésed. Most létrehozhatsz egyet (1), vagy a főmenübe léphetsz (2)");
            answer = IO.sc.nextLine();
        }else if(Customer.invoices.isEmpty()){
                System.out.println("Még nincs számlád létrehozva. Szeretnél létrehozni egyet? (y, n)");
                answer = IO.sc.nextLine();
        }
        for (int i = 0; i < Customer.invoices.size(); i++) {

            /*if(Customer.invoices.get(i).getName().equals(Customer.)){
                ;
            }*/
        }
        return answer;
    }

    public static void listProfileData(){
        customers.sort(new NameComparator());
        for (Customer i : customers) {
            System.out.println(i);
        }
    }





}
