package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features=("src/test/java/features"),
		glue=("stepDefinitions"),
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports/report.html"}
		)
public class MagentoStoreCucumberRunner extends AbstractTestNGCucumberTests{

}
