package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viliina\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

//        WebElement element = driver.findElement(By.linkText("login"));
//        element.click();
//
//        sleep(2);
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//
//        sleep(2);
//        element.submit();
//
//        sleep(3);
//
//        driver.quit();
//then right username wrong password        

//
//        sleep(2);
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("pekka");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("aep");
//        element = driver.findElement(By.name("login"));
//
//        sleep(2);
//        element.submit();
//
//        sleep(3);
//
//        driver.quit();
        //then a username that doesnt exist
        
//
//        sleep(2);
//
//        element = driver.findElement(By.name("username"));
//        element.sendKeys("puio");
//        element = driver.findElement(By.name("password"));
//        element.sendKeys("akkep");
//        element = driver.findElement(By.name("login"));
//
//        sleep(2);
//        element.submit();
//
//        sleep(3);
//
//        driver.quit();
//        //new user
//

        WebElement element2 = driver.findElement(By.linkText("register new user"));
        element2.click();

        sleep(2);

        element2 = driver.findElement(By.name("username"));
        element2.sendKeys("PantherP");
        element2 = driver.findElement(By.name("password"));
        element2.sendKeys("rehtnap");
        element2 = driver.findElement(By.name("passwordConfirmation"));
        element2.sendKeys("rehtnap");
        element2 = driver.findElement(By.name("signup"));

        sleep(2);
        element2.submit();

        sleep(3);

        //driver.quit();
        //logout after new user
        
        element2 = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(2);
        element2.click();
        element2 = driver.findElement(By.linkText("logout"));
        sleep(2);
        element2.click();
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
