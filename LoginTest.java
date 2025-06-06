import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 

public class LoginTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        testLogin(driver, "test1", "Test12456", true);
        testLogin(driver, "test1", "test1234", false); 
        driver.quit();
    }

    public static void performLoginTest(WebDriver driver, String username, String password, boolean shouldLoginSucceed) {
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
            String currentPage = driver.getCurrentUrl().toLowerCase();
            String pageText = driver.getPagesource().toLowerCase();
             boolean loginSucceeded = currentPage.contains("dashboard") || pageText.contains("welcome");
            boolean loginFailed = currentPage.contains("login") || pageText.contains("invalid username or password");
            
            

            if (expectedResult && loginSucceeded) {
                System.out.println("Passed with correct Login");
            } else if (!expectedResult && loginFailed) {
                System.out.println("Passed with uncorrect Login.");
            } else {
                System.out.println("Failed: Unexpected login behavior.");
            }

        } catch (Exception e) {
            System.out.println("Exception during test: " + e.getMessage());
        }
    }
}

