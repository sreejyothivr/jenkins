package ElementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManageExpense {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='nav-link'])[3]")
	private WebElement managaexpensetab;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	WebElement manageexpensesub;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	public WebElement resetbtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[3]/td[9]/a[1]/i")
	public WebElement editbutton;

	@FindBy(xpath = "//input[@class='form-control date']")
	public WebElement datetextarea;

	public void clickManagaexpensetab() {
		gu.clickElement(managaexpensetab);

	}

	public void clickManagExpensesub() {

		gu.clickElement(manageexpensesub);

	}

	public String font_search() {
		clickManagaexpensetab();
		String fontsize1 = gu.stylePropertyValidation(newbtn, "font-size");
		return fontsize1;

	}

	public String fontReset() {
		clickManagaexpensetab();
		String fontsize2 = gu.stylePropertyValidation(resetbtn, "font-size");
		return fontsize2;

	}

	public String backGroundSearch() {
		clickManagaexpensetab();
		String bgcolor = gu.stylePropertyValidation(newbtn, "background-color");
		return bgcolor;

	}

	public void clickeditbtn() {
		gu.clickElement(editbutton);
	}

	public void datepicker() throws InterruptedException {
		clickeditbtn();
		gu.clickElement(datetextarea);

		System.out.println(driver.findElement(By.xpath("//th[normalize-space()='October 2022']")).getText());

		gu.mediumDelay();
		while (!driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='datepicker-switch']"))
				.getText().contains("August 2021")) {

			//driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']"))
					//.click();
			driver.findElement(By.xpath("//table[@class='table-condensed']/thead/tr[2]//th"))
			.click();


		}

		// gu.mediumDelay();
		// Grab common attribute//Put into list and iterate
		int count = driver.findElements(By.xpath("//td[@class='day']")).size();
System.out.println(count);
		for (int i = 0; i<count; i++) {
			///List<WebElement>list=driver.findElements(By.className("//td[@class='day']"));
		
			String text = driver.findElements(By.className("//td[@class='day']")).get(i).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase("27")) {
				driver.findElements(By.className("//td[@class='day']")).get(i).click();
				break;
			}

		}
	}
	
	

	public void imageupload(String images) throws AWTException, InterruptedException {
		clickeditbtn();
		Robot rob = new Robot();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		gu.mediumDelay();
		WebElement click = driver.findElement(By.xpath("//*[@type='file']"));
		Actions a = new Actions(driver);
		a.moveToElement(click).click().perform();
		gu.mediumDelay();

		StringSelection ss = new StringSelection(images);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rob.delay(250);

		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.delay(250);
		rob.keyRelease(KeyEvent.VK_ENTER);

	}

}
