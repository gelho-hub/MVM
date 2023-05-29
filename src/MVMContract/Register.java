package MVMContract;

import java.time.LocalDate;
import java.util.Scanner;

public class Register extends UserAction{
    private String name;
    private String email;
    private String yearOfBirth;

    public Register(String username, String password, Customers customers) {
        super(username, password, customers);
    }

    public int register() {
        if (isUserRegistered()) {
            return 400;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("E-mail: ");
        email = sc.nextLine();
        System.out.print("Név: ");
        name = sc.nextLine();
        System.out.print("Születési év: ");
        yearOfBirth = sc.nextLine();
        DateValidator.checkDate(yearOfBirth);

        System.out.println("A formátum eddig jó. ");// just for self-check
        String[] birthdayElements = yearOfBirth.split(", ");

        // Contract newContract = new Contract(fullname, LocalDate.now(), LocalDate.now().plusMonths(1), createContractNum(LocalDate.now()));

        LocalDate localbirthday = DateValidator.splitDateElements(birthdayElements);
        customers.addCustomer(new Customer(username, password, email, name, localbirthday));
        customers.write("customers.ser");
        return 200;
    }
}
