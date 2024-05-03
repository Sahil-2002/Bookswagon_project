package test;

import Base_Parent.Testbase;
import Page.Home;
import Page.Loginpg;
import Util.Testutil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(Listner.TestListener.class)
public class Loginpgtest extends Testbase {
    Loginpg lc;
    Home home;

    public Loginpgtest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        lc = new Loginpg(); // Initialize Loginpg instance here
    }


    @Test(priority = 1)
    public void gettitle() {
        log.trace("gettitle method started ...");
        String title = lc.title();
        System.out.println("title is " + title);
        Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
        // Add assertion for title
        log.trace("gettitle method executed ...");

    }

    @Test(priority = 2)
    public void checkimg() {
        log.info("checking whether img is displayed or not ");
        Boolean value = lc.img();
        System.out.println(value);
        Assert.assertTrue(value);
        log.warn("Img might be shifted to different axis of page  ");
    }


    @Test(priority = 3)
    @Severity(SeverityLevel.BLOCKER)
    @Description("User login the application")
    @Feature("Login : 1")
    @Story("The user enter the valid username and password then login the application")
    public void login() {
        log.info("Login test method is  running ...");
        home = lc.Login(prop.getProperty("mobile"), prop.getProperty("password"));
    }


    @Test(priority = 4)
    public void otpcheck() {
        lc.getotp();
        log.warn("OTP might take some time to generate ");
    }

    @DataProvider
    public Object[][] getdata() {
        Object[][] data = Testutil.gettestdataforlogin("Login");
        return data;
    }


    @Test(dataProvider = "getdata")
    public void multipleuserlogin(String Mobile, String Password) {
        lc.Login(Mobile, Password);
        log.fatal("File should be connected to code till its execution ");
    }


    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit(); // Use quit() to close the browser and end the WebDriver session
    }
}
