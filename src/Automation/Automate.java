package Automation;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Automate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// day1
		System.setProperty("webdriver.chrome.driver", "F:\\cvs\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("http://172.16.131.53:9997/imas");
			// driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			/*
			 * driver.get("http://www.facebook.com");
			 * 
			 * 
			 * //driver.close();
			 * 
			 * driver.findElement(By.name("email")).sendKeys("divyansh");
			 * driver.findElement(By.name("pass")).sendKeys("hello");
			 * driver.findElement(By.("u_0_4")).click();
			 */

			// driver.get("http://www.facebook.com");
			/*
			 * driver.findElement(By.name("userId")).sendKeys("icampuser");
			 * driver.findElement(By.name("password")).sendKeys("icampuser");
			 * //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 * driver.findElement(By.id("imoblogin")).click();
			 */

			File src = new File("F:\\Software\\new testcase.xlsx");

			FileInputStream fis = new FileInputStream(src);

			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sh = workbook.getSheetAt(1);

			for (int i = 4; i < 5; i++) {
				String data1 = sh.getRow(i).getCell(0).getStringCellValue();
				String data2 = sh.getRow(i).getCell(1).getStringCellValue();

				// System.out.print("hello sheet data:"+data1+" "+data2);
				driver.findElement(By.name("userId")).clear();

				driver.findElement(By.name("password")).clear();

				Thread.sleep(1000);
				driver.findElement(By.name("userId")).sendKeys(data1);
				Thread.sleep(1000);
				driver.findElement(By.name("password")).sendKeys(data2);
				// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("imoblogin")).click();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Thread.sleep(2000);
		// driver.get("http://172.16.131.53:9997/imas");
		System.out.print("hello");
		driver.findElement(By.className("mask")).click();
		// driver.findElement(By.xpath("//*[@id='mask']")).click();

		// driver.findElement(By.xpath("/html/body/div[14]/div/div[7]/div")).click();
		// driver.findElement(By.xpath("//*[@id=\"applications\"]/span")).click();

		/*
		 * driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 * driver.findElement(By.className("mainMenu")).click();
		 */
		// day 2
		try {
			Thread.sleep(500);
			driver.findElement(By.id("applications")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/div[12]/div/div[1]/div")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/div[14]/div/div[7]/div")).click();

			Thread.sleep(30000);
			// driver.findElement(By.linkText("New")).click();
			driver.switchTo().frame(driver.findElement(By.id("__w_S10001_Frame")));
			driver.findElement(By.className("menubuttonthree")).click();
			Thread.sleep(10000);
			/*
			 * Select select = new Select(driver.findElement(By.className("singleselect")));
			 * select.selectByIndex(1);
			 */
			// driver.findElement(By.cssSelector("css=input[data-bind=value:CampaignName]")).sendKeys("abhishek");
			// System.out.print(driver.findElements(By.).toString());
			// driver.findElements(By.tagName("input").);
			/*
			 * List <WebElement> objtxtbox = driver.findElements(By.tagName("input"));
			 * 
			 * for(WebElement inputTxt : objtxtbox) { inputTxt.sendKeys("hello"); }
			 */
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {

			driver.findElement(By.xpath("//*[@data-target='#rule']")).click();

			driver.findElement(By.xpath("//*[@data-target='#message']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='multiselect dropdown-toggle col-lg-12 btn btn-default']")).click();
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
							attributeName.sendKeys("Divyansh112");

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
			/*
			 * List<WebElement> drp1=driver.findElements(By.xpath("//*[@value=470]"));
			 * for(int i=0;i<drp1.size();i++) {
			 * 
			 * //System.out.println(drp1.get(i).getAttribute("value"));
			 * 
			 * if(drp.get(i).getAttribute("innerHTML")=="GPRS") { drp.get(i).click(); }
			 * 
			 * 
			 * //drp1.get(i). drp1.get(i).getAttribute("value")=="470"
			 * if(drp1.get(i).getTagName()=="input") {
			 * System.out.println(drp1.get(i).getAttribute("value")); drp1.get(i).click();
			 * System.out.println("Done"); }
			 * 
			 * 
			 * }
			 */

					Select select = new Select(driver.findElement(By.xpath("//*[@class='singleselect dropdown w-100']")));
                    ///select.selectByIndex(2);
					//System.out.println("Default value selected is :"+ s);
				
					driver.findElement(By.xpath("//*[@id=\"addnewcampaign\"]/div/div[1]/div[1]/div/div/ul/li[3]/a")).click();
					driver.findElement(By.xpath("//*[@id=\"addnewcampaign\"]/div/div[2]/div[2]/div[1]/div/span/span")).click();
					
					
			
			
			
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@data-bind='value:MessageNameValue']")).sendKeys("hi msg");
			driver.findElement(By.tagName("textarea")).sendKeys("I am automation");
			driver.findElement(By.xpath("//*[@id=\"message\"]/div/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[4]/div/label")).click();
			driver.findElement(By.xpath("//*[@id=\"message\"]/div/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div[1]/div/button")).click();
			driver.findElement(By.xpath("//*[@id=\"message\"]/div/div/div/table[3]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div[1]/div/ul/li[9]")).click();
			
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@data-bind='click:SaveModifyNewMessage,visible:IsEdit']")).click();
			driver.findElement(By.xpath("//*[@data-bind='click:SaveModifyAllMessages,visible:IsEdit']")).click();
			// driver.findElement(By.xpath("//*[@value='470']")).click();
			List<WebElement> drp = driver.findElements(By.xpath("//*[@value=3]"));
			for (int i = 0; i < drp.size(); i++) {

				// System.out.println(drp.get(i).getAttribute("innerHTML"));
				if (drp.get(i).getAttribute("innerHTML") == "GPRS") {
					drp.get(i).click();
				}

			}

			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/div/div/button")).click();
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/div/div/ul/li[12]")).click();
			
			//driver.findElement(By.xpath("//*[@title='Opt-In for Service']")).click();
			
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/div/div/button")).click();
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/div/div/ul/li[4]")).click();
			
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div")).click();;
			driver.findElement(By.xpath("/html/body/div/form/div[1]/div[3]/div/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div/ul/li[6]")).click();;
			
			Thread.sleep(6000);
			
			
			
			
			/*
			 * List<WebElement> dropdownval=driver.findElements(By.xpath(
			 * "/html/body/div/form/div[1]/div[3]/div/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div/ul"
			 * )); for (int i = 0; i < dropdownval.size(); i++) {
			 * 
			 * // System.out.println(drp.get(i).getAttribute("innerHTML"));
			 * System.out.print(drp.get(i).getAttribute("innerHTML"));
			 * 
			 * 
			 * }
			 */
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/span/a[1]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@data-bind=\"value: SelectedEditFilterName, event: { keypress: CheckEnter }\"]")).sendKeys("selenium");
			driver.findElement(By.xpath("//*[@id=\"SubsciberAttribute\"]/div/div/div[2]/div[1]/div[4]/input")).sendKeys("yes");
			driver.findElement(By.xpath("//*[@id=\"SubsciberAttribute\"]/div/div/div[2]/div[1]/div[5]/a[1]/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"SubsciberAttribute\"]/div/div/div[3]/button[1]")).click();
			Thread.sleep(6000);
			
Thread.sleep(4000);
			
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div")).click();;
			driver.findElement(By.xpath("/html/body/div/form/div[1]/div[3]/div/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div/ul/li[3]")).click();
			driver.findElement(By.xpath("/html/body/div/form/div[1]/div[3]/div/div/div[2]/div/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div/ul/li[6]")).click();
			
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[1]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"rule\"]/div/div/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td/table[3]/tbody/tr[2]/td/table/tbody/tr/td/button")).click();			
			
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//*[@data-bind='click:PublishCampaignAllData']")).click();
			
			
			
			System.out.println("end of execution");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
