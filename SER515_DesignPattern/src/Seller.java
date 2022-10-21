import java.util.ArrayList;

public class Seller extends Person{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public ArrayList<String> getProductItems() {
        return null;
    }

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }

    @Override
    public void showMenu() {

    }

    @Override
    public void showComboxes() {

    }
}
