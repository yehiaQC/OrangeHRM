import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Baseclass  {



    // this test send wrong data to test the invalid login case and asserts for message Invalid credentials
    @Test(priority = 1)
    public void TestFailedLogin() throws InterruptedException {
        Baseclass.driver.findElement(By.name("username")).sendKeys("Admin");
        Baseclass.driver.findElement(By.name("password")).sendKeys("admin1234");
        Baseclass.driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        String loginmessage = Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        Assert.assertEquals(loginmessage, "Invalid credentials");

    }


    // this test is for successfull login and user can validate login through screenshot taken before and after login
    @Test(priority = 2)
    public void TestSuccessFulllogin() throws InterruptedException {
        Baseclass.driver.findElement(By.name("username")).sendKeys("Admin");
        Baseclass.driver.findElement(By.name("password")).sendKeys("admin123");
        Baseclass.driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        Assert.assertTrue(Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/a/button")).isDisplayed());
        System.out.println("Scussefull login");
        Shutterbug.shootPage(Baseclass.driver, Capture.FULL, true).save("C://Users/yahmed/IdeaProjects/Test_Automation/src/test/resources/afterlogin.png");

    }

}
