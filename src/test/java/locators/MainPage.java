package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public static final By UP_ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    // верхняя кнопка заказать
    public static final By DOWN_ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    // нижняя кнопка заказать
    public static final By NULL_HEADING = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[1]");
    public static final By NULL_ITEM = By.xpath("//*[@id=\"accordion__panel-0\"]/p");
    public static final By HEADING_I = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[2]");
    public static final By ITEM_I = By.xpath("//*[@id=\"accordion__panel-1\"]/p");
    public static final By HEADING_II = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[3]");
    public static final By ITEM_II = By.xpath("//*[@id=\"accordion__panel-2\"]/p");
    public static final By HEADING_III = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[4]");
    public static final By ITEM_III = By.xpath("//*[@id=\"accordion__panel-3\"]/p");
    public static final By HEADING_IV = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[5]");
    public static final By ITEM_IV = By.xpath("//*[@id=\"accordion__panel-4\"]/p");
    public static final By HEADING_V = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[6]");
    public static final By ITEM_V = By.xpath("//*[@id=\"accordion__panel-5\"]/p");
    public static final By HEADING_VI = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[7]");
    public static final By ITEM_VI = By.xpath("//*[@id=\"accordion__panel-6\"]/p");
    public static final By HEADING_VII = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[8]");
    public static final By ITEM_VII = By.xpath("//*[@id=\"accordion__panel-7\"]/p");
    //локаторы для выпадающих элементов






    // нажатие на верхнюю кнопку заказать
    public void clickUpOrderButton() {
        new WebDriverWait(driver, 20);
        driver.findElement(UP_ORDER_BUTTON).click();
    }
    // ждём появление текста над нижней кнопкой и нажимаем на нее
    public void clickDownOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[4]/div[2]/div[2]")));
        wait.until(ExpectedConditions.elementToBeClickable(DOWN_ORDER_BUTTON));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(DOWN_ORDER_BUTTON));
        driver.findElement(DOWN_ORDER_BUTTON).click();
    }


    // ждём появление заголовка о важном и нажимаем на выпадающие элементы
    public void selectDropdownItem(By dropDownSelector) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropDownSelector));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();

    }
    // ждем и проверяем полученный текст
    public String getSelectedItemText(By itemXPath) {
        WebDriverWait wait = new WebDriverWait(driver,  5);
        WebElement itemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(itemXPath));
        return itemElement.getText();

    }


}


