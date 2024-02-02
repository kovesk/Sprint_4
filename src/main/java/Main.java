import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/Users/katekov/Documents/driverchrome/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
    }
}
