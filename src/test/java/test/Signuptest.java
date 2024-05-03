package test;

import Base_Parent.Testbase;
import Page.Signup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.element.Name;
import java.time.Duration;

import static Page.Signup.captcha;

public class Signuptest extends Testbase {

    Signup sc;

    public Signuptest() {
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        sc = new Signup();
        sc.Signupclick();
        Thread.sleep(2000);
    }
    @Test
    public void checkname() throws InterruptedException {
        sc.entername(prop.getProperty("name"));
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.id("ctl00_phBody_SignUp_txtName"));
        String name = ele.getAttribute("value");
        Assert.assertEquals(name,prop.getProperty("name"));
    }
    @Test
    public void checkno(){
        sc.enterno(prop.getProperty("mobile"));
        WebElement ele = driver.findElement(By.id("ctl00_phBody_SignUp_txtEmail"));
        String no = ele.getAttribute("value");
        Assert.assertEquals(no,prop.getProperty("mobile"));
    }

//    @Test
//    public void captcha() {
//        sc.captcha();
//        WebElement ele = driver.findElement(By.xpath("//div[@class='container-fluid desktopheader mobilehide smallheader']"));
//       Boolean result = ele.isSelected();
//
//        Assert.assertTrue(result);
//    }

    @Test
    public void checkcontinuebtn() throws InterruptedException {
        Thread.sleep(5000);
        sc.continuebtn();

    }

@Test
    public void title(){
      String title =  sc.gettitle();
    System.out.println(title);
      Assert.assertEquals(title,"Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");


    }


}




