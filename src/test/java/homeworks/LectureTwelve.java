package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LectureTwelve {

    @Test
    private static void firstAutomatedTest() {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.esky.bg/");

        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]/span"));

        cookie.click();

        WebElement login = driver.findElement(By.xpath("//*[@class=\"account-title\"]"));

        login.click();

        driver.close();
    }

}
