package Generic;

import Reports.ExtentLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonFunctions {
    public WebDriver driver;

    public CommonFunctions(WebDriver driver){
        this.driver=driver;
    }

    public  void sendKeys(WebElement element, String data,String elementName)  {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(data);
            Thread.sleep(200);
            ExtentLogger.info(elementName + " is entered :" +data);
        } catch (Exception e) {
            System.out.println("Unable to find element: " + element);
            e.printStackTrace();
        }
    }

    public void waitTillTheElementIsClickable(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitAndClick(WebElement element,String elementName) {
        waitTillTheElementIsClickable(element);
        element.click();
        ExtentLogger.info(elementName + " is Clicked");

    }

    public void acceptAlert(){
        try {
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isElementDisplayed(WebElement locator) {
        try {
            if (locator.isDisplayed())
                System.out.println("Element present on screen ***********" + locator);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not present on screen **************" + locator);
            return false;
        }
    }


    public boolean isElementPresentAssertTrue(WebElement element) {
        try {
            Assert.assertTrue(isElementDisplayed(element));
        } catch (Exception e) {
            System.out.println(element + " The Element is not found, Assertion failed");
        }
        return false;
    }

    public void scrollDown(){
        JavascriptExecutor executor=  (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1500)","");
    }

    public void scrollUp(){
        JavascriptExecutor executor=  (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,-1500)","");
    }


}
