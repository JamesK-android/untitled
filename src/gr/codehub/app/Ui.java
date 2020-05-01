package gr.codehub.app;

import java.util.Scanner;

public class Ui {

    public Choice menu() {

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return Choice.ADD;
                case 2:
                    return Choice.REMOVE;
                case 3:
                    return Choice.DISPLAY;
                case 4:
                    return Choice.CLEAR;
                case 5:
                    return Choice.TOTALCOST;
                case 6:
                    return Choice.SAVE;
                case 7:
                    return Choice.LOAD;
                case 0:
                    return Choice.EXIT;
                default:
                    return Choice.ERROR;
            }
        } catch (Exception e) {
            return Choice.ERROR;
        }

    }


    //factory method design pattern
    public Product createProduct() {
        String code;
        String name;
        float price;
        int quantity;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the product code ");
        code = scanner.next();
        System.out.println("Give the product name ");
        name = scanner.next();
        System.out.println("Give the product price ");
        price = scanner.nextFloat();
        System.out.println("Give the product quantity ");
        quantity = scanner.nextInt();

        Product product = new Product(code, name, price, quantity);

        return product;

    }

    public Customer createCustomer() {
        String code;
        String sarename;
        String lastname;
        String sex;
        String dateofbarth;
        String telephone;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the customer code");
        code = scanner.next();
        System.out.println("Give the last name");
        lastname = scanner.next();
        System.out.println("Give the sare name");
        sarename = scanner.next();
        System.out.println("Give the sex");
        sex = scanner.next();
        System.out.println("Give the date of bearth");
        dateofbarth = scanner.next();
        System.out.println("Give the phone");
        telephone = scanner.next();

        Customer customer = new Customer(code, lastname, sarename, sex, dateofbarth, telephone);

        return customer;
    }

    public void manageCustomer(Basket basket,AllCustomers allcustomer) {
        Choice choice;
        do {
            System.out.println("1. Add a customer   2. Remove a customer" +
                    "    3. Display customers     4.  Clear customers" +
                    "   5. Total customers    6.Save customers   7.Load customers   0.Exit");
            choice = menu();

            switch (choice) {
                case ADD:
                    Customer customer = createCustomer();
                    allcustomer.addCustomer(customer);
                    break;
                case REMOVE:
                    System.out.println("Give an index to remove");
                    Scanner scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    allcustomer.removeCustomer(index);
                    break;
                case DISPLAY:
                    allcustomer.displayListofCustomers();
                    break;
                case CLEAR:
                    allcustomer.clearCustomers();
                    break;
                case TOTALCOST:
                    System.out.println("Number of customers = " + allcustomer.numofCustomers());
                    break;
                case EXIT:
                    break;
                case SAVE:
                    allcustomer.saveCustomerslist("customerlist.txt");
                    break;
                case LOAD:
                    allcustomer.loadCustomerslist("customerlist.txt");
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;

            }
        } while (choice != Choice.EXIT);
        choosetoManage(basket, allcustomer);
    }


    public void manageBasket(Basket basket,AllCustomers allcustomer) {
        Choice choice;
        do {
            System.out.println("1. Add a product to Basket   2. Remove a product" +
                    "    3. Display basket     4.  Clear basket" +
                    "   5. Totalcost    6.Save basket   7.Load basket   0.Exit");
            choice = menu();

            switch (choice) {
                case ADD:
                    Product product = createProduct();
                    basket.addProduct(product);
                    break;
                case REMOVE:
                    System.out.println("Give an index to remove");
                    Scanner scanner = new Scanner(System.in);
                    int index = scanner.nextInt();
                    basket.removeProduct(index);
                    break;
                case DISPLAY:
                    basket.displayProducts();
                    break;
                case CLEAR:
                    basket.clearProducts();
                    break;
                case TOTALCOST:
                    System.out.println("TotalCost= " + basket.getTotalCost());
                    break;
                case EXIT:
                    break;
                case SAVE:
                    basket.saveBasket("basket.txt");
                    break;
                case LOAD:
                    basket.loadBasket("basket.txt");
                    break;
                case ERROR:
                    System.out.println("You gave erroneous input");
                    break;

            }
        } while (choice != Choice.EXIT);
        choosetoManage(basket, allcustomer);

    }

    public void choosetoManage(Basket basket, AllCustomers allCustomers) {

        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                System.out.println("1. Handle products  2.Handle customers  0.Exit");
                choice = scanner.nextInt();
            } while (choice < 0 || choice >= 3);

            switch (choice) {
                case 1:
                    manageBasket(basket, allCustomers);
                    break;
                case 2:
                    manageCustomer(basket, allCustomers);
                    break;
            }
        }catch (Exception e){
            System.out.println("You gave erroneous input");
            choosetoManage(basket, allCustomers);
        }

    }

}
