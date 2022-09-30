package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass {
    protected WebDriver driver;
    protected Actions actions;
    protected Faker faker;

    // @BeforeClass ve @AfterClass notasyonlarını TestNG'de kullanırken
    // JUnit'deki gibi static yapmaya gerek yoktur

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        actions=new Actions(driver);
        faker=new Faker();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown(){

        driver.close();
    }
}
