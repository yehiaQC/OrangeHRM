import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class addlogTest extends Baseclass {

    // adding a log to the employee with screenshot before and after addition of log , this test is done 2 times due to invocation count
    @Test(priority = 5, invocationCount = 2)
    public void addlogtestsuccessfully() throws InterruptedException {
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a/span")).click();
        Thread.sleep(2000);
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/a")).click();
        Thread.sleep(2000);
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div/div/div[5]/div/button")).click();
        Thread.sleep(2000);
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        Thread.sleep(2000);
        Shutterbug.shootPage(Baseclass.driver, Capture.FULL, true).save("C://Users/yahmed/IdeaProjects/Test_Automation/src/test/resources/beforelog.png");


        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div/div/form/div[1]/div/div[2]/input")).sendKeys("title");
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div/div/form/div[2]/div/button[2]")).click();
        Thread.sleep(2000);
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div/div/form/div[3]/div/div[2]/textarea")).sendKeys("Description");
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[3]/div/div/div/form/div[4]/button[2]")).click();
        Thread.sleep(2000);
        Shutterbug.shootPage(Baseclass.driver, Capture.FULL, true).save("C://Users/yahmed/IdeaProjects/Test_Automation/src/test/resources/afterlog.png");

    }

}
