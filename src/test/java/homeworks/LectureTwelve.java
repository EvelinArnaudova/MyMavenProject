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
        cookie.click();

        WebElement login = driver.findElement(By.xpath("//*[@class=\"account-title\"]"));
        login.click();

        WebElement loginType = driver.findElement(By.xpath("//ul/li[3]/span"));
        loginType.click();

        WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        email.click();
        email.clear();
        email.sendKeys("evelin@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        password.click();
        password.clear();
        password.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class=\"submit-button initial\"]"));
        loginButton.click();

        driver.close();


    }


}
