package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NameSurnamePage {
    private final WebDriver driver;
    public NameSurnamePage(WebDriver driver) {
        this.driver = driver;
    }


    public static final By nameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // поле имя
    public static final By surnameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // поле фамилия
    public static final By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // поле адрес
    public static final By phoneField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // поле телефон




    // нажимаем на выпадашку со станциями и выбираем станцию
    public void selectMetro(String metroStation) {
        String metroSearchFormatter = String.format(".//div[@class=\"select-search has-focus\"]//*[text()='%s']", metroStation);
        driver.findElement(By.xpath(".//div[@class=\"select-search__value\"]")).click();
        driver.findElement(By.xpath(metroSearchFormatter)).click();

    }
    // Заполнение остальных полей
    public void fillForm(String name, String surname, String address, String metroStation, String phoneNumber) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        selectMetro(metroStation);
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    // нажимаем далее для перехода на следующую страницу
    public void nextStep() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")).click();

    }
}


