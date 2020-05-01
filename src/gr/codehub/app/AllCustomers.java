package gr.codehub.app;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AllCustomers {

    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void displayListofCustomers(){

        customers.forEach(System.out::println);


        for(Customer c : customers) {
            System.out.println(c.getCustomerCode() + "," + c.getLastName() + "," + c.getSareName()
                                + "," + c.getSex() + "," + c.getDateofBarth() + "," + c.getTelephone());
        }


        //customers.forEach( customer -> System.out.println(customer));
    }

    public int numofCustomers(){
        return customers.size();
    }

    public void removeCustomer(int index){
        if (index>=0 && index <= customers.size()){
            customers.remove(index);
        }
    }


    public void clearCustomers () {
        customers.clear();
    }

    public void saveCustomerslist(String filename)   {

        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for (Customer c : customers) {
                printWriter.println(c.getCustomerCode() + "," + c.getLastName() + "," + c.getSareName() + "," + c.getSex()
                        + "," + c.getDateofBarth() + "," + c.getTelephone());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }

    }

    public void loadCustomerslist(String filename){
        customers.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] words = line.split(",");
                Customer customer = new Customer(
                        words[0],
                        words[1],
                        words[2],
                        words[3],
                        words[4],
                        words[5]);
                customers.add(customer);
            }
        } catch (Exception e) {
        }
    }




}
