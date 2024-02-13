import io.github.bonigarcia.wdm.WebDriverManager;
import locators.DatePage;
import locators.MainPage;
import locators.NameSurnamePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    public static NameSurnamePage namePage;
    public static DatePage datePage;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final By rentalPeriod;
    private final By colorScooter;
    private final String comment;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Вася", "Пупкин", "Москва", "Черкизовская", "89141456657", "02/02/2024", DatePage.dayRent, DatePage.blackColor, "позвоните как доставите"},
                {"Женя", "Яблочкин", "Москва", "Сокольники", "89023456578", "05/02/2024", DatePage.daydaydaydayRent, DatePage.greyColor, "привяжите у метро"}
        });
    }

    public ScooterOrderTest(String name, String surname, String address, String metroStation, String phoneNumber, String date, By rentalPeriod, By colorScooter, String comment) {
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
        namePage = new NameSurnamePage(driver);
        datePage = new DatePage(driver);
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
        namePage.fillForm(name, surname, address, metroStation, phoneNumber);
        namePage.nextStep();
        datePage.chooseDeliveryDate(date);
        datePage.chooseRentalPeriod(rentalPeriod);
        datePage.chooseScooterColor(colorScooter);
        datePage.leaveComment(comment);
        datePage.submitOrder();
        datePage.confirmOrder();
        datePage.confirmPage();

    }

    @Test
    public void orderDownButtonTest() {

        mainPage.clickDownOrderButton();
        namePage.fillForm(name, surname, address, metroStation, phoneNumber);
        namePage.nextStep();
        datePage.chooseDeliveryDate(date);
        datePage.chooseRentalPeriod(rentalPeriod);
        datePage.chooseScooterColor(colorScooter);
        datePage.leaveComment(comment);
        datePage.submitOrder();
        datePage.confirmOrder();
        datePage.confirmPage();

    }
}



