package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {

    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @Given("^new user is selected$")
    public void new_user_is_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is successfully created$")
    public void user_with_username_with_password_is_successfully_created(String username, String password) throws Throwable {
        new_user_is_selected();
        String passConf = password;
        createUserWith(username, password, passConf);
    }

    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is unsuccessfully created$")
    public void user_with_username_and_password_is_unsuccessfully_created(String username, String password) throws Throwable {
        new_user_is_selected();
        String passConf = password;
        createUserWith(username, password, passConf);
    }

    @Then("^a new user is created succesfully$")
    public void a_new_user_is_created_succesfully() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");

    }

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String error) throws Throwable {
        pageHasContent(error);
    }

    @When("^username \"([^\"]*)\", password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void username_password_and_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUserWith(username, password, passwordConfirmation);
    }

    @When("^a too short username \"([^\"]*)\", password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void a_too_short_username_password_and_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUserWith(username, password, passwordConfirmation);
    }

    @When("^username \"([^\"]*)\", a too short password \"([^\"]*)\" and password confirmation \"([^\"]*)\" are given$")
    public void username_a_too_short_password_and_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUserWith(username, password, passwordConfirmation);
    }

    @When("^username \"([^\"]*)\", an only-letters password \"([^\"]*)\" and password confirmation \"([^\"]*)\"are given$")
    public void username_an_only_letters_password_and_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUserWith(username, password, passwordConfirmation);
    }

    @When("^a taken username \"([^\"]*)\", password \"([^\"]*)\" and password confirmation \"([^\"]*)\"$")
    public void a_taken_username_password_and_password_confirmation(String username, String password, String passwordConfirmation) throws Throwable {
        createUserWith(username, password, passwordConfirmation);
    }

    @When("^username \"([^\"]*)\", password \"([^\"]*)\" and a different password confirmation \"([^\"]*)\" are given$")
    public void username_password_and_a_different_password_confirmation_are_given(String username, String password, String passwordConfirmation) throws Throwable {
        createUserWith(username, password, passwordConfirmation);
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^nonexistent username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void nonexistent_username_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void createUserWith(String username, String password, String passwordConf) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConf);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
