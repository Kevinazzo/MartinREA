import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkoutInfoPage {

	private ChromeDriver driver = Main.driver;
	public WebElement txtbFirstName = driver.findElement(By.id("first-name"));
	public WebElement txtbLastName = driver.findElement(By.id("last-name"));
	public WebElement txtbZIP = driver.findElement(By.id("postal-code"));
	public WebElement btnCancel = driver.findElement(By.id("cancel"));
	public WebElement btnContinue = driver.findElement(By.id("continue"));
}
