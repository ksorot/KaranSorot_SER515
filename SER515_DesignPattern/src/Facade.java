import sun.awt.geom.AreaOp;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

public class Facade {
    private int UserType;

    private Product theSelectedProduct;

    private int nProductCategory;

    private ClassProductList theProductList;

    private Person thePerson;

    public void facadehandler() {
        System.out.println(" --- IMPLEMENTING FACADE PATTERN ---");
        ClassProductList productList;
        ProductIterator productItr;
        Iterator itr;

        Login loginobj = new Login();
        ArrayList<String> inp = loginobj.Logingin();

        // userType to pass the information of login user is of type buyer or seller
        int userType = Integer.parseInt(inp.get(0));

        // username to get user's name from input at login
        String userName = inp.get(1);

        while (userType == -1) {
            // if invalid input, keep asking for valid username and password
            System.out.println("Invalid Username or Password, Please Try Again \n");
            userType = Integer.parseInt( loginobj.Logingin().get(0) );
        }


        String input = "2";
        // choice to choose type of product menu between meat and produce, keep repeating until valid value provided
        while (!input.equals("0") && !input.equals("1")) {
            System.out.println("Select Product from the following options :");
            System.out.println("Enter 0 for Meat Product Menu");
            System.out.println("Enter 1 for Produce Product Menu");
            Scanner systemin = new Scanner(System.in);
            input = systemin.nextLine();

            if (input.equals("0")) {
                nProductCategory = 0;
            } else if (input.equals("1")) {
                nProductCategory = 1;
            } else {
                System.out.println("Invalid Input, please select again from 1 or 0");
            }
        }

        Person user;
        // Stating person as a user or buyer with its userName
        System.out.println(" --- Implementing BRIDGE PATTERN --- ");
        if (userType == 0) {
            user = new Buyer();
            user.setUserName(userName);
        } else {
            user = new Seller();
            user.setUserName(userName);
        }

        ProductMenu productMenu;
        // Stating Product category between meat and produce product from the aforementioned choice
        System.out.println(" --- Implementing FACTORY PATTERN --- ");
        if (nProductCategory == 0) {
            productMenu = new MeatProductMenu();
        } else {
            productMenu = new ProduceProductMenu();
        }

        System.out.println(" --- Implementing VISITOR PATTERN --- \n");

        productItr = new ProductIterator();
        productList = new ClassProductList(productMenu);
        itr = productList.createIterator();
        // Iterating the overall menu of only meat or produce product from the overall menu
        System.out.println(" --- Implementing ITERATOR PATTERN --- ");
        if (nProductCategory == 0) {
            System.out.println("Overall Menu for Meat is");
        } else {
            System.out.println("Overall Menu for Produce is");
        }
        int counter = 0;
        while (productItr.hasNext(itr)) {
            System.out.println("" + ++counter + " " + productItr.Next(itr));
        }

        // sample arraylist contains all the products from the list of meat or produce based on the user choice
        ArrayList<String> sample = productList.getProductlist();

        // hashmap with key as username and value as there choice from overall menu (meat and produce both)
        HashMap<String, List<String>> userProductList = new HashMap<>();

        try {
            File userProductFile = new File("UserProduct.txt");
            // scanning all values as key (username) and product choices (values)
            Scanner filereader = new Scanner(userProductFile);
            while (filereader.hasNextLine()) {
                String val = filereader.nextLine();
                String[] temp = val.split(":");
                if(userProductList.containsKey(temp[0])){
                    userProductList.get(temp[0]).add(temp[1]);
                }
                else {
                    userProductList.put(temp[0], new ArrayList<>(Arrays.asList(temp[1])));
                }
            }
        } catch(FileNotFoundException temp){
            System.out.println("File Not Found Exception has occured" + temp);
        }
        catch(Exception e){
            System.out.println("Other Exception has occured" + e);
        }

        String userFinal = user.getUserName();
        if(nProductCategory==0) {
            System.out.println(" \n Product choice for " + userFinal + " from the UserProduct file for Meat category is");
        }
        else{
            System.out.println(" \n Product choice for " + userFinal + " from the UserProduct file for Produce category is");
        }
        List<String> userspecificlist = userProductList.get(userFinal);
        int counter2 = 0;

        // comparing user's specific choice from the chosen list of meat or produce product with the overall product list of chosen meat or produce product
        for (String val : sample){
            if (userspecificlist.contains(val)){
                System.out.println( " " + ++counter2 + " " + val);
            }
        }

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