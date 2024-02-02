import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScooterOrderTest {
    private static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","/Users/katekov/Documents/driverchrome/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
    }



    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Вася", "Пупкин", "Москва", "Черкизовская", "89141456657"},
                {"Женя", "Яблочкин", "Москва", "Сокольники", "89023456578"}
        });
    }

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

    public void selectMetro(String metroStation) {
        String metroSearchFormatter = String.format(".//div[@class=\"select-search has-focus\"]//*[text()='%s']", metroStation);
        driver.findElement(By.xpath(".//div[@class=\"select-search__value\"]")).click();
        driver.findElement(By.xpath(metroSearchFormatter)).click();
    }



    @Test
    public void orderScooter() throws InterruptedException {
        // Первая страница
        // 1. Открыть сайт
        driver.get("https://qa-scooter.praktikum-services.ru");

        // 2. Нажать на кнопку заказать
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]")).click();

        // 3. Заполнить форму
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input")).sendKeys(surname);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input")).sendKeys(address);
        selectMetro(metroStation);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input")).sendKeys(phoneNumber);

        // 4. Нажать Далее
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")).click();


        //Вторая страница
        // 5. В поле когда привезти самокат ввести дату
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input")).sendKeys("02/02/2024");

        // 6. Поле срок аренды это выпадающий список, где нужно выбрать значение «сутки»
        WebElement element = driver.findElement(By.xpath("/html/body"));
        element.click();
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]"));
        firstElement.click();

        // Найти второй элемент и нажать на него
        WebElement secondElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]"));
        secondElement.click();


        // 7. В поле цвет самоката нужно выбрать чекбокс «черный жемчуг»
        driver.findElement(By.xpath("//*[@id=\"black\"]")).click();

        // 8. В поле комментарий для курьера ввести текст
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input")).sendKeys("Позвоните заранее");

        // 9. Нажать заказать
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")).click();


        // 10. Нажать «Да»
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")).click();

        // Инициализируем WebDriverWait с таймаутом в 5 секунд
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // Ожидаем появления элемента по указанному XPath
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]/text()")));

    }



    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
}

