package gr.codehub.app;


public class Main {

    public static void main(String[] args) {
        Ui ui = new Ui();
        Basket basket = new Basket();
        AllCustomers allCustomers = new AllCustomers();
        ui.choosetoManage(basket,allCustomers);
    }

}
