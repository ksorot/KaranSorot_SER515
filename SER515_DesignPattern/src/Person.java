public abstract class Person implements ProductMenu {
    private ProductMenu theProductMenu;
    private String userName;

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public abstract void showMenu();

    public void showAddButton() {

    }


    public void showViewButton() {

    }

    public void showRadioButton() {

    }

    public void showLabels() {

    }

    public abstract ProductMenu CreateProductMenu();


}
