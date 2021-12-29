package testProject;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigUtils;

import java.util.Properties;

public class test {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\newProject\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        Properties props = ConfigUtils.getProps("data");
        driver.get(props.getProperty("URL"));
        loginPage loginpg = new loginPage(driver);
        loginpg.login();
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1")).getText();
        if(text.contains("Dashboard"))
            System.out.println("Login Successfully");

        loginpg.ActiveTab();

        loginpg.logoutfunc();
            String url = driver.getCurrentUrl();
            if(url.contains("/login"));
                System.out.println("Logout is Successfully");
                driver.quit();

    }
}
