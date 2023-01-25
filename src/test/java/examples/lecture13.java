package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class lecture13 {

    @Test //(invocationCount = 5)
    public void testLogin(){

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

        /*String expectedLoginURL = "http://training.skillo-bg.com:4300/users/login";
        String actualLoginURL = driver.getCurrentUrl();
        Assert.assertEquals(actualLoginURL, expectedLoginURL);*/

        WebElement signInTitle = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInTitle));

        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
        username.sendKeys("earnaudova@gmail.com");

        WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
        password.sendKeys("test123");

        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled());
        signInButton.click();

        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(profileLink.isDisplayed(), "The profile link is not displayed!");

        profileLink.click();

        /*String actualProfilePageUrl = driver.getCurrentUrl();
        String expectedProfilePage = "http://training.skillo-bg.com:4300/users/3905";
        Assert.assertEquals(actualProfilePageUrl, expectedProfilePage, "The profile page url is incorrect!");*/

        WebElement userNameElement = driver.findElement(By.tagName("h2"));
        String actualUserName = userNameElement.getText();
        String expectedUserName = "earnaudova";
        Assert.assertEquals(actualUserName, expectedUserName, "The user name is incorrect!");


    }

}
