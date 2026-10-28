package saucelab;

import base.BasePage;
import com.google.common.collect.Range;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LogicPage;
import static org.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

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
        logicPage.waitForUrl(LogicPage.successUrl);
        Assert.assertEquals(LogicPage.successUrl, driver.getCurrentUrl());

    }



    @Test
    public void testRun2() throws InterruptedException {

        logicPage.enterUsername("locked_out_user");
        logicPage.enterPassword();
        logicPage.clickLogin();
        WebElement element = driver.findElement(By.cssSelector(".error-message-container h3"));
    }


    @Test // no username/password, assertion for results
    public void noUsernamePasswordTest() throws InterruptedException {
        logicPage.completeLogin("", "");
        WebElement loginError = driver.findElement(loginErrorMsg);
        Assert.assertEquals("Epic sadface: Username is required", loginError.getText());
        System.out.println("TEST" + loginError.getText());

    }

    @Test
    public void noPasswordTest() throws InterruptedException {
        logicPage.enterUsername("standard_user");
        logicPage.enterPassword("");
        logicPage.clickLogin();
        WebElement loginError = driver.findElement(loginErrorMsg);
        Assert.assertEquals("Epic sadface: Password is required", loginError.getText());
        System.out.println("TEST " + loginError.getText());

    }

    @Test
    public void selectOneProduct() throws InterruptedException {
        logicPage.completeLogin("standard_user", "secret_sauce");
        logicPage.waitForUrl(logicPage.successUrl);
        logicPage.selectProduct();
        logicPage.checkBasket();

        WebElement actual = driver.findElement(itemName);
        Assert.assertEquals("Sauce Labs Bike Light", actual.getText());

    }


    @Test
    public void selectTwoProduct() {
        logicPage.completeLogin("standard_user", "secret_sauce");
        logicPage.addBikeLight();
        logicPage.addOnsie();
        logicPage.checkBasket();
        Assert.assertEquals("2", logicPage.getCartBtnText());

    }

    @Test
    public void selectProduct() {
        logicPage.completeLogin("standard_user", "secret_sauce");
        logicPage.addProduct("Bike Light");
        logicPage.addProduct("Tshirt");
        logicPage.addProduct("Backpack");
        logicPage.checkBasket();

        Assert.assertEquals("3", logicPage.getCartBtnText());


    }


    @After
    public void tearDown() {
        driver.quit();
    }

}

// ASSERT


