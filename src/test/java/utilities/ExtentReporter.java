package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
static ExtentReports extentReport;
	
	public static ExtentReports getExtentReport() {
		
		String extentReportPath=System.getProperty("user.dir")+"\\target\\extentreport.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("Magento Demo Store Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Windows 10");
		
		return extentReport;
	}

}
