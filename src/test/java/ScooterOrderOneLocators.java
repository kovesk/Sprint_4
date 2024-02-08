import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderOneLocators {
    private WebDriver driver;
    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phoneNumber;

    public ScooterOrderOneLocators(WebDriver driver, String name, String surname, String address, String metroStation, String phoneNumber) {
        this.driver = driver;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }
    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        // открываем сраницу сайта

    }
    public void pressorderbutton() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]")).click();
        // нажимаем на заказать
    }
    public void selectMetro(String metroStation) {
        String metroSearchFormatter = String.format(".//div[@class=\"select-search has-focus\"]//*[text()='%s']", metroStation);
        driver.findElement(By.xpath(".//div[@class=\"select-search__value\"]")).click();
        driver.findElement(By.xpath(metroSearchFormatter)).click();
        // нажимаем на выпадашку со станциями и выбираем станцию
    }
    public void fillForm() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input")).sendKeys(surname);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input")).sendKeys(address);
        selectMetro(metroStation);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input")).sendKeys(phoneNumber);
        // заполняем остальные поля
    }

    public void nextStep() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button")).click();
        // нажимаем далее для перехода на следующую страницу
    }

    public void chooseDeliveryDate() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input")).sendKeys("02/02/2024");
        // прописываем дату доставки
    }

    public void chooseRentalPeriod() {
        WebElement element = driver.findElement(By.xpath("/html/body"));
        element.click();
        // прячем календарь, нажимая на пустое пространство на сайта
        WebElement firstElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]"));
        firstElement.click();
        // нажимаем на поле срок аренды

        WebElement secondElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]"));
        secondElement.click();
        // выбираем сутки
    }

    public void chooseScooterColor() {
        driver.findElement(By.xpath("//*[@id=\"black\"]")).click();
        // выбираем цвет скутера
    }

    public void leaveComment() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input")).sendKeys("Позвоните заранее");
        // оставляем коммент курьеру
    }

    public void submitOrder() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]")).click();
        // подтверждаем заказ, жмем заказать
    }

    public void confirmOrder() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]")).click();
        // в открывшемся окне нажимаем Да
    }

    public void confirmPage() {
        // Инициализируем WebDriverWait с таймаутом в 5 секунд
        WebDriverWait wait = new WebDriverWait(driver, 5);
        // Ожидаем появления элемента по указанному XPath(заголовок Заказ оформлен)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[1]")));
    }

    public void closeBrowser() {
        driver.quit();
        // закрываем браузер
    }






}
