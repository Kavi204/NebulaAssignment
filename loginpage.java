
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
       
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
       
        driver.get("https://example.com/login");

        driver.findElement(By.id("username")).sendKeys("test_user");
        driver.findElement(By.id("password")).sendKeys("Test@123");

        driver.findElement(By.id("login_button")).click();

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Dashboard"), "Page title does not contain 'Dashboard'. Actual title: " + pageTitle);
    }

    @AfterClass
    public void tearDown() {
     
        if (driver != null) {
            driver.quit();
        }
    }
}
