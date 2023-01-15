package exercises.lectureTen;
import org.testng.annotations.Test;
public class DependencyTests {
    @Test(dependsOnGroups = "group.dependency") // then the depends on groups methods
    public void testDependsOnGroup() {
        System.out.println("This method depends on group.dependency");
    }

    @Test(groups = "group.dependency") //first the group methods are executed
    public void testGroupDependency() {
        System.out.println("This is a test part of group.example");
    }

    @Test(groups = "group.dependency")
    public void testGroupDependency1() {
        System.out.println("This is a test1 part of group.example");
    }

    @Test(dependsOnMethods = "testMethodDependency")
    public void testDependsOnMethod() {
        System.out.println("This is a depends on testMethodDependency");
    }

    @Test
    public void testMethodDependency() {
        System.out.println("This is test dependency test");
    }
}
