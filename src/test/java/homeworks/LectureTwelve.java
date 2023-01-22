package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LectureTwelve {

    @Test
    public static void login() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.esky.bg/");

        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]/span"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cookie.click();

        WebElement login = driver.findElement(By.xpath("//*[@class=\"account-title\"]"));
        login.click();

        WebElement loginType = driver.findElement(By.xpath("//ul/li[3]/span"));
        loginType.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement username = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        username.click();
        username.clear();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.close();


    }


}
