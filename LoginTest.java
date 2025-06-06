import org.openqa.selenium.By; // for using HTML USING ID
import org.openqa.selenium.WebDriver; // Using for WebDriver
import org.openqa.selenium.WebElement; // represent any HTML ELEMENTS
import org.openqa.selenium.chrome.ChromeDriver; // helps to use chrome using selenium

public class LoginTest {

    public static void main(String[] args) {
        // It helps to path chromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // open new file to chrome
        WebDriver driver = new ChromeDriver();

        // Successful Login Test
        testLogin(driver, "test1", "Test12456", true);

        // Unsuccessful Login Test
        testLogin(driver, "test1", "test1234", false);

        // 
        driver.quit();
    }

    public static void testLogin(WebDriver driver, String username, String password, boolean shouldLoginSucceed) {
        try {
            // Navigate to login page
            driver.get("https://letsusedata.com/login");

            // Find username and possword from mail
            WebElement usernameInput = driver.findElement(By.id("username")); // Adjust ID if needed
            WebElement passwordInput = driver.findElement(By.id("password")); // Adjust ID if needed
            WebElement loginButton = driver.findElement(By.id("loginButton")); // Adjust ID if needed

            // clear existing values
            usernameInput.clear();
            usernameInput.sendKeys(username);

            passwordInput.clear();
            passwordInput.sendKeys(password);

            // clicking login button
            loginButton.click();

            // Wait a few seconds 
            Thread.sleep(2000);

            if (shouldLoginSucceed) {
                if (driver.getPageSource().contains("Welcome") || driver.getCurrentUrl().contains("dashboard")) {
                    System.out.println("✅ Successful login test passed.");
                } else {
                    System.out.println("❌ Successful login test failed.");
                }
            } else {
                if (driver.getPageSource().contains("Invalid username or password") || driver.getCurrentUrl().contains("login")) {
                    System.out.println("✅ Unsuccessful login test passed.");
                } else {
                    System.out.println("❌ Unsuccessful login test failed.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error during test: " + e.getMessage());
        }
    }
}
