package locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePage {
    private final WebDriver driver;
    public DatePage(WebDriver driver) {
        this.driver = driver;
    }



    public static final By dateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    // поле дата
    public static final By rentalPeriodField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]");
    // поле срок аренды
    public static final By commentField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // поле коммент
    public static final By datePageOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // кнопка заказать
    public static final By yesButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    // кнопка да
    public static final By dayRent = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    // срок аренды сутки
    public static final By daydaydaydayRent = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]");
    //срок аренды четверо суток
    public static final By blackColor = By.xpath("//*[@id=\"black\"]");
    // локатор для черного цвета скутера
    public static final By greyColor = By.xpath("//*[@id=\"grey\"]");
    // локатор для серого цвета


    // прописываем дату доставки
    public void chooseDeliveryDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
    // выбираем срок аренды
    public void chooseRentalPeriod(By rentalPeriod) {
        driver.findElement(By.xpath("/html/body")).click();
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalPeriod).click();

    }
    // выбираем цвет скутера
    public void chooseScooterColor(By colorScooter) {
        driver.findElement(colorScooter).click();
    }
    // оставляем коммент курьеру
    public void leaveComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    // подтверждаем заказ, жмем заказать
    public void submitOrder() {
        driver.findElement(datePageOrderButton).click();
    }
    // в открывшемся окне нажимаем Да
    public void confirmOrder() {
        driver.findElement(yesButton).click();
    }
    // подтверждение открывшегося окна заказ оформлен
    public void confirmPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]"), "Заказ оформлен"));
    }
}




