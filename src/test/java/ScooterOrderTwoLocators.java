import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderTwoLocators {

    private WebDriver driver;

    public ScooterOrderTwoLocators(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        // Открываем страницу
    }

    public void clickSecondOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[4]/div[2]/div[2]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        // ждём появление текста над второй кнопкой и нажимаем на заказать
    }
    boolean atPage() {
        String expectedUrl = "https://qa-scooter.praktikum-services.ru/order";
        return driver.getCurrentUrl().equals(expectedUrl);
    }

    public void closeBrowser() {
        driver.quit();
        // закрываем браузер
    }


}



