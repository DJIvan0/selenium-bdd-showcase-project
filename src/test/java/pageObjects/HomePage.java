package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	private WebElement signInLink;

	@FindBy(how = How.CSS, using = "a[title='Argus All-Weather Tank']")
	private WebElement argusAllWeatherTankLink;

	@FindBy(how = How.XPATH, using = "//a[@title='Fusion Backpack']")
	private WebElement fusionBackpackLink;

	@FindBy(how = How.XPATH, using = "//a[@title='Push It Messenger Bag']")
	private WebElement pushItMessengerBagLink;

	@FindBy(how = How.XPATH, using = "//a[@title='Compare Products']")
	private WebElement compareProductsPageLink;

	@FindBy(how = How.XPATH, using = "//a[@title='Hero Hoodie'][normalize-space()='Hero Hoodie']")
	private WebElement heroHoodieLink;

	public void clickOnSignInLink() {
		signInLink.click();
	}

	public void clickOnArgusAllWeatherTankLink() {
		argusAllWeatherTankLink.click();
	}

	public void assertWelcomeMessagePresent() {
		Assert.assertTrue(driver.getPageSource().contains("welcome"));
	}
	
	public void clickOnFusionBackpackLink() {
		fusionBackpackLink.click();
	}
	
	public void clickOnPushItMessengerBagLink() {
		pushItMessengerBagLink.click();
	}
	
	public void clickOnCompareProductsPageLink() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(compareProductsPageLink));
		compareProductsPageLink.click();
	}
	
	public void clickOnHeroHoodieLink() {
		heroHoodieLink.click();
	}

}
