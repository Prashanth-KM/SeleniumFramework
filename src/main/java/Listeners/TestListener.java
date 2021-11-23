package Listeners;

import OrangeHr.BaseClassConfig;
import Reports.ExtentManager;

import org.testng.*;

public class TestListener extends BaseClassConfig implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentManager.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
       try {
           ExtentManager.flushReports();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
    }

}
