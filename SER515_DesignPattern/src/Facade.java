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
        System.out.println("Invalid Username or Password, Please Try Again");
        userType = loginobj.Logingin();
    }
        int input = 2 ;
        while(input != 0 && input != 1){
            System.out.println("Select Product from the following options :");
            System.out.println("Enter 0 for Meat Product");
            System.out.println("Enter 1 for Produce Product");
            Scanner systemin = new Scanner(System.in);
            input = systemin.nextInt();

            if (input == 0) {
                nProductCategory = 0;
            } else if (input == 1) {
                nProductCategory = 1;
            } else {
                System.out.println(" Invalid Input, please select again from 1 or 0");
            }
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