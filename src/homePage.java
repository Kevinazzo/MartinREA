import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class homePage {

	//representacion ORM del objeto del catalogo
	class catalogItem {
		String name;
		String id;
		float price;
		WebElement btn;
		String btnXpath;
		boolean isAdded;
	}

	private FirefoxDriver driver;
	public WebElement btnShoppingCart;
	public ArrayList<catalogItem> _CatalogueItems;

	//Metodo para llenar una lista virtual de objetos del inventario, para manipularlos mas facil
	void populateItems(){
		btnShoppingCart = driver.findElement(By.className("shopping_cart_link"));
		List<WebElement> elements = driver.findElements(By.className("inventory_item"));
		for (var item: elements) {
			catalogItem x = new catalogItem();
			x.name = item.findElement(By.className("inventory_item_name")).getText();
			x.price =  Float.parseFloat(item.findElement(By.className("inventory_item_price")).getText());
			x.btn = item.findElement(By.xpath("//input[@name='*']"));
			_CatalogueItems.add(x);
		}
	}

	//Metodo que regresa la lista de objetos virtuales del catalogo
	public ArrayList<catalogItem> get_CatalogueItems(){
		return _CatalogueItems;
	}

	// Constructor
	public homePage(FirefoxDriver _driver){
		this.driver = _driver;
		_CatalogueItems = new ArrayList<>();
	}
}
