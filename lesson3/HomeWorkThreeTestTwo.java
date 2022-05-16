package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWorkThreeTestTwo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));

        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://diary.ru/");
        Cookie cookie = new Cookie("_identity_", "83668234c30812b14c46bac1deda1a240770255504032650b424a75038c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C2592000%5D%22%3B%7D");
        chromeDriver.manage().addCookie(cookie); //привязываем куку
        chromeDriver.navigate().refresh(); //перезагрузка страницы

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='U-mail']")));
        chromeDriver.findElement(By.xpath("//a[@title='U-mail']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/u-mail/folder/1']")));
        chromeDriver.findElement(By.xpath("//a[@href='/u-mail/folder/1']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("umail_check_all")));
        chromeDriver.findElement(By.name("umail_check_all")).click();
        chromeDriver.findElement(By.name("move_to_folder")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select/option[4]")));
        chromeDriver.findElement(By.xpath("//select/option[4]")).click();
        chromeDriver.findElement(By.xpath("//button[@name='move']")).click();
        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//a[@href='/u-mail/folder/3']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select-on-check-all']")));
        chromeDriver.findElement(By.xpath("//input[@class='select-on-check-all']")).click();
        chromeDriver.findElement(By.name("move_to_folder")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select/option[2]")));
        chromeDriver.findElement(By.xpath("//select/option[2]")).click();
        chromeDriver.findElement(By.xpath("//button[@name='move']")).click();
        Thread.sleep(4000);
        chromeDriver.findElement(By.xpath("//a[@href='/u-mail/folder/1']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("umail_check_all")));
        chromeDriver.findElement(By.name("umail_check_all")).click();
        chromeDriver.findElement(By.xpath("//button[3]")).click();

        Thread.sleep(3000);
        chromeDriver.quit();
    }
}
