import StepObject.addCartSteps;
import StepObject.checkoutSteps;
import StepObject.logInSteps;
import Utils.ChromeRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DataObject.LogInData.*;
import static DataObject.checkoutData.*;
import static PageObject.AddCartPage.productSort;

public class logInSite extends ChromeRunner {

    @Test (groups = "positivcases", priority = 1)
    public void logInWeb() {
        logInSteps step = new logInSteps(driver);

        step.logName(username);
        step.logPassword(password);
        step.logBtn();

    }

        @Test (groups = "positivcases", priority = 3)
        public void addItemInCart() throws InterruptedException {
            logInSteps step = new logInSteps(driver);
            step.logName(username);
            step.logPassword(password);
            step.logBtn();

            addCartSteps step1 = new addCartSteps(driver);
            step1.addToCart();

            WebElement shopItem = driver.findElement(By.className("shopping_cart_badge"));
            Assert.assertTrue(shopItem.isDisplayed());

        }


        @Test (groups = "positivcases", priority = 4)
        public void dropdownItem() throws InterruptedException {
            logInSteps step = new logInSteps(driver);
            step.logName(username);
            step.logPassword(password);
            step.logBtn();


            Select selectOptions = new Select(driver.findElement(productSort));
            int dropdownSize = selectOptions.getOptions().size();

            for (int i = 0; i <dropdownSize; i++){
                selectOptions = new Select(driver.findElement(productSort));
                selectOptions.selectByIndex(i);
                Thread.sleep(3000);

            }

        }

    @Test (groups = "positivcases", priority = 2)
    public void checkOutItem() throws InterruptedException {
        logInSteps step = new logInSteps(driver);
        step.logName(username);
        step.logPassword(password);
        step.logBtn();

        addCartSteps step1 = new addCartSteps(driver);
        Thread.sleep(2000);
        step1.addToCart();
        step1.addCartIconBtn();

        checkoutSteps step3 = new checkoutSteps(driver);

        step3.checkoutStart();
        step3.checkoutName(checkOutFirstName);
        step3.checkoutLast(checkOutLastName);
        step3.checkoutZip(checkOutZipCode);
        step3.checkoutContinueBtn();
        step3.checkoutFinish();

        WebElement element = driver.findElement(By.className("complete-header"));
        String actualTitle = element.getText();
        String expectedTitle = "Thank you for your order!";
        Assert.assertEquals(actualTitle, expectedTitle);

        step3.checkoutHomePage();

    }

    @Test (groups = "negativeCases", priority = 5)
    public void incorrectLogin(){
        logInSteps step = new logInSteps(driver);

        step.logName(username);
        step.logPassword(incorrectPassword);
        step.logBtn();

        WebElement element = By.xpath(
                "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]").findElement(driver);
        System.out.println(element.isDisplayed());

        //check error message background color
        WebElement errorMessageContainer = driver.findElement(By.xpath("//div[contains(@class, 'error-message-container error')]"));
        String background_color = "rgba(226, 35, 26, 1)";
        String errorMessageColor = errorMessageContainer.getCssValue("background-color");
        Assert.assertEquals(errorMessageColor,background_color);
        driver.quit();

    }




}