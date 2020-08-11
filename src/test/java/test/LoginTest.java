package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
   
	WebDriver driver;
	
	
	
	
	
  @Test 
  @Parameters({"username", "password"})
  public void ValidUserShoudBeLogin(String userName, String passWord)  {
	 
	  driver = BrowserFactory.init();
	  
	  LoginPage loginpage = PageFactory.initElements(driver,  LoginPage.class );
	  loginpage.enterUserName(userName);
	  loginpage.enterPassword(passWord);
	  loginpage.clickSignInButton();
	  
	  DashBoardPage dashBoard = PageFactory.initElements(driver, DashBoardPage.class );
	  dashBoard.varifyDashBoardElement();
	   
	  
	 
	  BrowserFactory.tearDown();
  
  }



}
