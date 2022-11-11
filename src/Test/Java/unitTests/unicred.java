package unitTests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class unicred {
    private static ChromeDriver driver;



    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "https://unicreds.com/contact-us";
        driver.get(baseUrl);
    }

    @Test
    public void MainForm() throws InterruptedException {
        final CountDownLatch waiter = new CountDownLatch(1);
        waiter.await(30000, TimeUnit.MILLISECONDS); // wait for all elements to load
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (By by : Arrays.asList(By.id("onesignal-slidedown-cancel-button"), By.className("close"))) {
            driver.findElement(by).click(); // cancel pop-up
        }
        driver.manage().window().maximize(); // command to maximize the window
        System.out.println("Entering Full name");
        driver.findElement(By.id("fullname")).sendKeys("Lakshay Saini");
        System.out.println("Entering email");
        driver.findElement(By.name("email")).sendKeys("lakshayindian19@live.com");
        System.out.println("Entering Phone number");
        driver.findElement(By.id("phone")).sendKeys("8860160942");
        System.out.println("Entering message");
        driver.findElement(By.id("message")).sendKeys("Hello Team, \r\nThis is for testing purpose only. \r\nRegards \r\nLakshay");
        System.out.println("Pressing contact button");
        driver.findElement(By.id("contactButton")).click();
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS); //wait to let the screen stays for a while
        js.executeScript("window.scrollBy(0,120)"); // scrolling down to confirm message sent
        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());

    }
/*
    @Test
    public void PopUpForm() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Actions action = new Actions(driver); action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform(); //opening the URL saved.
        driver.get("https://unicreds.com/contact-us");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        final CountDownLatch waiter = new CountDownLatch(1);
        waiter.await(30000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Lakshay");
        driver.findElement(By.id("email")).sendKeys("lakshayindian18@gmail.com");
        driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-body > div > div > div > div > div.px-3.px-md-0.col > div > form > div:nth-child(3) > div:nth-child(1) > div.css-gd55s9-container > div > div.css-iqfl7y")).sendKeys("other");
       */

    @AfterClass
    public static void closeBrowser(){
        driver.quit(); // closing browser
    }
}