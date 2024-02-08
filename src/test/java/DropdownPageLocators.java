import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPageLocators {
    private WebDriver driver;
    private By dropdownLocator;
    private By itemLocator;

    public DropdownPageLocators(WebDriver driver, String dropdownXPath, String itemXPath) {
        this.driver = driver;
        this.dropdownLocator = By.xpath(dropdownXPath);
        this.itemLocator = By.xpath(itemXPath);
    }

    public void openPage(String url) {
        driver.get(url);
        // Открываем страницу
    }

    public void selectDropdownItem() {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        // ждём появление заголовка о важном и нажимаем на выпадающие элементы
    }

    public String getSelectedItemText() {
        WebDriverWait wait = new WebDriverWait(driver,  5);
        WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
        return itemElement.getText();
        // ждем и проверяем полученный текст
    }
    public void closeBrowser() {
        driver.quit();
        // закрываем браузер
    }

}
