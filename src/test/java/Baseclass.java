import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Baseclass {
    public static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public  void Testsetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/yahmed/IdeaProjects/Digitinary2/src/test/resources/chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Shutterbug.shootPage(driver, Capture.FULL, true).save("C://Users/yahmed/IdeaProjects/Test_Automation/src/test/resources/beforelogin.png");

    }


    @AfterTest
    public void AfterTest(){
        driver.quit();
    }

}
