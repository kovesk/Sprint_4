import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScooterOrderTwoTest {
    private ScooterOrderTwoLocators orderTwo;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        this.orderTwo = new ScooterOrderTwoLocators(driver);
    }

    @Test
    public void testScooterOrderTwo() {
        orderTwo.openPage();
        orderTwo.clickSecondOrderButton();
        orderTwo.atPage();
    }
    @After
    public void teardown() {
        orderTwo.closeBrowser();
    }
}
