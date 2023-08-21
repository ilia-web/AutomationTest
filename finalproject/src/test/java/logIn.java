import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.sleep;


public class logIn {

//    @Test
//
//    public void logInWeb() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com");
//
//        By
//                logInField = By.id("user-name"),
//                logInPassword = By.id("password"),
//                logInButton = By.id("login-button");
//
//        driver.findElement(logInField).sendKeys("standard_user");
//        driver.findElement(logInPassword).sendKeys("secret_sauce");
//        driver.findElement(logInButton).sendKeys(Keys.ENTER);
//
//        Thread.sleep(4000);
//
//
//        driver.quit();
//    }

//    @Test
//
//    public void addItemInCart() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com");
//
//        By
//                addCartBtn = By.id("add-to-cart-sauce-labs-backpack"),
//                logInField = By.id("user-name"),
//                logInPassword = By.id("password"),
//                logInButton = By.id("login-button");
//
//
//        driver.findElement(logInField).sendKeys("standard_user");
//        driver.findElement(logInPassword).sendKeys("secret_sauce");
//        driver.findElement(logInButton).sendKeys(Keys.ENTER);
//        sleep(2000);
//
//        driver.findElement(addCartBtn).click();
//        WebElement shopItem = driver.findElement(By.className("shopping_cart_badge"));
//        Assert.assertTrue(shopItem.isDisplayed());
//
//
//        driver.quit();
//    }

    @Test

    public void incorrectLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        By
                logInField = By.id("user-name"),
                logInPassword = By.id("password"),
                logInButton = By.id("login-button");

        driver.findElement(logInField).sendKeys("standard_user");
        driver.findElement(logInPassword).sendKeys("secret_saucesadasd");
        driver.findElement(logInButton).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath(
                "//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
        System.out.println(element.isDisplayed());

        WebElement errorMessageContainer = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]"));
        String background_color = "rgb(226, 35, 26)";
        String errorMessageColor = errorMessageContainer.getCssValue("background_color");
        Assert.assertEquals(errorMessageColor, background_color);

    }

//    @Test
//
//    public void buyItem() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com");
//
//        By
//                addCartBtn = By.id("add-to-cart-sauce-labs-backpack"),
//                logInField = By.id("user-name"),
//                logInPassword = By.id("password"),
//                logInButton = By.id("login-button"),
//                shoppingCart = By.id("shopping_cart_container"),
//                checkOutBtn = By.id("checkout"),
//                checkOutFirstName = By.id("first-name"),
//                checkOutLastName = By.id("last-name"),
//                checkOutZipCode = By.id("postal-code"),
//                checkOutContinueBtn = By.id("continue"),
//                checkOutFinishBtn = By.id("finish"),
//                checkOutBackHomeBtn = By.id("back-to-products");
//
//
//        driver.findElement(logInField).sendKeys("standard_user");
//        driver.findElement(logInPassword).sendKeys("secret_sauce");
//        driver.findElement(logInButton).sendKeys(Keys.ENTER);
//        sleep(1000);
//        driver.findElement(addCartBtn).click();
//        sleep(1000);
//        driver.findElement(shoppingCart).click();
//        sleep(1000);
//        driver.findElement(checkOutBtn).click();
//        sleep(1000);
//        driver.findElement(checkOutFirstName).sendKeys("ilia");
//        driver.findElement(checkOutLastName).sendKeys("bur");
//        driver.findElement(checkOutZipCode).sendKeys("1234");
//        sleep(1000);
//        driver.findElement(checkOutContinueBtn).click();
//        sleep(1000);
//        driver.findElement(checkOutFinishBtn).click();
//        ;
//        sleep(1000);
//        //
//
//        WebElement element = driver.findElement(By.className("complete-header"));
//        String actualTitle = element.getText();
//        String expectedTitle = "Thank you for your order!";
//        Assert.assertEquals(actualTitle, expectedTitle);
//        sleep(1000);
//        driver.findElement(checkOutBackHomeBtn).click();
//        ;
//        sleep(1000);
//
//        driver.quit();
//
//    }
//        @Test
//
//        public void dropdownItem() throws InterruptedException {
//            WebDriver driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://www.saucedemo.com");
//
//            By
//                    logInField = By.id("user-name"),
//                    logInPassword = By.id("password"),
//                    logInButton = By.id("login-button"),
//                    productSort = By.className("product_sort_container");
//
//            driver.findElement(logInField).sendKeys("standard_user");
//            driver.findElement(logInPassword).sendKeys("secret_sauce");
//            driver.findElement(logInButton).sendKeys(Keys.ENTER);
//
//            Select selectOptions = new Select(driver.findElement(productSort));
//            int dropdownSize = selectOptions.getOptions().size();
//
//            for (int i = 0; i <dropdownSize; i++){
//                selectOptions = new Select(driver.findElement(productSort));
//                selectOptions.selectByIndex(i);
//                Thread.sleep(3000);
//            }
//            driver.quit();

//    }

}