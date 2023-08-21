package PageObject;

import org.openqa.selenium.By;

public interface AddCartPage {
    By
        addCartBtn = By.id("add-to-cart-sauce-labs-backpack"),
        shoppingCart = By.id("shopping_cart_container"),
        productSort = By.className("product_sort_container");



}
