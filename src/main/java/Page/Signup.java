package Page;

import Base_Parent.Testbase;
import org.apache.poi.ss.formula.functions.Na;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup extends Testbase {

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_plnLoginPassword\"]/div[4]/div/a")
    WebElement signupclick;
    @FindBy(id = "ctl00_phBody_SignUp_txtName")
    WebElement Name;
    @FindBy(id = "ctl00_phBody_SignUp_txtEmail")
    WebElement mobno;
    @FindBy(xpath = "//div[@class='container-fluid desktopheader mobilehide smallheader']")
   public static WebElement captcha;
    @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignUp_btnContinue\"]")
    WebElement continuebutton;


    public Signup(){
        PageFactory.initElements(driver,this);
    }

    public void Signupclick(){
        signupclick.click();
    }
    public String  entername(String name){
        Name.sendKeys(name);
        return name;
    }
    public String enterno(String no){
        mobno.sendKeys(no);
        return no;
    }
    public void captcha(){
        captcha.click();
    }
    public void continuebtn(){
        continuebutton.click();
    }

    public String gettitle(){
        String ele = driver.getTitle();
        return ele;
    }

    public void setContinuebutton(){
        continuebutton.click();
    }



}
