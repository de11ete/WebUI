package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://diary.ru/user/login");
/*
        chromeDriver.findElement(By.id("loginform-username")).sendKeys("spartalex");
        chromeDriver.findElement(By.id("loginform-password")).sendKeys("123456");

        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        chromeDriver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        chromeDriver.switchTo().parentFrame();

        chromeDriver.findElement(By.id("login_btn")).click();

        Thread.sleep(5000);
*/
        chromeDriver.get("https://diary.ru/");
        Cookie cookie = new Cookie("_identity_", "83668234c30812b14c46bac1deda1a240770255504032650b424a75038c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C2592000%5D%22%3B%7D");

        chromeDriver.manage().addCookie(cookie); //привязываем куку
        chromeDriver.navigate().refresh(); //перезагруза страницы
        Thread.sleep(5000);
        chromeDriver.quit();
    }
}
