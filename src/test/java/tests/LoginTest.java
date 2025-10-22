package tests;

import pages.ProductsPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static data.Users.STANDART_USER;
import static data.Users.WRONG_USER;

public class LoginTest extends BaseTest {

    @Test
    public void testCorrectLoginCredentials() {
        ProductsPage productsPage = loginPage.loginAs(STANDART_USER.getLOGIN(), STANDART_USER.getPASSWORD());
        assertThat(productsPage.getTitle()).hasText("Products");
    }

    @Test
    public void testLockedOutUser() {
        loginPage.loginAs(WRONG_USER.getLOGIN(), WRONG_USER.getPASSWORD());
        assertThat(loginPage.getErrorMessage())
                .hasText("Epic sadface: Username and password do not match any user in this service");
    }
}
