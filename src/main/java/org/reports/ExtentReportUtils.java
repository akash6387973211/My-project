package org.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.logging.Logger;

public class ExtentReportUtils {
    static ExtentTest testCase;
    static ExtentSparkReporter sparkReporter;
    static ExtentReports extentReports;


    static final Logger logger = Logger.getLogger(ExtentReportUtils.class.getName());

    // Initialize Extent Report
    public static void initializeExtentReport(String testName) {
        if (extentReports == null) {
            System.out.println("Initializing Extent Report...");
            String reportRunDate = java.time.LocalDate.now().toString();
            String reportPath = System.getProperty("user.dir") + "\\Reports\\ExtentReport_" +reportRunDate ;
            sparkReporter = new ExtentSparkReporter(reportPath);
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            logger.info("Extent Reports initialized at: " + reportPath);
        }
    }

    public static void flush() {
        if (extentReports != null) {
            extentReports.flush();
            logger.info("Extent Reports flushed successfully.");
        } else {
            logger.warning("Extent Reports not initialized; cannot flush.");
        }
    }

    // Start the test case (Scenario)
    public static void startTestcase(String scenarioName) {
        if(extentReports!=null) {
            testCase = extentReports.createTest(scenarioName);
            logger.info("Test case started: " + scenarioName);
        } else {
            throw new IllegalStateException("ExtentReports is not initialized. Call initializeExtentReport() first.");
        }
    }

    // Add log for individual steps
    public static void logStep(String stepName, Status status, String stepDescription) {
        testCase.log(status, stepDescription);
    }

    public static void logInfo(String message) {
        testCase.info(message);
    }



    public static void setPassTestStep(String stepName, String stepDescription) {
        logStep(stepName, Status.PASS, stepDescription);
    }

    public static void setFailTestStep(String stepName, String stepDescription) {
        logStep(stepName, Status.FAIL, stepDescription);
    }

//    public static void setInfoTestStep(String stepName, String stepDescription) {
//        logStep(stepName, Status.INFO, stepDescription);
//    }
//
//    public static void setWarnTestStep(String stepName, String stepDescription) {
//        logStep(stepName, Status.WARNING, stepDescription);
//    }
}
