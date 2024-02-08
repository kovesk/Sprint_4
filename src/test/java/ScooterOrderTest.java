import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

    private ScooterOrderOneLocators orderPage;
    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phoneNumber;

    public ScooterOrderTest(String name, String surname, String address, String metroStation, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        this.orderPage = new ScooterOrderOneLocators(driver, name, surname, address, metroStation, phoneNumber);
    }





    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Вася", "Пупкин", "Москва", "Черкизовская", "89141456657"},
                {"Женя", "Яблочкин", "Москва", "Сокольники", "89023456578"}
        });
    }




    @Test
    public void orderScooter() {
        orderPage.openPage();
        orderPage.pressorderbutton();
        orderPage.fillForm();
        orderPage.nextStep();
        orderPage.chooseDeliveryDate();
        orderPage.chooseRentalPeriod();
        orderPage.chooseScooterColor();
        orderPage.leaveComment();
        orderPage.submitOrder();
        orderPage.confirmOrder();
        orderPage.confirmPage();
        orderPage.closeBrowser();
    }
}


