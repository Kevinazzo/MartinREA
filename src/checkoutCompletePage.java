import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkoutCompletePage {

	private ChromeDriver driver = Main.driver;
	public WebElement lblConfirmationMessage = driver.findElement(By.className("complete-header"));
	public WebElement btnBackHome = driver.findElement(By.id("back-to-products"));

}
