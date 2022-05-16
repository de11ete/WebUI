package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        WebDriver chromeDriver = new ChromeDriver(chromeOptions);

        chromeDriver.get("https://google.com");

        chromeDriver.manage().window().setSize(new Dimension(390, 844));
        Thread.sleep(3000);
        chromeDriver.manage().window().maximize();

        chromeDriver.switchTo().newWindow(WindowType.TAB);

        List<String> tabs = new ArrayList<>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(tabs.get(1));
        chromeDriver.get("https://yandex.ru");

        Thread.sleep(3000);
        chromeDriver.close();
        Thread.sleep(3000);

        chromeDriver.switchTo().window(tabs.get(0));
        ((JavascriptExecutor)chromeDriver).executeScript("window.open('https://yandex.ru', '_blank').focus()");

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
