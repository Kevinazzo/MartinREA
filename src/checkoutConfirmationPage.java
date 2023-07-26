import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class checkoutConfirmationPage {



	private ChromeDriver driver = Main.driver;
	public ArrayList<StoreItem> _ItemsInCheckout = new ArrayList<>();

	public WebElement btnFinish = driver.findElement(By.id("finish"));

	void populateItems(){
		var results = driver.findElements(By.className("cart_item"));
		for (var xItem:results) {
			StoreItem x = new StoreItem();
			x.name = xItem.findElement(By.className("inventory_item_name")).getText();
			x.price = Float.parseFloat(xItem.findElement(By.className("inventory_item_price")).getText().replace("$",""));
		}
	}
}
