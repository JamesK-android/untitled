package gr.codehub.app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ui ui = new Ui();
        Basket basket = new Basket();
        AllCustomers allCustomers = new AllCustomers();
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Handle products  2.Handle customers");
            choice = scanner.nextInt();
        }while (choice <=0 || choice >=3);

            switch (choice) {
                case 1:
                    ui.manageBasket(basket);
                    break;
                case 2:
                    ui.manageCustomer(allCustomers);
                    break;
            }

        //succes
    }

}
