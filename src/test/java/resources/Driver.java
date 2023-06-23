package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	private Properties properties;

	public WebDriver initializeDriver() throws IOException {
		
		String browserName = getProperties("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			tlDriver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless");
			tlDriver.set(new FirefoxDriver(options));
		}else if (browserName.equalsIgnoreCase("IE")) {
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless");
			tlDriver.set(new EdgeDriver(options));
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		getDriver().get(properties.getProperty("url"));
		
		return getDriver();
	}
	
	public String getProperties(String property) throws IOException {
		properties=new Properties();
		
		String propertyPath=System.getProperty("user.dir")+"\\src\\test\\java\\resources\\data.properties";
		FileInputStream fileInputStream=new FileInputStream(propertyPath);
		properties.load(fileInputStream);
		
		return properties.getProperty(property);
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
