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


    private final By addBikeLightBtn = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartBtn = By.id("shopping_cart_container");
    private final By addToCartBtn = By.cssSelector("#add-to-cart-sauce-labs-backpack, " + "#add-to-cart-sauce-labs-bike-light," + "#add-to-cart-sauce-labs-bolt-t-shirt, " + "#add-to-cart-sauce-labs-fleece-jacket," +"#add-to-cart-sauce-labs-onesie, "+ "#add-to-cart-test.allthethings()-t-shirt-(red)");


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

    public void selectProduct(){
        click(addBikeLightBtn);

    }

    public void checkBasket(){
        click(cartBtn);
    }

    public void addToCart(){
        click(addToCartBtn);

    }


}
