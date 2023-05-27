package MVMContract;

import java.util.Comparator;
public class NameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer b1, Customer b2){
        String n1 = b1.getName();
        String n2 = b2.getName();

        return n1.compareTo(n2);
    }
}
