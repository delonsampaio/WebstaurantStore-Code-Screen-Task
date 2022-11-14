package WebstaurantStoreTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageModels.pageModels;

public class jobAssignment {

	public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver","C:\\Users\\13053\\Desktop\\DelonWorksapce\\seleniumWebdriver\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();

//Create generic object
pageModels pm = new pageModels(driver);

//Navigate to site
driver.get("https://www.webstaurantstore.com/");

//Enter search criteria into search bar
String searchValue = "stainless work table";
pm.enterSearchValue(searchValue);

//Click Search button
pm.clickSearchButton();

//Verify if all product titles have "table" in it.
String requiredValue = "Table";
for(int i=0;i<pm.searchTitleCount(); i++) {
	String currentTitle = pm.searchTitleTextbyIndex(i);
	boolean hasValue = currentTitle.contains(requiredValue);
	if(hasValue==false) {
	throw new Error("Every product Does not have the word 'Table' in its title!");
	}
}

//Click Add To Cart for last item in search
pm.clickLastAddToCartButton();
String lastTitleValue = pm.lastTitleValue();

//Click view cart button
pm.clickViewCartButton();

//Verify if correct item was added to cart.
boolean hasValue = pm.cartDescirptionByInbdex(0).contains(lastTitleValue);
if(hasValue == false) {
throw new Error("Incorrect item was added to cart.");
}

//Click Empty Cart
pm.clickEmptyCartButton();

//Click Empty Cart confirmation
pm.clickEmptyCartButtonConfirmation();



//Verify if all items were removed from cart.
if(pm.isCartEmpty() == false) {
throw new Error("All items were not removed from cart");
}

	}

}
