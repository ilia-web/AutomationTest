package PageObject;

import org.openqa.selenium.By;

public interface LogInPage {
    By
            logInName = By.id("user-name"),
            logInPassword = By.id("password"),
            logInButton = By.id("login-button");
}
