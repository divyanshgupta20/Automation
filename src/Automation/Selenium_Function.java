package Automation;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Function {


	public XSSFSheet spreadSheet() throws Exception
	{
		//data sheet path
		File src = new File("F:\\Software\\new testcase.xlsx");

		//initialisation of sheet
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sh = workbook.getSheetAt(1);
		
		return sh;
	}
		
	public void imasLogin(XSSFSheet sh,WebDriver driver) throws InterruptedException
	{
		
		for (int i = 5; i < 6; i++) {
			String data1 = sh.getRow(i).getCell(0).getStringCellValue();
			String data2 = sh.getRow(i).getCell(1).getStringCellValue();

			// System.out.print("hello sheet data:"+data1+" "+data2);
			Thread.sleep(5000);
			driver.findElement(By.name("userId")).clear();
			Thread.sleep(5000);
			driver.findElement(By.name("password")).clear();

			Thread.sleep(1000);      //wfh
			driver.findElement(By.name("userId")).sendKeys(data1);
			Thread.sleep(1000);       //wfh
			driver.findElement(By.name("password")).sendKeys(data2);
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("imoblogin")).click();

		
		}
	
	
		
	}
	
	
	public WebDriver chromeDriverInitialisation() {
		System.setProperty("webdriver.chrome.driver", "F:\\cvs\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		return driver;
	}

	
	public void webLink(WebDriver driver,String str)
	{
		//maximize window
		driver.manage().window().maximize();
		//link for web browser
		driver.get(str);
		//driver.get();
	}
	
	public void selectApplication(WebDriver driver,String label) throws InterruptedException {
		
		driver.findElement(By.id("applications")).click();
		Thread.sleep(500);
		
		//click on configration
		driver.findElement(By.xpath("/html/body/div[12]/div/div[1]/div")).click();
		Thread.sleep(500);
		
		
		//click on list of application list
		driver.findElement(By.xpath("/html/body/div[14]/div/div["+label+"]/div")).click();
		Thread.sleep(5000);
		
	}
	

//-------------------------------->	
	//**function required to create campaign

	public void openCreateCampaignScreen(WebDriver driver) throws InterruptedException {
		
		//entering the campaign frame/page
		driver.switchTo().frame(driver.findElement(By.id("__w_S10001_Frame")));
		
		Thread.sleep(10000);   //wfh
		
		//click on new button '+'
		driver.findElement(By.className("menubuttonthree")).click();
		Thread.sleep(10000);
		
		Thread.sleep(3000);  //wfh
		//expand rule section
		driver.findElement(By.xpath("//*[@data-target='#rule']")).click();
		
		//expand message section
		driver.findElement(By.xpath("//*[@data-target='#message']")).click();
		Thread.sleep(3000);
		
		
		
	}
		
	public void createMessage(WebDriver driver,String messageName,String messageText) throws InterruptedException
	{
		
		//message section
		
		//message name
		driver.findElement(By.xpath("//*[@data-bind='value:MessageNameValue']")).sendKeys(messageName);
		//message text
		driver.findElement(By.tagName("textarea")).sendKeys(messageText);
		
		driver.findElement(By.xpath("//*[@id=\"message\"]/div/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[4]/div/label")).click();
		driver.findElement(By.xpath("//*[@id=\"message\"]/div/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div[1]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"message\"]/div/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div[1]/div/ul/li[9]")).click();
		
		Thread.sleep(4000);
		//save buttons
		driver.findElement(By.xpath("//*[@data-bind='click:SaveModifyNewMessage,visible:IsEdit']")).click();
		driver.findElement(By.xpath("//*[@data-bind='click:SaveModifyAllMessages,visible:IsEdit']")).click();
	

		//message save complete
		
	}
	
	public void campaignDetail(WebDriver driver,String campaignName,String label) throws InterruptedException {
		
		//logic for campaign name and goal input
		List<WebElement> objtxtbox = driver.findElements(By.tagName("input"));
		int count = 0;
		for (int i = 0; i < objtxtbox.size(); i++) {
			WebElement attributeName = objtxtbox.get(i);
			Point str3 = attributeName.getLocation();
			String str2 = attributeName.getTagName();
			String str1 = attributeName.getAttribute("data-bind");
			// String str4=attributeName.getAttribute("type");

			if (str1 != null && str1.startsWith("value:")) {
				try {
					if (count < 2) {
						attributeName.sendKeys(campaignName);

						System.out.println("attrnute for tagname: " + str2 + "  value of attribute as: " + str1
								+ "index: " + i + " Location: " + str3);
						count++;
					} else {
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception

					e.printStackTrace();
					break;
				}
			}
		}
		Thread.sleep(1000);

		
		//expand the home dropdown
		driver.findElement(By.xpath("//*[@class='multiselect dropdown-toggle col-lg-12 btn btn-default']")).click();
		Thread.sleep(1000);
	    //select home
		driver.findElement(By.xpath("//*[@id=\"addnewcampaign\"]/div/div[1]/div[1]/div/div/ul/li[3]/a")).click();
		Thread.sleep(2000);
		
		
		//Select select = new Select(driver.findElement(By.xpath("//*[@class='singleselect dropdown w-100']")));
        
		
		//driver.findElement(By.xpath("//*[@id=\"addnewcampaign\"]/div/div[1]/div[1]/div/div/ul/li[3]/a")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"addnewcampaign\"]/div/div[2]/div[2]/div[1]/div/span/span")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"addnewcampaign\"]/div/div[1]/div[6]/div/div")).click();  //alliance dropdown button
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"addnewcampaign\"]/div/div[1]/div[6]/div/div/ul/li["+label+"]")).click();
		Thread.sleep(500);
		
		Thread.sleep(3000);

		
		
	}
	
	public void campaignRule(WebDriver driver) throws InterruptedException {
		
		//rule trigger select
		driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/div/div/button")).click();
		
		Thread.sleep(500);
		//GSM attach selected
		driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/div/div/ul/li[12]")).click();
		
		
		Thread.sleep(500);
		//select action
		driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/div/div/ul/li[1]/div/input")).sendKeys("send message");
		driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/div/div/ul/li[2]")).click();
		
		//action selected done
		Thread.sleep(2000);
	
    	Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[1]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[2]/td/table/tbody/tr/td/button")).click();			
		
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@data-bind='click:PublishCampaignAllData']")).click();
	}
	
	
	
	
}
