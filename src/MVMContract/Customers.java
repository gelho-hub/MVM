package MVMContract;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customers implements Serializable{
    private ArrayList<Customer> customers = new ArrayList<>();

    public Customers() {

    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void removeCustomer(/*Customer customer*/){
        customers.clear();
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
    public Customer getCustomer(String username){
        for (Customer customer : customers) {
            if (username.equals(customer.getName())) return customer;
        }
        return null;
    }
    public boolean isCustomerAdded(String username){
        for (Customer customer : customers) {
            return (username.equals(customer.getNickname())) ? true : false;
        }
        return false;
    }

    public void write(String fileName){
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(this);
            out.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            System.err.println("Sikertelen írás");
        }
    }

    public static Customers read(String fileName){
        Customers readCustomers;
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream obj = new ObjectInputStream(f);
            readCustomers = (Customers)obj.readObject();
            obj.close();
            return readCustomers;
        } 
        catch (FileNotFoundException e){
            return null;
        }
        catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }
}
