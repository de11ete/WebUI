package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomeWorkThreeTestOne {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));


        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://diary.ru/");
        Cookie cookie = new Cookie("_identity_", "83668234c30812b14c46bac1deda1a240770255504032650b424a75038c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C2592000%5D%22%3B%7D");
        chromeDriver.manage().addCookie(cookie); //привязываем куку
        chromeDriver.navigate().refresh(); //перезагрузка страницы

        chromeDriver.switchTo().newWindow(WindowType.TAB); //создать новую вкладку

        List<String> tabs = new ArrayList<>(chromeDriver.getWindowHandles()); //получаем список дискрипторов
        chromeDriver.switchTo().window(tabs.get(1)); //переключаемся на новую вкладку
        chromeDriver.get("https://diary.ru/u-mail");

        chromeDriver.findElement(By.xpath("//a[@href='/u-mail/new']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.name("UmailForm[to_username]"))));
        chromeDriver.findElement(By.name("UmailForm[to_username]")).sendKeys("spartalex");
        chromeDriver.findElement(By.name("UmailForm[title]")).sendKeys("smile");
        chromeDriver.findElement(By.id("smile_all")).click();
        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//div[@data-code=':rotate:']")).click();
        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//input[@value='1']")).click();
        chromeDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("umail_check_all")));
        chromeDriver.findElement(By.name("umail_check_all")).click();
        chromeDriver.findElement(By.xpath("//button[2]")).click();

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
