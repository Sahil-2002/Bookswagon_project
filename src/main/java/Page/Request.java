package Page;

import Base_Parent.Testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class Request extends Testbase {

    @FindBy(id = "ctl00_phBody_RequestBook_txtISBN")
    WebElement isbn;
    @FindBy(xpath = "//input[@name = 'ctl00$phBody$RequestBook$txtTitle']")
    WebElement booktitle ;
    @FindBy(xpath = "//*[@id=\"ctl00_phBody_RequestBook_txtAuthor\"]")
    WebElement author ;
    @FindBy(xpath = "//input[@id = 'ctl00_phBody_RequestBook_txtQty']")
    WebElement Quantity;
    @FindBy(xpath = "//input[@id = 'ctl00_phBody_RequestBook_txtEmailReq']")
    WebElement mail;
    @FindBy(xpath = "//input[@id = 'ctl00_phBody_RequestBook_txtPhone']")
    WebElement mobile;

    public Request(){
        PageFactory.initElements(driver,this);
    }

    public void  isbn(String name){
        isbn.sendKeys(name);
    }
    public void setBooktitle(String title){
        booktitle.sendKeys(title);
    }

    public void setAuthor(String authorname){
        author.sendKeys(authorname);
    }

    public void setQuantity(String num){
        Quantity.sendKeys(num);
    }

    public void setMail(String mailid){
        mail.sendKeys(mailid);
    }
    public void setMobile(String no){
        mobile.sendKeys(no);
    }

    public void Multipledata(String Isbn, String Title, String Author, String quantity, String Mail, String Mobile)
    {
        isbn.sendKeys(Isbn);
        booktitle.sendKeys(Title);
        author.sendKeys(Author);
        Quantity.clear();
        Quantity.sendKeys(quantity);
        mail.sendKeys(Mail);
        mobile.sendKeys(Mobile);

    }





}
