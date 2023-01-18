package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Multibrowsering2 {
    static String browser="Chrome";
    static String baseURL="https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if(browser.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");//setting web
             driver=new ChromeDriver();//creating object of chrome webdriver

        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver","src/drivers/geckodriver.exe");//setting web
             driver=new FirefoxDriver();//creating object of chrome webdriver

        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","src/drivers/msedgedriver.exe");//setting web
             driver=new EdgeDriver();//creating object of chrome webdriver

        }else {
            System.out.println("not valid browser ");

        }
        driver.get(baseURL);//method to invoke url
        driver.manage().window().maximize();//maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//timeout session

        String title = driver.getTitle();//string title
        System.out.println("Title of the page : "+title);//printing title in console

        String url=driver.getCurrentUrl();//getting url
        System.out.println("current url :"+url);

        driver.findElement(By.id("user-name")).click();//clicking on login link
        WebElement usernameField = driver.findElement(By.id("user-name"));//storing email field
        usernameField.sendKeys("standard_user");//sending key to emailid field

        driver.findElement(By.id("password")).click();//clicking on login link
        WebElement passwordField=driver.findElement(By.id("password"));//storing password
        passwordField.sendKeys("secret_sauce");//sending key to password field

        String source = driver.getPageSource();
        System.out.println("page source :"+source);

        driver.close();
    }
}
