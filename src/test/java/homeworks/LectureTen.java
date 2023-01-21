package homeworks;

import org.testng.Assert;
import org.testng.annotations.*;

public class LectureTen {

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("Before Suite");
    }

    @DataProvider(name = "additionsResults")
    public Object[][] additionsResults() {
        return new Object[][]{
                {1, 2, 3}, //pass
                {4, 5, 9}, //pass
                {-1, -2, 1}, //fail
                {1, -1, -2}, //fail
        };
    }

    @Test(dataProvider = "additionsResults", groups = "addition")
    public void testAddition(int a, int b, int expectedResult) {
        int actualResult = a + b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "subtractionResults")
    public Object[][] subtractionResults() {
        return new Object[][]{
                {1, 1, 0}, //pass
                {2, 1, 1}, //pass
                {5, 9, 1}, //fail
                {7, -8, 3}, //fail

        };
    }

    @Test(dataProvider = "subtractionResults", groups = "subtraction")
    public void testSubtraction(int a, int b, int expectedResult) {
        int actualResult = a - b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "multiplicationResults")
    public Object[][] multiplicationResults() {
        return new Object[][]{
                {1, 1, 1}, //pass
                {2, 0, 0}, //pass
                {5, 5, 40}, //fail
                {7, 8, 50}, //fail
        };
    }

    @Test(dataProvider = "multiplicationResults", groups = "multiplication")
    public void testMultiplication(int a, int b, int expectedResult) {
        int actualResult = a * b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "divisionResults")
    public Object[][] divisionResults() {
        return new Object[][]{
                {25, 5, 5}, //pass
                {48, 6, 8}, //pass
                {6, 1, 0}, //fail
                {8, 7, 9}, //fail
        };
    }

    @Test(dataProvider = "divisionResults", groups = "division")
    public void testDivision(int a, int b, int expectedResult) {
        int actualResult = a / b;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @DataProvider(name = "modulusResults")
    public Object[][] modulusResults() {
        return new Object[][]{
                {1, 1, 0},
                {2, 1, 0},
                {1, 8, 1},
                {5, -1, 0},
        };
    }

    @Test(dataProvider = "modulusResults", groups = "modules")
    public void testModulus(int a, int b, int expectedResult) {
        int actualResult = a % b;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @AfterSuite
    public void testAfterSuite() {
        System.out.println("After Suite");
    }

}
