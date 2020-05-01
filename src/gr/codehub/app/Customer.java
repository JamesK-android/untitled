package gr.codehub.app;

import java.io.Console;

public class Customer {
    private String SareName;
    private String LastName;
    private String Sex;
    private String DateofBarth;
    private String Telephone;
    private String CustomerCode;

    public Customer(String CustomerCode,String LastName,String SareName,String Sex,String DateofBarth,String Telephone){
        this.CustomerCode = CustomerCode;
        this.SareName = SareName;
        this.LastName = LastName;
        this.Sex = Sex;
        this.DateofBarth = DateofBarth;
        this.Telephone = Telephone;


    }

    public void setSareName(String sareName) {
        SareName = sareName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setDateofBarth(String dateofBarth) {
        DateofBarth = dateofBarth;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getSareName() {
        return SareName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSex() {
        return Sex;
    }

    public String getDateofBarth() {
        return DateofBarth;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void ShowCustomerDetails(Customer c){
        System.out.println("Customer code: "+c.getCustomerCode());
        System.out.println("Last Name: "+c.getLastName());
        System.out.println("Sare Name: "+c.getSareName());
        System.out.println("Sex: "+c.getSex());
        System.out.println("Date of Barth: "+c.getDateofBarth());
        System.out.println("Phone: "+c.getTelephone());
        System.out.println();
    }


}
