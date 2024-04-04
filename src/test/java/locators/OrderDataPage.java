package locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderDataPage {
    private final WebDriver driver;
    public OrderDataPage(WebDriver driver) {
        this.driver = driver;
    }



    public static final By DATE_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    // поле дата
    public static final By RENTAL_PERIOD_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]");
    // поле срок аренды
    public static final By COMMENT_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // поле коммент
    public static final By DATE_PAGE_ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // кнопка заказать
    public static final By YES_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    // кнопка да
    public static final By DAY_RENT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    // срок аренды сутки
    public static final By DAY_DAY_DAY_DAY_RENT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]");
    //срок аренды четверо суток
    public static final By BLACK_COLOR = By.xpath("//*[@id=\"black\"]");
    // локатор для черного цвета скутера
    public static final By GREY_COLOR = By.xpath("//*[@id=\"grey\"]");
    // локатор для серого цвета


    // прописываем дату доставки
    public void chooseDeliveryDate(String date) {
        driver.findElement(DATE_FIELD).sendKeys(date);
    }
    // выбираем срок аренды
    public void chooseRentalPeriod(By rentalPeriod) {
        driver.findElement(By.xpath("/html/body")).click();
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        driver.findElement(rentalPeriod).click();

    }
    // выбираем цвет скутера
    public void chooseScooterColor(By colorScooter) {
        driver.findElement(colorScooter).click();
    }
    // оставляем коммент курьеру
    public void leaveComment(String comment) {
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }
    // подтверждаем заказ, жмем заказать
    public void submitOrder() {
        driver.findElement(DATE_PAGE_ORDER_BUTTON).click();
    }
    // в открывшемся окне нажимаем Да
    public void confirmOrder() {
        driver.findElement(YES_BUTTON).click();
    }
    // подтверждение открывшегося окна заказ оформлен
    public void confirmPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]"), "Заказ оформлен"));
    }
}




