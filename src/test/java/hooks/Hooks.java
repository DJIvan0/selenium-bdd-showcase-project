package hooks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import resources.Driver;

public class Hooks {

	private Driver driverClass;
	private WebDriver driver;

	@Before(order = 0)
	public void setUp() throws IOException {
		driverClass = new Driver();
		driver = driverClass.initializeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
