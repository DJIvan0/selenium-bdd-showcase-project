package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Screenshot;
import utilities.ExtentReporter;

public class TestNGListeners implements ITestListener{
	
	ExtentReports extentReport= ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTestThread.set(extentTest);
		extentTestThread.get().log(Status.INFO,result.getName()+" test started execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTestThread.get().log(Status.PASS, result.getName()+" test has passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			String screenshotFilePath=Screenshot.takeScreenshot(result.getName(), (WebDriver)result
					.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance()));
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, result.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		extentTestThread.get().log(Status.FAIL, result.getName()+" test has failed");
		extentTestThread.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTestThread.get().log(Status.SKIP, result.getName()+" test has been skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
