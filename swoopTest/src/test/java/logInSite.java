import StepObject.addCartSteps;
import StepObject.checkoutSteps;
import StepObject.logInSteps;
import Utils.ChromeRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DataObject.LogInData.password;
import static DataObject.LogInData.username;
import static DataObject.checkoutData.*;
import static PageObject.AddCartPage.productSort;
import org.openqa.selenium.By;

public class logInSite extends ChromeRunner {

        @Test (groups = "positivcases",enabled = false )

        public void logInWeb() {
            logInSteps step = new logInSteps(driver);

            step.logName(username);
            step.logPassword(password);
            step.logBtn();
        }


        @Test (groups = "positivcases" )

        public void addItemInCart(){
            logInSteps step = new logInSteps(driver);
            step.logName(username);
            step.logPassword(password);
            step.logBtn();

            addCartSteps step1 = new addCartSteps(driver);
            step1.addToCart();

            WebElement shopItem = driver.findElement(By.className("shopping_cart_badge"));
            Assert.assertTrue(shopItem.isDisplayed());
        }



        @Test (groups = "positivcases")

        public void checkOutItem(){
            logInSteps step = new logInSteps(driver);
            step.logName(username);
            step.logPassword(password);
            step.logBtn();

            addCartSteps step1 = new addCartSteps(driver);
            step1.addToCart();

            checkoutSteps step3 = new checkoutSteps(driver);

            step3.checkoutStart();
            step3.checkoutName(checkOutFirstName);
            step3.checkoutLast(checkOutLastName);
            step3.checkoutZip(checkOutZipCode);
            step3.checkoutContinueBtn();
            step3.checkoutFinish();
            step3.checkoutHomePage();


            WebElement element = driver.findElement(By.className("complete-header"));
            String actualTitle = element.getText();
            String expectedTitle = "Thank you for your order!";
            Assert.assertEquals(actualTitle, expectedTitle);

        }

        @Test (groups = "positivcases")

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
    @Test (groups = "negativeCases", enabled = false)

    public void incorrectLogin() throws InterruptedException {
        logInSteps step = new logInSteps(driver);

        step.logName(username);
        step.logPassword(password);
        step.logBtn();

        WebElement element = driver.findElement(By.xpath(
                "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
        System.out.println(element.isDisplayed());

    }

}