package StepObject;

import PageObject.AddCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addCartSteps implements AddCartPage {
    WebDriver driver;
    public addCartSteps (WebDriver driver1){
        driver = driver1;
    }

    public void addToCart(){
        driver.findElement(addCartBtn).click();
    }

    public void addCartIconBtn(){
        driver.findElement(shoppingCart).click();
    }


}
