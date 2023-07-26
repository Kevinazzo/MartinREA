import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collections;
import java.util.Comparator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

	public static ChromeDriver driver = new ChromeDriver();
	public static void main(String[] args) {

		loginPage loginObj;
		homePage homeObj = new homePage(driver);
		cartPage cartPageObj = new cartPage(driver);
		checkoutInfoPage checkoutInfoObj = new checkoutInfoPage();
		checkoutConfirmationPage checkoutConfirmationPageObj = new checkoutConfirmationPage();
		checkoutCompletePage checkoutCompletePageObj = new checkoutCompletePage();

		///////////////////// LOGIN
		driver.get("https://www.saucedemo.com/");
		loginObj= new loginPage();
		loginObj.txtbUsername.sendKeys("standard_user");
		loginObj.txtbPassword.sendKeys("secret_sauce");
		loginObj.btnLogin.click();



		//////////////////// HOMEPAGE
		// Ordena los objetos de la lista de menor a mayor.
		homeObj.populateItems();
		Collections.sort(homeObj._ItemsInCatalog, new Comparator<StoreItem>() {
			@Override
			public int compare(StoreItem o1, StoreItem o2) {
				int result = Float.compare(o1.price, o2.price);
				if (result == 0)
					result = Float.compare(o1.price, o2.price);
				return result;
			}
		});

		// Selecciona el primer y ultimo objeto, para añadirlos al carrito
		var lowest = homeObj._ItemsInCatalog.get(3);
		var highest = homeObj._ItemsInCatalog.get(4);


		if (!lowest.isAdded){
			lowest.btn.click();
		}
		if (!highest.isAdded){
			highest.btn.click();
		}
		//Navegar al carrito
		homeObj.btnShoppingCart.click();



		/////////////////////////// CARRITO
		cartPageObj.populateItems();

		/*verificar que los objetos mostrados en la pagina del carrito sean lo
		los mismos que en el paso 4 del ejercicio*/
		var itemsInCart = cartPageObj.getItemsInCart();
		var itemsInCatalog = homeObj.get_ItemsInCatalog();
		for (var xitem : itemsInCart) {
			var matches =itemsInCatalog.stream().filter(a -> a.name.equals(xitem.name)).count();
			if (matches > 0) {
				System.out.println("Objeto:" + xitem.name + "del catalogo fué encontrado en el catalogo");
			} else {
				System.out.println("Objeto:" + xitem.name + "no se encontró");

			}
		}
		cartPageObj.btnCheckout.click();



		/////////////////////////// CHECKOUT 1
		checkoutInfoObj.txtbFirstName.sendKeys("KL");
		checkoutInfoObj.txtbLastName.sendKeys("RM");
		checkoutInfoObj.txtbZIP.sendKeys("99999");
		checkoutInfoObj.btnContinue.click();



		/////////////////////////// CHECKOUT 2
		checkoutConfirmationPageObj.populateItems();

		/*verificar que los articulos mostrados son iguales a los que
		se añadieron al carrito en el paso anterior	*/

		var itemsInCheckout = checkoutConfirmationPageObj._ItemsInCheckout;
		for (var xitem : itemsInCheckout) {
			var matches =itemsInCart.stream().filter(a -> a.name.equals(xitem.name)).count();
			if (matches > 0) {
				System.out.println("Objeto:" + xitem.name + " del catalogo fué encontrado en el carrito");
			} else {
				System.out.println("Objeto:" + xitem.name + "no se encontró");

			}
		}




		/////////////////////////// CHECKOUT 3
		if (checkoutCompletePageObj.lblConfirmationMessage.getText().equals("Thank you for your order!")){
			System.out.println("Orden completa");
			driver.close();
		}
	}
}