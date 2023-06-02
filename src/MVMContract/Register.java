package MVMContract;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Register extends UserAction{
    private String name;
    private String email;
    private String yearOfBirth;
    private Contract contractData;

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
        System.out.print("Születési dátum: (YYYY, MM, DD)");
        yearOfBirth = sc.nextLine();
        DateValidator.checkDate(yearOfBirth);

        System.out.println("A formátum eddig jó. ");// just for self-check
        String[] birthdayElements = yearOfBirth.split(", ");

        LocalDate localbirthday = DateValidator.splitDateElements(birthdayElements);
        Contract con = new Contract();

        Contract contract = new Contract(customers.getCustomer(name), LocalDate.now(), LocalDateTime.now(),
                con.createContractNum(LocalDate.now())); //todo itt
        customers.addCustomer(new Customer(username, password, email, name, localbirthday, contract));

        customers.write("customers.ser");
        return 200;
    }
}
