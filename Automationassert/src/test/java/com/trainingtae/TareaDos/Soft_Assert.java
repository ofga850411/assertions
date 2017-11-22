package com.trainingtae.TareaDos;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert {
	
	
	  SoftAssert s_assert = new SoftAssert();
	  SoftAssert s_assert1 = new SoftAssert();
	  String Actualtext;
	  WebDriver driver = null;
	 
	  @BeforeClass
	  public void load_url(){
	   System.setProperty("webdriver.gecko.driver", "/Users/oscar.garcia/Downloads/geckodriver");
	   driver = new FirefoxDriver();
	   driver.manage().window().maximize();
	   driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	  } 
	  
	  @Test
	  //Si alguno de las assertions falla se detiene
	   public void hard_assert_text() {
	   Actualtext = driver.findElement(By.xpath("//h2/span")).getText();
	
	   Assert.assertEquals(Actualtext, "Tuesday, 01 January 2014", "1st assert failed.");
	   System.out.println("Hard Assertion -> 1st pagetext assertion executed.");
	   
	   Assert.assertEquals(Actualtext, "Tuesday, 28 January 2014", "2nd assert failed.");
	   System.out.println("Hard Assertion -> 2nd pagetext assertion executed.");   
	   
	   driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
	   String Alert_text = driver.switchTo().alert().getText();
	   driver.switchTo().alert().accept();
	   
	   Assert.assertEquals(Alert_text, "Hi.. is alert message!", "Alert Is InCorrect");
	   System.out.println("Hard Assertion -> 1st alert assertion executed.");
	   
	   Assert.assertEquals(Alert_text, "Hi.. This is alert message!", "Alert Is Correct");
	   System.out.println("Hard Assertion -> 2nd alert assertion executed.");   
	  } 
	  
	  @Test
	   //Toda la prueba se corre independiente de los fallos
	   public void soft_assert_text() {
	   Actualtext = driver.findElement(By.xpath("//h2/span")).getText();
	   
	   s_assert.assertEquals(Actualtext, "Tuesday, 01 January 2014", "1st assert failed.");
	   System.out.println("Soft Assertion -> 1st pagetext assertion executed.");
	   
	   s_assert.assertEquals(Actualtext, "Tuesday, 28 January 2014", "2nd assert failed.");
	   System.out.println("Soft Assertion -> 2nd pagetext assertion executed.");   
	   
	   driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
	   String Alert_text = driver.switchTo().alert().getText();
	   driver.switchTo().alert().accept();
	   
	   s_assert.assertEquals(Alert_text, "Hi.. is alert message!", "Alert Is InCorrect");
	   System.out.println("Soft Assertion -> 1st alert assertion executed.");
	   
	   s_assert.assertEquals(Alert_text, "Hi.. This is alert message!", "Alert Is Correct");
	   System.out.println("Soft Assertion -> 2nd alert assertion executed.");
	   s_assert.assertAll();
	  }   
	  
	  @Test
	   //Toda la prueba se corre independiente de los fallos
	   public void soft_assert_text1() {
	   Actualtext = driver.findElement(By.xpath("//h2/span")).getText();
	   
	   s_assert1.assertEquals(Actualtext, "Tuesday, 28 January 2014", "2nd assert failed.");
	   System.out.println("Soft Assertion -> 2nd pagetext assertion executed.");   
	   
	   driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
	   String Alert_text = driver.switchTo().alert().getText();
	   driver.switchTo().alert().accept();
	   
	   s_assert1.assertEquals(Alert_text, "Hi.. This is alert message!", "Alert Is Correct");
	   System.out.println("Soft Assertion -> 2nd alert assertion executed.");
	   s_assert1.assertAll();
	  }   
	  
	  @Test
	  public void wait_and_click(){
	   WebDriverWait wait = new WebDriverWait(driver, 15);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='submitButton']")));
	   driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	  }  
	  
	  @AfterClass  
	  public void Closebrowser(){ 
	   driver.quit();   
	  }

}
