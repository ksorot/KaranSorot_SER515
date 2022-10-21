import java.io.File;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Login {

    int userType;

    public ArrayList<String> Logingin(){
        userType = -1;

        // Taking Login Input as username and password
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = cin.next();
        System.out.println("Enter Password");
        String password = cin.next();

       HashMap<String, String> buyerList = new HashMap<>();
       HashMap<String, String> sellerList = new HashMap<>();

        try {
            File buyfile = new File("BuyerInfo.txt");
            Scanner filereader1 = new Scanner(buyfile);
            // taking data from buyerinfo file of all username and passwords and setting them in hashmap
            while (filereader1.hasNextLine()) {
                String val = filereader1.nextLine();
                String[] temp = val.split(":");
                buyerList.put(temp[0], temp[1]);
            }

            File sellfile = new File("SellerInfo.txt");
            Scanner filereader2 = new Scanner(sellfile);
            // taking data from sellerinfo file of all username and passwords and setting them in hashmap
            while (filereader2.hasNextLine()) {
                String val  = filereader2.nextLine();
                String[] temp = val.split(":");
                sellerList.put(temp[0], temp[1]);
            }
        }
        catch (Exception e){
            System.out.println(e);
    }
        if(buyerList.containsKey(username) && buyerList.get(username).equals(password)){
            //checking if given username matches any key value pair of buyerList hashmap
            userType = 0;
            System.out.println(" \n --- Welcome Buyer --- \n");
        }
        else if(sellerList.containsKey(username) && sellerList.get(username).equals(password)){
            //checking if given username matches any key value pair of sellerList hashmap
            userType = 1;
            System.out.println("\n --- Welcome Seller --- \n");
        }
        //storing username and usertype both
       ArrayList ans =  new ArrayList<String>();

        //returning usertype as 0 or 1 so as to differentiate between seller and buyer
        ans.add("" + userType);

        //returning username to use it in facade to iterate only selected user(seller/buyer) choice of list
        ans.add(username);

        return ans;
    }
}
