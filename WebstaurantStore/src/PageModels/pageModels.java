package PageModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageModels {

	WebDriver driver;
	
	public pageModels(WebDriver driver) {
		this.driver=driver;
	}
	
	//Search Bar
	By SearchBar = By.id("searchval");
	
	//Search Button
	By SearchButton = By.xpath("//button[@value=\"Search\"]");
			
	//ProductSearchTtitles
	By AllSearchTitle = By.xpath("//*[@data-testid=\"itemDescription\"]");
	
	//Add to Cart buttons
	By AddToCartButton = By.xpath("//*[@data-testid=\"itemAddCart\"]");
	
	//View Cart button
	By ViewCartButton = By.xpath("//*[@class=\"btn btn-small btn-primary\"]");
	
	//Cart item descriptions
	By itemDescritpion = By.xpath("//*[@class=\"itemDescription description\"]");
	
	//Empty  cart Button
	By emptyCartButton = By.className("emptyCartButton");
	
	//Confirm Empty cart Button
	By confirmEmptyCartButton = By.xpath("//button[contains(text(), \"Empty\") and contains(@class, \"bg-origin-box-border\")]");
	
	
	//Enter Search Value
	public void enterSearchValue(String text) {
		driver.findElement(SearchBar).sendKeys(text);
	}
	
	//Click Search Button
	public void clickSearchButton() {
		driver.findElement(SearchButton).click();
	}
	
	//Search Title Count
	public int searchTitleCount() {
		int size = driver.findElements(AllSearchTitle).size();
		return size;
	}
	
	//Search Title Value by Index
	public String searchTitleTextbyIndex(int index) {
		return driver.findElements(AllSearchTitle).get(index).getText();
	}
	
	//Last title value
	public String lastTitleValue() {
		int lastButtonIndex = driver.findElements(AllSearchTitle).size();
		return driver.findElements(AllSearchTitle).get(lastButtonIndex-1).getText();
	}
	
	//Click Last Add to Cart Button
	public void clickLastAddToCartButton() {
		int buttonCount = driver.findElements(AddToCartButton).size();
		driver.findElements(AddToCartButton).get(buttonCount-1).click();
	}
	
	//Click View Cart Button
	public void clickViewCartButton() {
		driver.findElement(ViewCartButton).click();
	}
	
	//Cart item descriptions
	public List<WebElement> cartItemDescriptions() {
		return driver.findElements(itemDescritpion);
	}
	
	//Cart item description by index
	public String cartDescirptionByInbdex(int index) {
		return cartItemDescriptions().get(index).getText();
	}
	
	//Is cart empty
	public boolean isCartEmpty() {
		return  driver.findElement(itemDescritpion).isDisplayed();
	}
	
	
	//Click Empty Cart button
	public void clickEmptyCartButton() {
		driver.findElement(emptyCartButton).click();
	}
	
	//Click Empty Cart button confirmation
	public void clickEmptyCartButtonConfirmation() {
		driver.findElement(confirmEmptyCartButton).click();
	}
}