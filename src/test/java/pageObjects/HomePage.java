package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@title='Argus All-Weather Tank']")
	private WebElement argusAllWeatherTankLink;

	@FindBy(how = How.XPATH, using = "//a[@title='Fusion Backpack']")
	private WebElement fusionBackpackLink;

	@FindBy(how = How.XPATH, using = "//a[@title='Push It Messenger Bag']")
	private WebElement pushItMessengerBagLink;

	@FindBy(how = How.XPATH, using = "//a[@title='Hero Hoodie'][normalize-space()='Hero Hoodie']")
	private WebElement heroHoodieLink;
	
	@FindBy(how = How.XPATH, using = "//header[@class='page-header']//li[3]/a")
	private WebElement registrationLink;
	
	public void clickOnRegistrationLink() {
		registrationLink.click();
	}

	public void clickOnArgusAllWeatherTankLink() {
		argusAllWeatherTankLink.click();
	}

	public void clickOnFusionBackpackLink() {
		fusionBackpackLink.click();
	}

	public void clickOnPushItMessengerBagLink() {
		pushItMessengerBagLink.click();
	}

	public void clickOnHeroHoodieLink() {
		heroHoodieLink.click();
	}

}
