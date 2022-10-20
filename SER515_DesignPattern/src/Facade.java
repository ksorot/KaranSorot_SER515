import sun.awt.geom.AreaOp;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Facade {
    private int UserType;

    private Product theSelectedProduct;

    private int nProductCategory;

    private ClassProductList theProductList;

    private Person thePerson;




    public void facadehandler(){
    Login loginobj = new Login();
        int userType = loginobj.Logingin();
    while(userType == -1){
        System.out.println("Invalid Username or Password, Please Try Again \n");
        userType = loginobj.Logingin();
    }
        String input = "2" ;
        while(!input.equals("0") && !input.equals("1") ){
            System.out.println("Select Product from the following options :");
            System.out.println("Enter 0 for Meat Product");
            System.out.println("Enter 1 for Produce Product");
            Scanner systemin = new Scanner(System.in);
            input = systemin.nextLine();

            if (input.equals("0")) {
                nProductCategory = 0;
            } else if (input.equals("1") ) {
                nProductCategory = 1;
            } else {
                System.out.println(" Invalid Input, please select again from 1 or 0");
            }
        }

            Person user;
            if(userType == 0){
                user = new Buyer();
            } else if(userType == 1){
                user = new Seller();
            }
            ProductMenu productMenu;
            if(nProductCategory == 0){
                productMenu =  new MeatProductMenu();
            }
            else if(userType == 1){
                productMenu = new ProduceProductMenu();
            }
        System.out.println("VISITOR PATTERN");

    }

    public void addTrading() {
    }

    public void viewTrading(){
    }

    public void decideBidding(){

    }


    public void discussBidding(){

    }


    public void submitBidding(){

    }


    public void remind(){

    }

    public void createUser(UserInfoItem userinfoitem) {

    }

    public void createProductList(){

    }

    public void AttachProductToUser(){

    }
    public Product SelectProduct(){
        return null;
    }
    public void productOperation(){

    }
}