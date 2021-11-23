package OrangeHr;

import Reports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import utils.DriverManager;


import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;



public class BaseClassConfig {
    public WebDriver driver;


     public BaseClassConfig(){
         this.driver = DriverManager.getDriver();
     }


    public  void launchDriver(){
        try {
            String path= System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator;
            System.setProperty("webdriver.chrome.driver",path+ "chromedriver");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");
            DriverManager.setDriver(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void testResultCapture(ITestResult result) throws NullPointerException {

        System.out.println("===============================Check status======================================" + result.getStatus());
        /**
         * Success Block
         */
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + " Passed");
        }

        /**
         * Failure Block
         */
        try {

            if (result.getStatus() == ITestResult.FAILURE) {
                if (result.getThrowable().getMessage().contains("Skipped By retry")) {
                    ExtentTestManager.getExtentTest().getExtent().removeTest(ExtentTestManager.getExtentTest());
                } else {
                    StringWriter exceptionInfo = new StringWriter();
                    result.getThrowable().printStackTrace(new PrintWriter(exceptionInfo));

                    String methodClassName = result.getThrowable().getMessage();
                    for (StackTraceElement stack : result.getThrowable().getStackTrace()) {
                        if (stack.getClassName().contains("Pages.PageActions")) {
                            methodClassName = methodClassName + "   Failed in Class: " + stack.getClassName() +
                                    ",  in Method : " + stack.getMethodName() +
                                    ",  and Line : " + stack.getLineNumber();
                            break;
                        }
                    }
                    ExtentTestManager.getExtentTest().fail(methodClassName);
                    ExtentTestManager.getExtentTest().addScreenCaptureFromBase64String(getBase64());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Capture screen shot
     * @return
     */
    public String getBase64() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }

}
