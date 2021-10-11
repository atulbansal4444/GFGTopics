package Set;

import java.util.HashSet;
import java.util.Set;

public class Customer
{
    String name;
    int age;

    Customer(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args)
    {
        Customer c1 = new Customer("John", 20);
        Customer c2 = new Customer("John", 20);

        Set<Customer> customerSet = new HashSet<>();
        customerSet.add(c1);
        customerSet.add(c2);

        System.out.println(customerSet.size()); // size is 2
    }
}