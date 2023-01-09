package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PushItMessengerBagProductPage {

	WebDriver driver;

	public PushItMessengerBagProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Add to Compare']")
	private WebElement addToCompareLink;

	@FindBy(how = How.XPATH, using = "//a[@aria-label='store logo']//img")
	private WebElement homePageLink;
	
	@FindBy(how = How.XPATH, using = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement confirmationMessage;

	public void clickOnAddToCompareLink() {
		addToCompareLink.click();
	}

	public void clickOnHomePageLink() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(confirmationMessage));
		homePageLink.click();
	}

}
