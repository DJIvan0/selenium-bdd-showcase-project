package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArgusAllWeatherTankProductPage {

	WebDriver driver;

	public ArgusAllWeatherTankProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='tab-label-reviews-title']")
	private WebElement reviewTabLink;

	@FindBy(how = How.XPATH, using = "//label[@id='Rating_5_label']")
	private WebElement fiveStarRating;

	@FindBy(how = How.XPATH, using = "//input[@id='nickname_field']")
	private WebElement nicknameField;

	@FindBy(how = How.XPATH, using = "//input[@id='summary_field']")
	private WebElement summaryField;

	@FindBy(how = How.XPATH, using = "//textarea[@id='review_field']")
	private WebElement reviewField;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Submit Review']")
	private WebElement submitReviewButton;
	
	@FindBy(how = How.XPATH, using= "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement confirmationMessage;

	public void clickOnReviewTabLink() {
		reviewTabLink.click();
	}

	public void clickOnFiveStars() {
		Actions hoverAction = new Actions(driver);
		hoverAction.moveToElement(fiveStarRating).click().perform();
	}

	public void enterNickname(String nickname) {
		nicknameField.sendKeys(nickname);
	}

	public void enterReviewSummary(String summary) {
		summaryField.sendKeys(summary);
	}

	public void enterReviewText(String reviewText) {
		reviewField.sendKeys(reviewText);
	}

	public void clickOnSubmitReviewButton() {
		submitReviewButton.click();
	}
	
	public void assertConfirmationMessagePresent() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(confirmationMessage));
		Assert.assertTrue(confirmationMessage.isDisplayed());
	}

}
