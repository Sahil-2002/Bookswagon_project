package test;

import Base_Parent.Testbase;
import Page.Home;
import Page.Loginpg;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hometest extends Testbase {
Loginpg obj;
    Home home;

    public Hometest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();

         obj = new Loginpg();
         home = obj.Login(prop.getProperty("mobile"), prop.getProperty("password"));
    }

    @Test
    public void gettitle() {
        String title = home.title();
        Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }

    @Test
    public void checkwhishlist() {
        Boolean result = home.whishlistimg();
        Assert.assertTrue(result);
    }

    @Test
    public void bestseller() throws InterruptedException {
        home.setBestseller();
    }

@Test
    public void checkpersonality() throws InterruptedException {
       String name = home.setPersonalsetting();
       Thread.sleep(2000);
       Assert.assertEquals(name,prop.getProperty("name"));

    }

    @Test
    public void reqpage(){
        home.gotorequestpage();
    }

}

