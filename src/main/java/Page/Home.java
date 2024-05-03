package Page;

import Base_Parent.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends Testbase {


    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[1]/div/a/img")
    WebElement personalsetting;
    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div/div/div/div/div[3]/div/a/img")
    WebElement wishlist;
    @FindBy(xpath = "/html/body/form/nav/div/div/div[1]/ul/li[4]/a")
    WebElement bestseller;
    @FindBy(xpath = "//*[@id=\"ctl00_li1\"]/a")
    WebElement request;


    public Home(){
        PageFactory.initElements(driver,this);

    }
    public String title(){
       String title = driver.getTitle();
       return title;
    }

    public boolean whishlistimg(){

        boolean result =wishlist.isDisplayed();
        return result;
    }

    public void setBestseller() throws InterruptedException {
        bestseller.click();
        Thread.sleep(2000);
    }

public String  setPersonalsetting() throws InterruptedException {
        personalsetting.click();
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.id("ctl00_phBody_AccountSetting_fvCustomer_txtfname"));
        String value = ele.getAttribute("value");
        return value;
}
public Request gotorequestpage(){
        request.click();
        return new Request();
}



}
