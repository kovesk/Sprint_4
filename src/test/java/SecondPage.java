import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondPage {
    private WebDriver driver;
    public SecondPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input")
    private WebElement datefield;
    // поле дата

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]")
    private WebElement rentalperiodfield;
    // поле срок аренды

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input")
    private WebElement commentfield;
    // поле коммент

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")
    private WebElement secondpageorderbutton;
    // кнопка заказать

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")
    private WebElement yesbutton;
    // кнопка да


    // прописываем дату доставки
    public void chooseDeliveryDate(String date) {
        datefield.sendKeys(date);
    }
    // выбираем срок аренды
    public void chooseRentalPeriod(String rentalperiod) {
        driver.findElement(By.xpath("/html/body")).click();
        rentalperiodfield.click();
        driver.findElement(By.xpath(rentalperiod)).click();

    }
    // выбираем цвет скутера
    public void chooseScooterColor(String colorscooter) {
        driver.findElement(By.xpath(colorscooter)).click();
    }
    // оставляем коммент курьеру
    public void leaveComment(String comment) {
        commentfield.sendKeys(comment);
    }
    // подтверждаем заказ, жмем заказать
    public void submitOrder() {
        secondpageorderbutton.click();
    }
    // в открывшемся окне нажимаем Да
    public void confirmOrder() {
        yesbutton.click();
    }
    // подтверждение открывшегося окна заказ оформлен
    public void confirmPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]")));
    }
}



