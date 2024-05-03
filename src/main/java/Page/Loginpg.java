package Page;

import Base_Parent.Testbase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpg extends Testbase {

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_txtEmail\"]")
    WebElement mob;
    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_txtPassword\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_btnLogin\"]")
    WebElement loginbtn;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_plnLoginPassword\"]/div[4]/div/a")
    WebElement signupbtn;

    @FindBy(xpath = "//div[@class='container-fluid desktopheader mobilehide']")
    WebElement img;

    @FindBy(id = "ctl00_phBody_SignIn_btnRequestOTP")
    WebElement otp;


    public Loginpg() {
        PageFactory.initElements(driver, this);
    }

    @Given("user is on the login page")
    @When("user enters valid username and password")
    public String title() {
        return driver.getTitle();
    }

    @And("clicks on the login button")
    public boolean img() {

        return img.isDisplayed();
    }

    @Then("user should be navigated to the home page")
    public Home Login(String mobile, String pass) {
        mob.sendKeys(mobile);
        password.sendKeys(pass);
        loginbtn.click();
        return new Home();
    }

    public void getotp() {
        mob.sendKeys(prop.getProperty("mobile"));
        otp.click();

    }


}
