package saucelab;

import base.BasePage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LogicPage;

public class firsttest {

    WebDriver driver;
    private LogicPage logicPage;


    private final By loginErrorMsg = By.cssSelector(".error-message-container >h3");
    private final By itemName = By.cssSelector(".inventory_item_name");

// ALL TEST

    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logicPage = new LogicPage(driver);
    }

    @Test
    public void successLoginTest() throws InterruptedException {

        logicPage.completeLogin("standard_user", "secret_sauce");
        Thread.sleep(5000);
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

    }

    @Test
    public void testRun2() throws InterruptedException {

        logicPage.enterUsername("locked_out_user");
        logicPage.enterPassword();
        logicPage.clickLogin();
        Thread.sleep(5000);
        System.out.println("test2");
        WebElement element = driver.findElement(By.cssSelector(".error-message-container h3"));
    }


    @Test // no username/password, assertion for results
    public void noUsernamePasswordTest() throws InterruptedException {
        logicPage.completeLogin("", "");
        Thread.sleep(5000);
        WebElement loginError = driver.findElement(loginErrorMsg);
        Assert.assertEquals("Epic sadface: Username is required", loginError.getText());
        System.out.println("TEST" + loginError.getText());

    }

    @Test
    public void noPasswordTest() throws InterruptedException {
        logicPage.enterUsername("standard_user");
        logicPage.enterPassword("");
        logicPage.clickLogin();
        Thread.sleep(5000);
        WebElement loginError = driver.findElement(loginErrorMsg);
        Assert.assertEquals("Epic sadface: Password is required", loginError.getText());
        System.out.println("TEST " + loginError.getText());

    }

    @Test
    public void selectOneProduct() throws InterruptedException {
        logicPage.completeLogin("standard_user", "secret_sauce");
        Thread.sleep(2000);
        logicPage.selectProduct();
        logicPage.checkBasket();
        Thread.sleep(5000);
        WebElement actual = driver.findElement(itemName);
        Assert.assertEquals("Sauce Labs Bike Light", actual.getText());

    }


    @Test
    public void selectTwoProduct() {
        logicPage.completeLogin("standard_user", "secret_sauce");
        logicPage.addBikeLight();
        logicPage.addOnsie();
        logicPage.checkBasket();
        Assert.assertEquals("3", logicPage.getCartBtnText());

    }


    @Test
    public void selectProduct)

    {
        logicPage.completeLogin("standard_user", "secret_sauce");
        logicPage.addProduct();
        logicPage.checkBasket();


        Assert.assertEquals("3", logicPage.getCartBtnText());

    }


    @After
    public void tearDown() {
        driver.quit();
    }

}

// ASSERT


