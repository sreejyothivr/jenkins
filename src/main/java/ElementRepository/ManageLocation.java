package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.GeneralUtilities;

public class ManageLocation {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'][@class='small-box-footer']")
	WebElement managaeLoctab;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement tabname;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/add']")
	WebElement newbtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbtn;

	@FindBy(xpath = "//select[@id='country_id']")
	WebElement countrydropdown;

	@FindBy(id = "st_id")
	WebElement statedropdown;

	// input[@id='location'
	@FindBy(id = "location")
	WebElement locationdropdown;

	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchbtnn;

	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr/td[5]/a/span")
	WebElement activeStatus;

	public String displayTabName() {
		return (gu.getElementText(tabname));

	}

	public void clicktab() {
		gu.clickElement(managaeLoctab);
	}

	public String displaycolor() {
		String color = (gu.stylePropertyValidation(newbtn, "background-color"));
		System.out.println(color);
		return (color);
	}

	public String searchMethod() throws InterruptedException {
		gu.clickElement(searchbtn);
		gu.selectFuncbyindex(countrydropdown, 1);

		gu.clickElement(locationdropdown);
		gu.sendKeysFunc(locationdropdown, "Golden villa");
		/*
		 * gu.clickElement(statedropdown);
		 * gu.selectFuncbyValue(statedropdown,"Berkshire");
		 */
		gu.clickElement(searchbtnn);
		return (gu.getElementText(activeStatus));

	}

}
