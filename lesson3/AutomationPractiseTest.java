package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPractiseTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver chromeDriver = new ChromeDriver();
        //chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chromeDriver.get("http://automationpractice.com/index.php?id_category=8&controller=category#/");

        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        WebElement casualDressesCheckbox = chromeDriver.findElement(By.id("layered_category_9"));
        casualDressesCheckbox.click();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.xpath("//a[@title='Cancel']"))));

        chromeDriver.findElement(By.xpath("//a[@title='Cancel']")).click();

        Thread.sleep(5000);
        chromeDriver.quit();

    }
}
