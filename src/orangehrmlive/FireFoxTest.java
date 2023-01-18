package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxTest {
    public static void main(String[] args) {
        String baseurl = "https://opensource-demo.orangehrmlive.com/";//string base url
        System.setProperty("webdriver.gecko.driver","src/drivers/geckodriver.exe");//setting web
        WebDriver driver=new FirefoxDriver();//creating object of chrome webdriver
        driver.get(baseurl);
        driver.manage().window().maximize();//maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//timeout session

        String title = driver.getTitle();//string title
        System.out.println("Title of the page : "+title);//printing title in console

        String url=driver.getCurrentUrl();//getting url
        System.out.println("current url :"+url);

        driver.findElement(By.className("orangehrm-login-slot")).click();//clicking on login link
        WebElement usernameField = driver.findElement(By.name("Username"));//storing email field
        usernameField.sendKeys("Hetvi");//sending key to emailid field
        WebElement passwordField=driver.findElement(By.name("Password"));//storing password
        passwordField.sendKeys("Hetvi10*");//sending key to password field

        String source = driver.getPageSource();
        System.out.println("page source :"+source);

        driver.close();
    }
}
