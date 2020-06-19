package Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import Automation.Selenium_Function;
 
public class Demo_TC_01 {

	public static void main(String[] args) throws Exception{
	 
					//Demo_TC_01 obj=new Demo_TC_01();               //create object of class
		            Selenium_Function obj=new Selenium_Function();
					WebDriver driver=obj.chromeDriverInitialisation();			//web driver function call
					try {

						Thread.sleep(2000);
	                    obj.webLink(driver,"http://172.16.131.53:9989/imas");  //define the link for site and call the method for redirecting on chrome
	                    Thread.sleep(2000);
	                    
						XSSFSheet sh=obj.spreadSheet();                  //data sheet initalsed
						obj.imasLogin(sh, driver);                       //passing webdriver and sheet data to the login function call
						
						Thread.sleep(20000);   //wfh
						driver.findElement(By.className("mask")).click();
						
						Thread.sleep(2000);
						System.out.println("done logining in........");
						
						
						obj.selectApplication(driver, "6");        //select application
							
					 } catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
												
				//---->checked-->till here--->
	
				try {
					//open create campaign page
					obj.openCreateCampaignScreen(driver);
					
					//fill the detail section of campaign
					obj.campaignDetail(driver, "machine","2");        
			
					//message section
					obj.createMessage(driver, "hi msg fuction", "I am automation executing fuction");
					Thread.sleep(500);
					
					//fill rule section
					obj.campaignRule(driver);
					
					System.out.println("end of execution");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
	
				//-->execution completed
				//done execution
				System.out.println("done execution");
	}
	
	
	

	
	
	
	
	
	
	
}
