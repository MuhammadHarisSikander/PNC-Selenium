package testProject.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import testProject.loginPage;
import utils.ConfigUtils;

import java.util.Properties;

public class sprintOne {
    loginPage loginpg;
    FirefoxDriver driver;

    @Test (priority = 0)
    public void loginfunction() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\newProject\\geckodriver.exe");
        driver = new FirefoxDriver();
        Properties props = ConfigUtils.getProps("data");
        driver.get(props.getProperty("URL"));
        loginPage loginpg = new loginPage(driver);
        loginpg.login();
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1")).getText();
        if(text.contains("Dashboard"))
            System.out.println("Login Successfully");

    }
    @Test (priority = 1)
    public void logoutfunction() throws InterruptedException {
        loginPage loginpg = new loginPage(driver);
        loginpg.ActiveTab();
    }

    @Test (priority = 2)
    public void logout() throws InterruptedException {
        loginPage loginpg = new loginPage(driver);
            loginpg.logoutfunc();

    }


}
