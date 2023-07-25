import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginPage {

	private FirefoxDriver driver;
	public WebElement txtbUsername;
	public WebElement txtbPassword;
	public WebElement btnLogin;
	public String URL = "https://www.saucedemo.com/";

	public loginPage(FirefoxDriver Driver) {
		this.driver = Driver;
		initialize();
	}

	public void initialize(){
		driver.get(URL);
		WebElement txtbUsername = driver.findElement(By.id("user-name"));
		WebElement txtbPassword = driver.findElement(By.id("password"));
		WebElement btnLogin = driver.findElement(By.id("login-button"));
	}
}