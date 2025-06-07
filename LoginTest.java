import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
        driver.get("https://letsusedata.com/login");

        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameInput.clear();
        usernameInput.sendKeys("test1");
        passwordInput.clear();
        passwordInput.sendKeys("Test12456");
        loginButton.click();
        
        boolean isDashboard = wait.until(ExpectedConditions.urlContains("dashboard"));
        assertTrue(isDashboard, "Redirected to dashboard after login in");
    }

   @Test
    public void testInvalidLogin() {
        driver.get("https://letsusedata.com/login");

        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameInput.clear();
        usernameInput.sendKeys("test1");
        passwordInput.clear();
        passwordInput.sendKeys("test1234");
        loginButton.click();
        
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-message"))); 

        assertEquals("Invalid username or password", errorMessage.getText().trim(), "Correct-Error");
    }
}

