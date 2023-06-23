package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FusionBackpackProductPage extends BasePage {

	public FusionBackpackProductPage(WebDriver driver) {
		super(driver);
	}
	
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@FindBy(how = How.XPATH, using = "//a[@aria-label='store logo']//img")
	private WebElement homePageLink;
	
	@FindBy(how = How.XPATH, using = "//a[@data-role='add-to-links']")
	private WebElement addToCompareLink;

	@FindBy(how = How.XPATH, using = "//div[@role='alert']")
	private WebElement confirmationMessage;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Compare Products']")
	private WebElement compareProductsPageLink;

	@FindBy(how = How.XPATH, using = "//a[text()='comparison list']")
	private WebElement compareProductsPageConfirmationMessageLink;
	
	public void clickAddToCompareLink() {
		addToCompareLink.click();
	}

	public void proceedToProductComparisonPage(boolean headerLink) {
		if(headerLink) {
			wait.until(ExpectedConditions.visibilityOf(compareProductsPageLink));
			compareProductsPageLink.click();
		}else {
			wait.until(ExpectedConditions.visibilityOf(compareProductsPageConfirmationMessageLink));
			compareProductsPageConfirmationMessageLink.click();
		}
	}
}
