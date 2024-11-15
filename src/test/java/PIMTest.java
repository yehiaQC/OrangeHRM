import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PIMTest extends Baseclass  {


    // this test is for failed search by sending invalid data and asserts for a failed search message
    @Test(priority = 3)
    public void invalidSearchforemployee() throws InterruptedException{
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
        Thread.sleep(2000);
        Baseclass.driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys("57gdg");
        Baseclass.driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
        List<WebElement> numrows = Baseclass.driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[4]"));
        System.out.println(numrows.size());
        Thread.sleep(2000);
        //   Assert.assertEquals(numrows.size(), 0);

        String actual =  Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();
        Assert.assertEquals(actual, "No Records Found");
        System.out.println("failed search");
    }

    //this test looks for sucessfull search by taking a value from the table and searching for it not a hard coded value and asserts by returning message - (1) Record Found -
    @Test(priority = 4)
    public void DynamicSuccessfullSearch() throws InterruptedException{
        Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
        Thread.sleep(2000);

        List<WebElement> idusers = Baseclass.driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[*]/div/div[2]/div"));
        for( WebElement x : idusers){
            String y = x.getText();
            if(!y.equals("Null"))
            {
                Baseclass.driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")).sendKeys(y);
                Baseclass.driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
                Thread.sleep(2000);
                break;
            }
            break;
        }

        String actualresult = Baseclass.driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();
        Assert.assertEquals(actualresult, "(1) Record Found");
        System.out.println("Successfull search");
    }
}
