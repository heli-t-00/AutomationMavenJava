package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogicPage extends BasePage {
    public LogicPage(WebDriver driver) {
        super(driver);
    }

    //locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    // Items
    private final By addBikeLightBtn = By.id("add-to-cart-sauce-labs-bike-light");
    private final By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By addTshirtBtn = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By addFleeceBtn = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By addOnsieBtn = By.id("add-to-cart-sauce-labs-onesie");
    private final By addRedTshirtBtn = By.id("dd-to-cart-test.allthethings()-t-shirt-(red)");


    private final By cartBtn = By.id("shopping_cart_container");
    private final By getCartBtnAmount = By.className("shopping_cart_badge");

    //Methods
    public void enterUsername(String usernameText) {
        type(usernameField, usernameText);

    }


    public void enterPassword() {
        type(passwordField, "secret_sauce");
    }

    public void enterPassword(String passwordText) {
        type(passwordField, passwordText);


    }

    public void clickLogin() {
        click(loginButton);
    }

    public void completeLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void selectProduct() {
        click(addBikeLightBtn);

    }

    public void checkBasket() {
        click(cartBtn);
    }

    public void addBikeLight() {
        click(addBikeLightBtn);

    }

    public void addBackpack() {
        click(addBackpackBtn);
    }

    public void addTshirt() {
        click(addTshirtBtn);
    }

    public void addFleece() {
        click(addFleeceBtn);

    }

    public void addOnsie() {
        click(addOnsieBtn);
    }

    public void addRedTshirt() {
        click(addRedTshirtBtn);
    }

    public String getCartBtnText() {
        return driver.findElement(cartBtn).getText();


    }

 public void addProduct(String productName){
        addOnsieBtn;
                addFleeceBtn;
                addBikeLightBtn;
                addBackpackBtn;

 }


}
