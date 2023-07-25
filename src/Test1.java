import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;
import java.util.Comparator;

public class Test1 {

	FirefoxDriver driver = new FirefoxDriver();
	loginPage loginObj = new loginPage(driver);
	homePage homeObj = new homePage(driver);
	cartPage cartPageObj = new cartPage(driver);



	void login() {
		loginObj.initialize();

		loginObj.txtbUsername.sendKeys("standard_user");
		loginObj.txtbUsername.sendKeys("secret_sauce");
		loginObj.btnLogin.click();
	}

	void homepage(){
		// Ordena los objetos de la lista de menor a mayor.
		homeObj.populateItems();
		Collections.sort(homeObj._CatalogueItems, new Comparator<homePage.catalogItem>() {
			@Override
			public int compare(homePage.catalogItem o1, homePage.catalogItem o2) {
				int result = Float.compare(o1.price, o2.price);
				if (result == 0)
					result = Float.compare(o1.price, o2.price);
				return result;
			}
		});

		// Selecciona el primer y ultimo objeto, para añadirlos al carrito
		var lowest = homeObj._CatalogueItems.get(0);
		var highest = homeObj._CatalogueItems.get(homeObj._CatalogueItems.size()-1);

		lowest.btn.click();
		highest.btn.click();

		//Navegar al carrito
	}

	void cart(){
		cartPageObj.populateItems();

	}

	public void execute(){
		login();
		homepage();
		cart();
	}
}
