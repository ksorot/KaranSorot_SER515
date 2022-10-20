import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProduceProductMenu implements ProductMenu{

    public ArrayList<String> productItems;

    public ProduceProductMenu() {
        productItems = new ArrayList<>();
        Scanner filereader;
        try {
            File productFile = new File("ProductInfo.txt");
            filereader = new Scanner(productFile);
            while (filereader.hasNextLine()) {
                String temp = filereader.nextLine();
                String values[] = temp.split(":");
                if (values[0].equals("Produce")) {
                    productItems.add(values[1]);
                }
            }
            filereader.close();
        } catch (FileNotFoundException temp) {
            System.out.println("File Not Found Exception has occured" + temp);
        } catch (Exception e) {
            System.out.println("Other Exception has occured" + e);
        }
    }

    public ArrayList<String> getProductItems() {
        return this.productItems;
    }

    @Override
    public void showMenu() {

    }

    @Override
    public void showAddButton() {

    }

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {

    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComboxes() {

    }
}
