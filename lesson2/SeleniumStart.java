package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://google.com");

        WebDriverManager.edgedriver().setup();
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://aliexpress.com");

        Thread.sleep(1000);
        edgeDriver.quit();
        chromeDriver.quit();
    }
}
