package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ArgusAllWeatherTankProductPage extends BasePage{

	public ArgusAllWeatherTankProductPage(WebDriver driver) {
		super(driver);
	}

	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@FindBy(how = How.ID, using = "tab-label-reviews-title")
	private WebElement reviewTabLink;

	@FindBy(how = How.ID, using = "Rating_5_label")
	private WebElement fiveStarRating;

	@FindBy(how = How.ID, using = "nickname_field")
	private WebElement nicknameInputField;

	@FindBy(how = How.ID, using = "summary_field")
	private WebElement summaryInputField;

	@FindBy(how = How.ID, using = "review_field")
	private WebElement reviewTextField;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Submit Review']")
	private WebElement submitReviewButton;

	@FindBy(how = How.XPATH, using = "//div[@role='alert']")
	private WebElement confirmationMessage;
	
	@FindBy(how = How.ID, using = "ratings[4]-error")
	private WebElement ratingErrorMessageText;
	
	@FindBy(how = How.ID, using = "nickname_field-error")
	private WebElement nicknameErrorMessageText;
	
	@FindBy(how = How.ID, using = "summary_field-error")
	private WebElement summaryErrorMessageText;
	
	@FindBy(how = How.ID, using = "review_field-error")
	private WebElement reviewErrorMessageText;
	
	public void clickOnSubmitReview() {
		submitReviewButton.click();
	}
	
	public void clickOnReviewTab() {
		reviewTabLink.click();
	}
	
	public void fillOutMandatoryFieldsForReview(String nickname, String summary, String review) {
		Actions hoverAction = new Actions(driver);
		hoverAction.moveToElement(fiveStarRating).click().perform();
		nicknameInputField.sendKeys(nickname);
		summaryInputField.sendKeys(summary);
		reviewTextField.sendKeys(review);
	}
	
	public void verifyConfirmationMessageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
		Assert.assertTrue(confirmationMessage.isDisplayed());
	}
	
	public void assertAllMandatoryFields() {
		Assert.assertTrue(ratingErrorMessageText.isDisplayed());
		Assert.assertTrue(nicknameErrorMessageText.isDisplayed());
		Assert.assertTrue(summaryErrorMessageText.isDisplayed());
		Assert.assertTrue(reviewErrorMessageText.isDisplayed());
	}
}
