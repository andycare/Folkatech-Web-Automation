package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    
    WebDriver driver = DriverFactory.getDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.navigate().to("https://lapor.folkatech.com/");
    }

    @When("I enter valid email")
    public void i_enter_valid_email() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("admin@example.com");
    }

    @When("I enter unregistered email")
    public void i_enter_unregistered_email() {
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("budi@budi.com");
    }

    @And("I enter valid password")
    public void i_enter_valid_password() {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");
    }

    @And("I enter invalid password")
    public void i_enter_invalid_password() {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("passwordddd");
    }

    @And("I click login")
    public void i_click_login() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[3]/button"));
        loginButton.click();
    }

    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://lapor.folkatech.com/admin/dashboard";

        Assert.assertEquals("The URL did not match the expected value.", expectedUrl, currentUrl);
    }

    @Then("I should see warning message 'Login Gagal! Akun tidak ada.'")
    public void i_should_see_warning_message_akun_not_found() {
        // Locate the element that contains the warning message
        WebElement warningMessageElement = driver.findElement(By.className("text-danger")); // Replace with actual selector

        // Get the text from the warning message element
        String actualMessage = warningMessageElement.getText();

        // Expected warning message
        String expectedMessage = "Login Gagal! Akun tidak ada.";

        // Assert that the actual message is equal to the expected message
        Assert.assertEquals("Warning message did not match.", expectedMessage, actualMessage);
    }

    @Then("I should see warning message 'Login Gagal! Kata sandi salah.'")
    public void i_should_see_warning_message_login_gagal() {
        // Locate the element that contains the warning message
        WebElement warningMessageElement = driver.findElement(By.className("text-danger")); // Replace with actual selector

        // Get the text from the warning message element
        String actualMessage = warningMessageElement.getText();

        // Expected warning message
        String expectedMessage = "Login Gagal! Kata sandi salah.";

        // Assert that the actual message is equal to the expected message
        Assert.assertEquals("Warning message did not match.", expectedMessage, actualMessage);
    }
}
