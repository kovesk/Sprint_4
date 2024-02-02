import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DropdownTest {
    private WebDriver driver;
    private String clicks;
    private String xpath;
    private String expectedText;


    public DropdownTest(String clicks, String xpath, String expectedText) {
        this.clicks = clicks;
        this.xpath = xpath;
        this.expectedText = expectedText;
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","/Users/katekov/Documents/driverchrome/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
    }

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

    @Test
    public void testDropdown() {
        // Открываем страницу
        driver.get("https://qa-scooter.praktikum-services.ru");

        By locator = By.xpath(clicks);
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();

        // Ждём пока появится элемент списка
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        // Проверяем текст элемента списка
        Assert.assertEquals(expectedText, firstItem.getText());
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
