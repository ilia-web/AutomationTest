package PageObject;

import org.openqa.selenium.By;

public interface CheckoutPage {
    By
            checkOutButton = By.id("checkout"),
            checkOutFirstName = By.id("first-name"),
            checkOutLastName = By.id("last-name"),
            checkOutZipCode = By.id("postal-code"),
            checkOutContinueBtn = By.id("continue"),
            checkOutFinishBtn = By.id("finish"),
            checkOutBackHomeBtn = By.id("back-to-products");

}
