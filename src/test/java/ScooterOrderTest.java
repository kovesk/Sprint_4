import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static FirstPage firstPage;
    public static SecondPage secondPage;
    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String date;
    private String rentalPeriod;
    private String colorScooter;
    private String comment;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Вася", "Пупкин", "Москва", "Черкизовская", "89141456657", "02/02/2024", "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]", "//*[@id=\"black\"]", "позвоните как доставите"},
                {"Женя", "Яблочкин", "Москва", "Сокольники", "89023456578", "05/02/2024", "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]", "//*[@id=\"grey\"]", "привяжите у метро"}
        });
    }

    public ScooterOrderTest(String name, String surname, String address, String metroStation, String phoneNumber, String date, String rentalPeriod, String colorScooter, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;

    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        firstPage = new FirstPage(driver);
        secondPage = new SecondPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @After
    public void teardown() {
        driver.quit();
    }


    @Test
    public void orderUpButtonTest() {

        mainPage.clickUpOrderButton();
        firstPage.fillForm(name, surname, address, metroStation, phoneNumber);
        firstPage.nextStep();
        secondPage.chooseDeliveryDate(date);
        secondPage.chooseRentalPeriod(rentalPeriod);
        secondPage.chooseScooterColor(colorScooter);
        secondPage.leaveComment(comment);
        secondPage.submitOrder();
        secondPage.confirmOrder();
        secondPage.confirmPage();

    }

    @Test
    public void orderDownButtonTest() {

        mainPage.clickDownOrderButton();
        firstPage.fillForm(name, surname, address, metroStation, phoneNumber);
        firstPage.nextStep();
        secondPage.chooseDeliveryDate(date);
        secondPage.chooseRentalPeriod(rentalPeriod);
        secondPage.chooseScooterColor(colorScooter);
        secondPage.leaveComment(comment);
        secondPage.submitOrder();
        secondPage.confirmOrder();
        secondPage.confirmPage();

    }
}


