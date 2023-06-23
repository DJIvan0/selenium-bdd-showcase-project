package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import resources.PasswordLength;
import resources.PasswordStrength;
import resources.User;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	private JavascriptExecutor je = (JavascriptExecutor) driver;
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@FindBy(how = How.ID, using = "firstname")
	private WebElement firstNameInputField;

	@FindBy(how = How.ID, using = "lastname")
	private WebElement lastNameInputField;

	@FindBy(how = How.ID, using = "email_address")
	private WebElement emailInputField;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordInputField;

	@FindBy(how = How.ID, using = "password-confirmation")
	private WebElement confirmPasswordInputField;

	@FindBy(how = How.ID, using = "is_subscribed")
	private WebElement newsletterSubscriptionCheckbox;

	@FindBy(how = How.XPATH, using = "//form[@id='form-validate']//button")
	private WebElement createAnAccountButton;

	@FindBy(how = How.ID, using = "firstname-error")
	private WebElement firstNameErrorMessageText;

	@FindBy(how = How.ID, using = "lastname-error")
	private WebElement lastNameErrorMessageText;

	@FindBy(how = How.ID, using = "email_address-error")
	private WebElement emailErrorMessageText;

	@FindBy(how = How.ID, using = "password-error")
	private WebElement passwordErrorMessageText;

	@FindBy(how = How.ID, using = "password-confirmation-error")
	private WebElement confirmPasswordErrorMessageText;

	@FindBy(how = How.ID, using = "password-strength-meter-label")
	private WebElement passwordStrengthMeterLabel;
	
	public void clickOnCreateAnAccountButton() {
		scrollToElements(createAnAccountButton);
		je.executeScript("arguments[0].click();", createAnAccountButton);
	}
	
	public void fillOutAllMandatoryFields(User user) {
		if (!user.getFirstName().isEmpty()) {
			firstNameInputField.sendKeys(user.getFirstName());
		}

		if (!user.getLastName().isEmpty()) {
			lastNameInputField.sendKeys(user.getLastName());
		}

		if (!user.getEmail().isEmpty()) {
			emailInputField.sendKeys(user.getEmail());
		}

		if (!user.getPassword().isEmpty()) {
			passwordInputField.sendKeys(user.getPassword());
		}

		if (!user.getConfirmPassword().isEmpty()) {
			confirmPasswordInputField.sendKeys(user.getConfirmPassword());
		}
	}
	
	public void checkSubscriptionBox() {
		newsletterSubscriptionCheckbox.click();
	}
	
	public void inputEmail(User user, boolean validFormat) {
		if (validFormat) {
			emailInputField.sendKeys(user.getEmail());
			clickOnCreateAnAccountButton();
		} else {
			emailInputField.sendKeys(user.getEmail().replace("@", ""));
			clickOnCreateAnAccountButton();
		}
	}
	
	public void validateEmailField(boolean validFormat) {
		if (validFormat) {
			wait.until(ExpectedConditions.invisibilityOf(emailErrorMessageText));
			Assert.assertTrue(!emailErrorMessageText.isDisplayed());
		} else {
			Assert.assertEquals(emailErrorMessageText.getText(),
					"Please enter a valid email address (Ex: johndoe@domain.com).");
		}
	}

	public void inputPasswordWithCertainLength(User user, PasswordLength passwordLenght) {
		if (passwordLenght == PasswordLength.LESS_THAN_EIGHT) {
			passwordInputField.sendKeys(user.getPassword().substring(0, 7));
			passwordInputField.click();
		} else if (passwordLenght == PasswordLength.EIGHT) {
			passwordInputField.sendKeys(user.getPassword().substring(0, 8));
			passwordInputField.click();
		} else if (passwordLenght == PasswordLength.MORE_THAN_EIGHT) {
			passwordInputField.sendKeys(user.getPassword());
			passwordInputField.click();
		}
	}
	
	public void validatePasswordLength(PasswordLength passwordLenght) {
		String actualMessage = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
		if(passwordLenght == PasswordLength.LESS_THAN_EIGHT) {
			Assert.assertEquals(passwordErrorMessageText.getText(), actualMessage);
		} else if (passwordLenght == PasswordLength.EIGHT_OR_MORE) {
			Assert.assertTrue(!passwordErrorMessageText.getText().equalsIgnoreCase(actualMessage));
		}
	}

	public void inputMatchingPasswords(User user, boolean matching) {
		if (matching) {
			passwordInputField.sendKeys(user.getPassword());
			user.setConfirmPassword(user.getPassword());
			confirmPasswordInputField.sendKeys(user.getConfirmPassword());
			clickOnCreateAnAccountButton();
		} else {
			passwordInputField.sendKeys(user.getPassword());
			confirmPasswordInputField.sendKeys(user.getConfirmPassword() + ".");
			clickOnCreateAnAccountButton();
		}
	}
	
	public void validateMatchingPasswords(boolean matching) {
		if (matching) {
			wait.until(ExpectedConditions.invisibilityOf(confirmPasswordErrorMessageText));
			Assert.assertTrue(!confirmPasswordErrorMessageText.isDisplayed());
		} else {
			Assert.assertEquals(confirmPasswordErrorMessageText.getText(), "Please enter the same value again.");
		}
	}

	public void inputPasswordWithCertainStrength(User user, PasswordStrength passwordStrength) {
		if (passwordStrength == PasswordStrength.WEAK) {
			passwordInputField.sendKeys(user.getPassword());
		} else if (passwordStrength == PasswordStrength.STRONG) {
			passwordInputField.sendKeys(user.getPassword().substring(0, 8).concat("A"));
		} else if (passwordStrength == PasswordStrength.VERY_STRONG) {
			passwordInputField.sendKeys(user.getPassword().concat("A!."));
		}
	}
	
	public void validatePasswordStrengthMeterIsWorking(PasswordStrength passwordStrength) {
		if (passwordStrength == PasswordStrength.WEAK) {
			Assert.assertEquals(passwordStrengthMeterLabel.getText(), "Weak");
			Assert.assertTrue(passwordStrengthMeterLabel.isDisplayed());
		} else if (passwordStrength == PasswordStrength.STRONG) {
			Assert.assertEquals(passwordStrengthMeterLabel.getText(), "Strong");
			Assert.assertTrue(passwordStrengthMeterLabel.isDisplayed());
		} else if (passwordStrength == PasswordStrength.VERY_STRONG) {
			Assert.assertEquals(passwordStrengthMeterLabel.getText(), "Very Strong");
			Assert.assertTrue(passwordStrengthMeterLabel.isDisplayed());
		}
	}

	public void assertAllMandatoryFields() {
		String actualMessage = "This is a required field.";
		scrollToElements(firstNameErrorMessageText);
		Assert.assertEquals(firstNameErrorMessageText.getText(), actualMessage);
		Assert.assertEquals(lastNameErrorMessageText.getText(), actualMessage);
		Assert.assertEquals(emailErrorMessageText.getText(), actualMessage);
		Assert.assertEquals(passwordErrorMessageText.getText(), actualMessage);
		Assert.assertEquals(confirmPasswordErrorMessageText.getText(), actualMessage);
	}

	public void scrollToElements(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
