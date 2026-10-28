package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

private static final int DEFAULT_TIMEOUT = 5;

    public void waitForUrl(String expectedUrl){
        await().atMost(DEFAULT_TIMEOUT, SECONDS).until(() -> driver.getCurrentUrl().equals(expectedUrl));

    }


}
