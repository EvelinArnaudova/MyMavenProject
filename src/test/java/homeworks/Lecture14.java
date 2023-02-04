package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Lecture14 {
    private WebDriver driver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @AfterMethod
//    protected final void tearDownTest() {
//        if (this.driver != null) {
//            this.driver.close();
//        }
//    }

    @Test
    public void testAddElement() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement AddButton = driver.findElement(By.tagName("button"));
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        AddButton.click();

        WebElement DeleteButton = driver.findElement(By.cssSelector(".added-manually"));
        Assert.assertTrue(DeleteButton.isDisplayed());


    }

    @Test
    public void testDeleteElement() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement AddButton = driver.findElement(By.tagName("button"));
        wait.until(ExpectedConditions.elementToBeClickable(AddButton));
        AddButton.click();

        WebElement DeleteButton = driver.findElement(By.cssSelector(".added-manually"));
        Assert.assertTrue(DeleteButton.isDisplayed());

        wait.until(ExpectedConditions.elementToBeClickable(DeleteButton));
        DeleteButton.click();

        try{
            driver.findElement(By.cssSelector(".added-manually"));
        }catch (NoSuchElementException e){
            System.out.println(e.toString());
            boolean elementDoesNotExist = e.toString().contains("no such element");
            Assert.assertTrue(elementDoesNotExist);
        }
    }

    @Test
    public void testCheckboxSelection() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement checkbox1 = driver.findElement(By.xpath("//form/input[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
        checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected());

    }

    @Test
    public void testCheckboxDeselection() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement checkbox2 = driver.findElement(By.xpath("//form/input[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox2));
        checkbox2.click();

        Assert.assertFalse(checkbox2.isSelected());
    }

    @Test
    public void testDragAndDrop() {

        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions builder = new Actions(driver);

        WebElement BoxA = driver.findElement(By.id("column-a"));

        WebElement BoxB = driver.findElement(By.id("column-b"));

        builder.dragAndDrop(BoxA, BoxB).perform();

       WebElement headerColumnA = driver.findElement(By.xpath("//*[@id=\"column-a\"]/header"));
        //WebElement headerColumnB = driver.findElement(By.xpath("//*[@id=\"column-b\"]/header"));

        wait.until(ExpectedConditions.textToBePresentInElement(headerColumnA,"A"));


    }

    @Test
    public void testDropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();
        WebElement option1 = driver.findElement(By.xpath("//option[@value=\"1\"]"));
        Actions hover = new Actions(driver);
        hover.moveToElement(option1);
        option1.click();
        Assert.assertTrue(option1.isSelected());

    }
}
