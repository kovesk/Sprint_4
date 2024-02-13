import locators.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;



@RunWith(Parameterized.class)
public class DropdownTest {
    public static WebDriver driver;
    public static MainPage mainPage;
    private final By dropDownSelector;
    private final By itemXPath;
    private final String expectedText;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {MainPage.NULL_HEADING, MainPage.NULL_ITEM, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {MainPage.HEADING_I, MainPage.ITEM_I, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {MainPage.HEADING_II, MainPage.ITEM_II, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {MainPage.HEADING_III, MainPage.ITEM_III, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {MainPage.HEADING_IV, MainPage.ITEM_IV, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {MainPage.HEADING_V, MainPage.ITEM_V, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {MainPage.HEADING_VI, MainPage.ITEM_VI, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {MainPage.HEADING_VII, MainPage.ITEM_VII,"Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        });
    }
    public DropdownTest(By dropDownSelector, By itemXPath, String expectedText) {
        this.dropDownSelector = dropDownSelector;
        this.itemXPath = itemXPath;
        this.expectedText = expectedText;
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }
    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testDropdown() {
        mainPage.selectDropdownItem(dropDownSelector);
        String actualText = mainPage.getSelectedItemText(itemXPath);
        Assert.assertEquals(expectedText, actualText);
    }


}

