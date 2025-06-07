import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // update path
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testValidLogin() {
        boolean result = performLogin("test1", "Test12456");
        assertTrue(result, "Login should succeed with valid credentials");
    }

    @Test
    public void testInvalidLogin() {
        boolean result = performLogin("test1", "wrongpass");
        assertFalse(result, "Login should fail with invalid credentials");

    public static boolean performLoginTest(String username, String password) {
        try {
            driver.get("https://letsusedata.com/login");
            WebElement userfield = driver.findElement(By.id("username")); 
            WebElement passwordfield = driver.findElement(By.id("password")); 
            WebElement loginButton = driver.findElement(By.id("loginButton")); 
            usernameInput.clear();
            usernameInput.sendKeys(username);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            loginButton.click();
            Thread.sleep(2000);
            String pageUrl = driver.getCurrentUrl().toLowerCase();
            String pageText = driver.getPagesource().toLowerCase();
            return pageUrl.contains("dashboard") || pageSource.contiains("welcome");

        } catch (Exception e) {
            System.out.println("Exception during test: " + e.getMessage());
        }
    }
}

