package StepObject;

import PageObject.CheckoutPage;
import org.openqa.selenium.WebDriver;

public class checkoutSteps implements CheckoutPage {
    WebDriver driver;
    public checkoutSteps(WebDriver driver1){
        driver = driver1;
    }

    public void checkoutStart(){
        driver.findElement(checkOutButton).click();
    }
    public void checkoutName(String a){
        driver.findElement(checkOutFirstName).sendKeys(a);
    }

    public void checkoutLast(String a){
        driver.findElement(checkOutLastName).sendKeys(a);
    }

    public void checkoutZip(String a){
        driver.findElement(checkOutZipCode).sendKeys(a);
    }

    public void checkoutContinueBtn(){
        driver.findElement(checkOutContinueBtn).click();
    }

    public void checkoutFinish(){
        driver.findElement(checkOutFinishBtn).click();
    }

    public void checkoutHomePage(){
        driver.findElement(checkOutBackHomeBtn).click();
    }
}
