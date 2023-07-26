import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;


public class cartPage {

	private ChromeDriver driver;
	private ArrayList<StoreItem> itemsInCart;
	public WebElement btnCheckout;

	public void populateItems(){
		var detectedItems = driver.findElements(By.className("cart_item"));
		for (var item: detectedItems) {
			StoreItem x = new StoreItem();
			x.name = item.findElement(By.className("inventory_item_name")).getText();
			x.btnRemove = item.findElement(By.xpath(".//button[contains(@id,'remove')]"));
			itemsInCart.add(x);
		}
		btnCheckout = driver.findElement(By.id("checkout"));
	}

	public ArrayList<StoreItem> getItemsInCart(){
		return itemsInCart;
	}

	public cartPage(ChromeDriver _driver){
		this.driver = _driver;
		itemsInCart = new ArrayList<>();
	}
}