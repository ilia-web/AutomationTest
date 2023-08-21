package StepObject;

import PageObject.LogInPage;
import org.openqa.selenium.WebDriver;

public class logInSteps implements LogInPage {
    WebDriver driver;
    public logInSteps(WebDriver driver1){
        driver = driver1;
    }

    public void logName(String a){
        driver.findElement(logInName).sendKeys(a);
    }

    public void logPassword(String a){
        driver.findElement(logInPassword).sendKeys(a);
    }

    public void logBtn(){
        driver.findElement(logInButton).click();
    }
}
