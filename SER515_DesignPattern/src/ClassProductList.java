import java.util.ArrayList;
import java.util.Iterator;

public class ClassProductList {
    private ArrayList<String> productlist;

    public ArrayList<String> getProductlist() {
        return productlist;
    }

    public void accept(NodeVisitor visitor) {

    };
    public ClassProductList (ProductMenu productMenu){
        this.productlist = productMenu.getProductItems();
    }
    public ClassProductList() {

    }
    public Iterator createIterator(){
        return this.productlist.iterator();
    }
}
