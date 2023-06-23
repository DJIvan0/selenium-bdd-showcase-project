package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features=("src/test/java/features"),
		glue={"stepDefinitions", "hooks"},
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class MagentoStoreCucumberRunner extends AbstractTestNGCucumberTests{

}
