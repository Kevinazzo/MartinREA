import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class homePage {

	//representacion ORM del objeto del catalogo
	public ChromeDriver driver;
	public WebElement btnShoppingCart;
	public ArrayList<StoreItem> _ItemsInCatalog;

	//Metodo para llenar una lista virtual de objetos del inventario, para manipularlos mas facil
	void populateItems(){
		btnShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		List<WebElement> elements = driver.findElements(By.className("inventory_item"));
		for (var item: elements) {
			StoreItem x = new StoreItem();
			x.name = item.findElement(By.className("inventory_item_name")).getText();
			x.price =  Float.parseFloat(item.findElement(By.className("inventory_item_price")).getText().replace("$",""));
			x.btn = item.findElement(By.xpath(".//button[contains(@id,'add-to-cart')]"));
			if (x.btn.getText()== "Add to cart") {
				x.isAdded = true;
			}
			_ItemsInCatalog.add(x);
		}
	}

	//Metodo que regresa la lista de objetos virtuales del catalogo
	public ArrayList<StoreItem> get_ItemsInCatalog(){
		return _ItemsInCatalog;
	}

	// Constructor
	public homePage(ChromeDriver _driver){
		this.driver = _driver;
		_ItemsInCatalog = new ArrayList<>();
	}
}
