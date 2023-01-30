package ElementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class Dashboard {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home'] [@class='active nav-link']")
	WebElement Dashboardtab;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement tabname;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page'][@class='small-box-footer']")
	WebElement moreinfoManagePages;

	//// table[@class='table table-bordered table-hover table-sm']//thead//tr//th

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//thead//tr//th")
	List<WebElement> tableFieldValues;

	public String displayTabName() {
		return (gu.getElementText(tabname));

	}

	public void clickMoreinfoManagePages() {
		moreinfoManagePages.click();
	}

	public List<String> getTableValues() {

		return (gu.listOfWebElemenToListOfString(driver,
				"//table[@class='table table-bordered table-hover table-sm']//thead//tr//th"));

	}

	public List<String> expectedTablevalues() {

		List<String> list = new ArrayList();
		list = gu.addList("Title");
		list = gu.addList("Description");
		list = gu.addList("Image");
		list = gu.addList("Page");
		list = gu.addList("Action");

		return (list);
	}

	public boolean comaprison() {
		List<String> tableheaders = getTableValues();
		List<String> expectedtableheaders = expectedTablevalues();
		boolean value = gu.compareLists(tableheaders, expectedtableheaders);
		return (value);
	}

}