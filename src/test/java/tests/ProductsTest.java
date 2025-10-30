package tests;

import models.ShipInfo;
import models.User;
import pages.CartPage;
import pages.ProductsPage;
import org.junit.jupiter.api.Test;
import parameters.RandomUser;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static data.Users.STANDART_USER;

@RandomUser
public class ProductsTest extends BaseTest {

    @Test
    public void testSuccessfulLogout() {
        loginPage.loginAs(STANDART_USER.getLOGIN(), STANDART_USER.getPASSWORD())
                .clickOnLogout();
        assertThat(page).hasURL("https://www.saucedemo.com/");
    }

    @Test
    public void testSortItems() {
        ProductsPage productsPage = loginPage.loginAs(STANDART_USER.getLOGIN(), STANDART_USER.getPASSWORD());

        assertThat(productsPage.getProductNames().first()).hasText("Sauce Labs Backpack");

        productsPage.setSortFilter("Name (Z to A)");

        assertThat(productsPage.getProductNames().first()).hasText("Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void testAddItemToCartAndBuy(@RandomUser User testUser) {
        ProductsPage productsPage = loginPage.loginAs(STANDART_USER.getLOGIN(), STANDART_USER.getPASSWORD());
        String firstItemName = productsPage.getProductNames().first().textContent();

        CartPage cartPage = productsPage.addItemToCart(firstItemName).clickOnCart();

        assertThat(cartPage.getItems()).containsText(firstItemName);

        ShipInfo shipInfo = ShipInfo.builder()
                .firstName(testUser.getName())
                .lastName(testUser.getLastName())
                .zip(testUser.getZipCode().toString())
                .build();

        cartPage.clickOnCheckout().fillInfo(shipInfo).clickOnContinue().clickOnFinish();

        assertThat(cartPage.getCompleteHeader()).hasText("Thank you for your order!");
    }
}
