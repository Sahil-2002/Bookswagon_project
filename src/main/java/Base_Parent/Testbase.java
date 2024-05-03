package Base_Parent;

import Util.Testutil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class Testbase {

    public static WebDriver driver;
    public static Properties prop;

    public static Logger log = Logger.getLogger(Testbase.class);

    public ExtentReports extentReports = new ExtentReports();
    public ExtentSparkReporter sparkReporter = new ExtentSparkReporter("D:\\intellij_workspace\\PageObjectModel\\Outputfile\\ExtentReport.html");



    public Testbase() {

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("D:\\intellij_workspace\\PageObjectModel\\src\\main\\java\\Config\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization(){
        log.info("browser name "+prop.getProperty("browser"));

        String browser = prop.getProperty("browser");
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }
        log.info("Application url = "+prop.getProperty("url"));

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

        driver.manage().timeouts().pageLoadTimeout(Testutil.Pageloadtimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Testutil.implicitlywait, TimeUnit.SECONDS);


    }

}
