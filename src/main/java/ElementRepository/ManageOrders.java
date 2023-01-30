package ElementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Utilities.GeneralUtilities;

public class ManageOrders {
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManageOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement managaeorderstab;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	public WebElement searchbtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	public WebElement resetbtn;

	@FindBy(id = "pt")
	public WebElement paymentMode;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix'][@name='Search']")
	public WebElement searchbtn2;

	@FindBy(id = "st")
	public WebElement statusdropdown;

	public void clickManageOrderTab() {
		managaeorderstab.click();

	}

	public String font_search() {
		clickManageOrderTab();
		String fontsize1 = gu.stylePropertyValidation(searchbtn, "font-size");
		return fontsize1;

	}

	public String fontReset() {
		clickManageOrderTab();
		String fontsize2 = gu.stylePropertyValidation(resetbtn, "font-size");
		return fontsize2;

	}

	public String backGroundSearch() {
		clickManageOrderTab();
		String bgcolor = gu.stylePropertyValidation(searchbtn, "background-color");
		return bgcolor;

	}

	public boolean searchByBank() {
		clickManageOrderTab();
		gu.clickElement(searchbtn);
		gu.selectFuncbyindex(paymentMode, 2);
		gu.clickElement(searchbtn2);
		List<WebElement> filterValues = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[5]"));

		return (gu.getElementTextList(filterValues, "Bank"));
	}

	public String statusdropdwnTest(String value) throws InterruptedException {

		String actual = gu.selectFuncbyVisibletext(statusdropdown, value);
		return actual;
		

	}
	
	public List<String> listOfExpectedValuesDropdown(){
		List<String> list1 = new ArrayList();
		gu.addList("Select");
		gu.addList("Paid");
		gu.addList("unpaid");
		gu.addList("Delivered");
		gu.addList("Out For Delivery");
		System.out.println(list1);
		return list1;
	}

	public void clickSearchbtn() {
		gu.clickElement(searchbtn);
	}
}