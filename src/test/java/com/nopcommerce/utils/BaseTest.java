package com.nopcommerce.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;

    @BeforeSuite
    public void beforeSuite() {
    	ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
    	extent = new ExtentReports();
    	extent.attachReporter(reporter);
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverFactory.initDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    protected String takeScreenshot(String name) {
        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String destPath = Paths.get("reports","screenshots", name + "_" + ts + ".png").toString();
            File dest = new File(destPath);
            dest.getParentFile().mkdirs();
            FileUtils.copyFile(src, dest);
            return destPath;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        if (extent != null) extent.flush();
    }
}
