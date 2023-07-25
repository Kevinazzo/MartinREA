import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;


public class cartPage {


	class itemInCart{
		String name;
		String desc;
		String Qty;
		float price;
		WebElement btnRemove;
	}

	private FirefoxDriver driver;
	private ArrayList<itemInCart> itemsInCart;
	public WebElement btnCheckout;

	public void populateItems(){
		var detectedItems = driver.findElements(By.className("cart_item"));
		for (var item: detectedItems) {
			itemInCart x = new itemInCart();
			x.name = item.findElement(By.className("inventory_item_name")).getText();
			x.btnRemove = item.findElement(By.className("btn btn_secondary btn_small cart_button"));
			itemsInCart.add(x);
		}
		btnCheckout = driver.findElement(By.id("checkout"));
	}

	public cartPage(FirefoxDriver _driver){
		this.driver = _driver;
		itemsInCart = new ArrayList<>();
	}
}
