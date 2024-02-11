import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
    private String dropdownSelector;
    private String itemXPath;
    private String expectedText;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[1]","//*[@id=\"accordion__panel-0\"]/p", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[2]","//*[@id=\"accordion__panel-1\"]/p", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[3]","//*[@id=\"accordion__panel-2\"]/p", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[4]","//*[@id=\"accordion__panel-3\"]/p", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[5]","//*[@id=\"accordion__panel-4\"]/p", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[6]","//*[@id=\"accordion__panel-5\"]/p", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[7]","//*[@id=\"accordion__panel-6\"]/p", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[8]","//*[@id=\"accordion__panel-7\"]/p","Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        });
    }
    public DropdownTest(String dropdownSelector, String itemXPath, String expectedText) {
        this.dropdownSelector = dropdownSelector;
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
        mainPage.dropdownLocator = mainPage.getDropdownLocator(dropdownSelector);
        mainPage.itemLocator = mainPage.getItemLocator(itemXPath);

        mainPage.selectDropdownItem();
        String actualText = mainPage.getSelectedItemText();
        Assert.assertEquals(expectedText, actualText);
     }


}
