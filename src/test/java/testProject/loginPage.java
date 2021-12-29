package testProject;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigUtils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class loginPage {

        By username = new By.ById("txtUsername");
        By password = new By.ById("txtPassword");
        By loginbtn = new By.ById("btnLogin");
        By dropdown = new By.ByXPath("//*[@id=\"welcome\"]");
        By logoutbtn = new By.ByLinkText("Logout");

        Properties props = ConfigUtils.getProps("data");

        FirefoxDriver driver;

        public loginPage(FirefoxDriver driver){
            this.driver = driver;
        }

        public void login() throws InterruptedException{
        driver.findElement(username).sendKeys(props.getProperty("USERNAME"));
        driver.findElement(password).sendKeys(props.getProperty("password"));
        driver.findElement(loginbtn).click();

    };

    public void ActiveTab() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a/b")).click();
    }


    public void logoutfunc() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(dropdown).click();
        driver.findElement(logoutbtn).click();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
