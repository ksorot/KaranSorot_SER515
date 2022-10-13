import java.io.File;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

    int userType;

    public int Logingin(){
        userType = -1;
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
            while (filereader1.hasNextLine()) {
                String val = filereader1.nextLine();
                String[] temp = val.split(":");
                buyerList.put(temp[0], temp[1]);
            }

            File sellfile = new File("SellerInfo.txt");
            Scanner filereader2 = new Scanner(sellfile);
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
            userType = 0;
            System.out.println("Welcome Buyer");
        }
        else if(sellerList.containsKey(username) && sellerList.get(username).equals(password)){
            userType = 1;
            System.out.println("Welcome Seller");
        }
       return userType;
    }
}
