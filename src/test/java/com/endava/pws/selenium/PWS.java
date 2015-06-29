package com.endava.pws.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static junit.framework.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Unit test for simple App.
 */
public class PWS {
    
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    
    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        baseUrl = "http://lwwiti19:8003/PWS/admin.do";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @Test
    public void checkPWS() throws Exception {
        
        driver.get(baseUrl);
        
        assertTrue(driver.getTitle().contains("Login PWS"));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("login")).click();
        
        assertTrue(driver.getTitle().contains("PWS Console"));
        driver.findElement(By.xpath("(//input[@name='echoice'])[2]")).click();
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).click();
        driver.findElement(By.name("Submit")).click();
        
        System.out.println(driver.getTitle());
    }
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
    }
  }
}
