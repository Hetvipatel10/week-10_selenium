package utimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeTest3 {
    public static void main(String[] args) {
        String baseurl = "https://courses.ultimateqa.com/users/sign_in";//string base url
        System.setProperty("webdriver.edge.driver","src/drivers/msedgedriver.exe");//setting web
        WebDriver driver=new EdgeDriver();//creating object of chrome webdriver
        driver.get(baseurl);//method to invoke url
        driver.manage().window().maximize();//maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//timeout session

        String title = driver.getTitle();//string title
        System.out.println("Title of the page : "+title);//printing title in console

        String url=driver.getCurrentUrl();//getting url
        System.out.println("current url :"+url);

        driver.findElement(By.id("user[email]")).click();//clicking on login link
        WebElement usernameField = driver.findElement(By.id("user[email]"));//storing email field
        usernameField.sendKeys("patelhetvi20@gmail.com");//sending key to emailid field

        driver.findElement(By.id("user[password]")).click();//clicking on login link
        WebElement passwordField=driver.findElement(By.id("user[password]"));//storing password
        passwordField.sendKeys("Hetvi10*");//sending key to password field

        String source = driver.getPageSource();
        System.out.println("page source :"+source);

        driver.close();
    }
}
