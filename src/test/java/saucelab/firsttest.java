package saucelab;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firsttest {

    static WebDriver driver;

    //locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginErrorMsg = By.cssSelector(".error-message-container >h3");

    //Methods
    public void enterUsername(String usernameText) {
        WebElement username = driver.findElement(usernameField);
        username.sendKeys(usernameText);
    }

    public void enterPassword() {
        WebElement password = driver.findElement(passwordField);
        password.sendKeys("secret_sauce");
    }

    public void enterPassword(String passwordText) {
        WebElement password = driver.findElement(passwordField);
        password.sendKeys(passwordText);
    }

    public void clickLogin() {
        WebElement login = driver.findElement(loginButton);
        login.click();
    }

    public void completeLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }


// ALL TEST

    @BeforeClass
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

    }

//    @Test
//    public void testRun() throws InterruptedException {
//
//        enterUsername("standard_user");
//        enterPassword();
//        clickLogin();
//        Thread.sleep(5000);
//        System.out.println("test1");
//
//        String expectedUrl = "https://www.saucedemo.com/inventory.html";
//        String expectedTitle = "Swag Labs";
//        Assert.assertEquals(expectedUrl, driver.getCurrentUrl(expectedUrl));
//        Assert.assertEquals(expectedTitle, driver.getTitle());
//    }

    @Test
    public void testRun2() throws InterruptedException {

        enterUsername("locked_out_user");
        enterPassword();
        clickLogin();
        Thread.sleep(5000);
        System.out.println("test2");
        WebElement element = driver.findElement(By.cssSelector(".error-message-container h3"));
    }


    @Test // no username/password, assertion for results
    public void noUsernamePasswordTest() throws InterruptedException {
        completeLogin("", "");
        Thread.sleep(5000);
        WebElement loginError = driver.findElement(loginErrorMsg);
        Assert.assertEquals("Epic sadface: Username is required", loginError.getText());
        System.out.println("TEST" + loginError.getText());

    }

    @Test
    public void noPasswordTest() throws InterruptedException {
        enterUsername("standard_user");
        enterPassword("");
        clickLogin();
        Thread.sleep(5000);
        WebElement loginError = driver.findElement(loginErrorMsg);
        Assert.assertEquals("Epic sadface: Password is required", loginError.getText());
        System.out.println("TEST " + loginError.getText());

    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}

// ASSERT


