package locators;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClientDataPage {
    private final WebDriver driver;
    public ClientDataPage(WebDriver driver) {
        this.driver = driver;
    }


    public static final By NAME_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // поле имя
    public static final By SURNAME_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // поле фамилия
    public static final By ADDRESS_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // поле адрес
    public static final By PHONE_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // поле телефон




    // нажимаем на выпадашку со станциями и выбираем станцию
    public void selectMetro(String metroStation) {
        String metroSearchFormatter = String.format(".//div[@class=\"select-search has-focus\"]//*[text()='%s']", metroStation);
        driver.findElement(By.xpath(".//div[@class=\"select-search__value\"]")).click();
        driver.findElement(By.xpath(metroSearchFormatter)).click();

    }
    // Заполнение остальных полей
    public void fillForm(String name, String surname, String address, String metroStation, String phoneNumber) {
        driver.findElement(NAME_FIELD).sendKeys(name);
        driver.findElement(SURNAME_FIELD).sendKeys(surname);
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
        selectMetro(metroStation);
        driver.findElement(PHONE_FIELD).sendKeys(phoneNumber);
    }

    // нажимаем далее для перехода на следующую страницу
    public void nextStep() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")).click();
    }
    public void confirmOrderPage() {
        new WebDriverWait(driver, 5);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("Expected URL does not match the actual URL", "https://qa-scooter.praktikum-services.ru/order", currentUrl);
    }
}


