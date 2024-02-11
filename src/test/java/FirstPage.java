import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FirstPage {
    private WebDriver driver;
    public FirstPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")
    private WebElement namefield;
    // поле имя
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input")
    private WebElement surnamefield;
    // поле фамилия
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input")
    private WebElement addressfield;
    // поле адресс
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input")
    private WebElement phonefield;
    // поле телефон




    // нажимаем на выпадашку со станциями и выбираем станцию
    public void selectMetro(String metroStation) {
        String metroSearchFormatter = String.format(".//div[@class=\"select-search has-focus\"]//*[text()='%s']", metroStation);
        driver.findElement(By.xpath(".//div[@class=\"select-search__value\"]")).click();
        driver.findElement(By.xpath(metroSearchFormatter)).click();

    }
    // Заполнение остальных полей
    public void fillForm(String name, String surname, String address, String metroStation, String phoneNumber) {
        namefield.sendKeys(name);
        surnamefield.sendKeys(surname);
        addressfield.sendKeys(address);
        selectMetro(metroStation);
        phonefield.sendKeys(phoneNumber);
    }

    // нажимаем далее для перехода на следующую страницу
    public void nextStep() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")).click();

    }
}

