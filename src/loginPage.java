import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage {

	private ChromeDriver driver = Main.driver;
	public WebElement txtbUsername = driver.findElement(By.id("user-name"));
	public WebElement txtbPassword = driver.findElement(By.id("password"));
	public WebElement btnLogin = driver.findElement(By.id("login-button"));

}