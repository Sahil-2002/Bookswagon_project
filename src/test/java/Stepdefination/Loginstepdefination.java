package Stepdefination;

import Base_Parent.Testbase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class Loginstepdefination extends Testbase {

    WebDriver driver;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("login page ");
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        System.out.println("usrname and pass");
        throw new io.cucumber.java.PendingException();
    }
    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        System.out.println("click ..");
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should be navigated to the home page")
    public void user_should_be_navigated_to_the_home_page() {
        System.out.println("home page ");
        throw new io.cucumber.java.PendingException();
    }

}
