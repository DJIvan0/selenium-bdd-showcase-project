package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//h1[@class='page-title']")
	private WebElement myAccountHeading;

	public void assertHeadingnPresent() {
		Assert.assertTrue(myAccountHeading.isDisplayed());
	}
}
