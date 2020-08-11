package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	

	//@Test (priority = 1)
	@Parameters({"username", "password", "fullname", "company", "email", "phonenum", "adress", "city", "state", "zip", "group"})
    public void ValidUserShouldBeAddCustomer(String userName, String passWord, String fullName, String companyName, String email, String phoneNum, String address, String city, String state, String zip, String group ) {
    	
    	driver = BrowserFactory.init();
    	
    	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
    	loginpage.enterUserName(userName );
    	loginpage.enterPassword(passWord);
    	loginpage.clickSignInButton();
    	
    	DashBoardPage dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
    	dashboardpage.varifyDashBoardElement();
    	
    	AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
    	addcustomerpage.clickCustomersButton();
    	addcustomerpage.clickAddcustomerButton();
    	
    	addcustomerpage.enterFullName(fullName);
    	addcustomerpage.selectCompanyFromDropDown(companyName);
    	addcustomerpage.enterEmail(email);
    	addcustomerpage.enterPhoneNumber(phoneNum);
    	addcustomerpage.enterAddress(address);
    	addcustomerpage.enterCity(city);
    	addcustomerpage.enterState(state);
    	addcustomerpage.enterZip(zip);
    	addcustomerpage.selectGroupFromDropDown(group);
    	addcustomerpage.clickSaveButton();
    	addcustomerpage.clickListCustomerButton();
    	addcustomerpage.verifyEnteredCustomerAndDelete();
    	
    	
    	BrowserFactory.tearDown();
	 	
    }
	
	 @Test (priority = 2)
	 @Parameters({"username", "password", "fullname", "company", "email", "phonenum", "adress", "city", "state", "zip", "group"})
	 public void ValidUserShouldBeAbleToUseSearchBarOnListCustomer(String userName, String passWord, String fullName, String companyName, String email, String phoneNum, String address, String city, String state, String zip, String group) {
	    	
	    	driver = BrowserFactory.init();
	    	
	    	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	    	loginpage.enterUserName(userName );
	    	loginpage.enterPassword(passWord);
	    	loginpage.clickSignInButton();
	    	
	    	DashBoardPage dashboardpage = PageFactory.initElements(driver, DashBoardPage.class);
	    	dashboardpage.varifyDashBoardElement();
	    	
	    	AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
	    	addcustomerpage.clickCustomersButton();
	    	addcustomerpage.clickListCustomerButton();
	    	addcustomerpage.clickAddCustomerOnListCustomer();
	    	
	        addcustomerpage.enterFullName(fullName);
	    	addcustomerpage.selectCompanyFromDropDown(companyName);
	    	addcustomerpage.enterEmail(email);
	    	addcustomerpage.enterPhoneNumber(phoneNum);
	    	addcustomerpage.enterAddress(address);
	    	addcustomerpage.enterCity(city);
	    	addcustomerpage.enterState(state);
	    	addcustomerpage.enterZip(zip);
	    	addcustomerpage.selectGroupFromDropDown(group);
	    	addcustomerpage.clickSaveButton();
	    	
	    	addcustomerpage.clickListCustomerButton();
	    	
	    	addcustomerpage.testListContactSearchBar();
	    	addcustomerpage.verifyEnteredCustomerOnSearchBarAndTestView();
	    
			
	    	
	    	
	    	
	    	
	    	BrowserFactory.tearDown();
		 	
	    }



}
