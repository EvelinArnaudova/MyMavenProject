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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class lecture13 {

    @DataProvider(name = "generateUsers")
    public Object[][] generateUsers(){
        return new Object[][]{
                {"earnaudova@gmail.com", "test123", "earnaudova" }, //login with email
                {"DimitarTarkalanov", "Dimitar1.Tarkalanov1", "DimitarTarkalanov"},//login with username
                {"testAdmin@gmail.com", "Admin1.User1", "AdminUser"}, //login with admin user
                {"manager@gmail.com", "Manager1.Use1", "ManagerUser"} //login with manager user
        };
    }

    @Test(dataProvider = "generateUsers") //(invocationCount = 5)
    public void testLogin(String user, String pass, String name){

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        loginButton.click();

        /*String expectedLoginURL = "http://training.skillo-bg.com:4300/users/login";
        String actualLoginURL = driver.getCurrentUrl();
        Assert.assertEquals(actualLoginURL, expectedLoginURL);*/

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //слагаме нови стойности на тази променлива wait
        WebElement signInTitle = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInTitle));

        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
        username.sendKeys(user);

        WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
        password.sendKeys(pass);

        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();

        WebElement profileLink = driver.findElement(By.id("nav-link-profile"));
        wait.until(ExpectedConditions.elementToBeClickable(profileLink));
        profileLink.click();

        /*String actualProfilePageUrl = driver.getCurrentUrl();
        String expectedProfilePage = "http://training.skillo-bg.com:4300/users/3905";
        Assert.assertEquals(actualProfilePageUrl, expectedProfilePage, "The profile page url is incorrect!");*/

        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users/"));

        /*WebElement userNameElement = driver.findElement(By.tagName("h2"));
        String actualUserName = userNameElement.getText();
        String expectedUserName = "earnaudova";
        Assert.assertEquals(actualUserName, expectedUserName, "The user name is incorrect!");*/

        Boolean isTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), name));
        Assert.assertTrue(isTextDisplayed);

        driver.close();


    }

}
