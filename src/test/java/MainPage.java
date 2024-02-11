import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
         }


    By dropdownLocator;
    By itemLocator;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]")
    private WebElement uporderbutton;
    // верхняя кнопка заказать
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button")
    private WebElement downorderbutton;
    // нижняя кнопка заказать


    // нажатие на верхнюю кнопку заказать
    public void clickUpOrderButton() {
        uporderbutton.click();
    }
    // ждём появление текста над нижней кнопкой и нажимаем на нее
    public void clickDownOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[4]/div[2]/div[2]")));
        wait.until(ExpectedConditions.elementToBeClickable(downorderbutton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", downorderbutton);
        downorderbutton.click();

    }

    public By getDropdownLocator(String xpath) {
        return By.xpath(xpath);
    }

    public By getItemLocator(String xpath) {
        return By.xpath(xpath);
    }

    // ждём появление заголовка о важном и нажимаем на выпадающие элементы
    public void selectDropdownItem() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();

    }
    // ждем и проверяем полученный текст
    public String getSelectedItemText() {
        WebDriverWait wait = new WebDriverWait(driver,  5);
        WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        return itemElement.getText();

    }


}
