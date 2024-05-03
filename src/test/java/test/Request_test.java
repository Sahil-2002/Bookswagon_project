package test;

import Base_Parent.Testbase;
import Page.Home;
import Page.Loginpg;
import Page.Request;
import Util.Testutil;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.*;

public class Request_test extends Testbase {
    Request rc;
Loginpg lc;
Home obj;
    public Request_test() {
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        rc = new Request();
        lc = new Loginpg();
        obj = new Home();
        rc = lc.Login(prop.getProperty("mobile"),prop.getProperty("password")).gotorequestpage();
        rc= obj.gotorequestpage();
        Thread.sleep(2000);


    }
    @AfterClass
    public void close(){
        driver.quit();
    }

    @Test
    @Feature("check isbn")
    @Story("user need to enter isbn number")
    @Severity(SeverityLevel.CRITICAL)
    @Description("user need to enter isbn details to proceed further")
    public void checkisbn() {
        rc.isbn("Sahil");
        WebElement ele = driver.findElement(By.id("ctl00_phBody_RequestBook_txtISBN"));
        String name = ele.getAttribute("value");
        Assert.assertEquals(name, prop.getProperty("name"));
    }

    @Test
    public void checkbooktitle(){
        rc.setBooktitle("Stories");
        WebElement ele = driver.findElement(By.xpath("//input[@name = 'ctl00$phBody$RequestBook$txtTitle']"));
        String name = ele.getAttribute("value");
        Assert.assertEquals(name,"Stories");
    }
    @Test
    public void checkauthor(){
        rc.setAuthor("Sahil");
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"ctl00_phBody_RequestBook_txtAuthor\"]"));
        String name = ele.getAttribute("value");
        Assert.assertEquals(name,"Sahil");
    }

    @Test
    public void quantity(){

        WebElement ele = driver.findElement(By.xpath("//input[@id = 'ctl00_phBody_RequestBook_txtQty']"));
        ele.clear();
        rc.setQuantity("2");
        String name = ele.getAttribute("value");
        Assert.assertEquals(name,"2");
    }

    @Test
    public void mail(){
        rc.setMail(prop.getProperty("email"));
        WebElement ele = driver.findElement(By.xpath("//input[@id = 'ctl00_phBody_RequestBook_txtEmailReq']"));
        String name = ele.getAttribute("value");
        Assert.assertEquals(name,"sahil@gmail.com");
    }
    @Test
    public void no(){
        rc.setMobile(prop.getProperty("mobile"));
        WebElement ele = driver.findElement(By.xpath("//input[@id = 'ctl00_phBody_RequestBook_txtPhone']"));
        String name = ele.getAttribute("value");
        Assert.assertEquals(name,"9082164605");
    }

    @DataProvider
    public Object[][] data(){
        Object[][] data = Testutil.gettestdataforrequest("Request");
        return data;
    }


    @Test(dataProvider = "data")
    public  void multipledata(String Isbn, String Title, String Author, String Quantity, String Mail, String Mobile){
        rc.Multipledata(Isbn,Title,Author,Quantity,Mail,Mobile);
    }





}
