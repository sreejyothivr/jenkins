package ElementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;

public class ManagePaymentMethods {
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManagePaymentMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']/li[17]/a/p")
	WebElement ManagePaymentMethodstab;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbtn;

	String loctype = "//table/tbody/tr/td[1]";

	public void clickManagePaymentMethodstab() {
		gu.clickElement(ManagePaymentMethodstab);
	}

	public String colorValidation() {
		String color = gu.stylePropertyValidation(resetbtn, "color");
		return (color);
	}

	public List<String> addpaymentMethods() {
		List<String> setpayment;
		setpayment = gu.addList("debit card");
		setpayment = gu.addList("UPI");
		System.out.println(setpayment);
		return (setpayment);
	}

	public List<String> getpaymentMethods() {
		List<String> getpayment;
		getpayment = gu.listOfWebElemenToListOfString(driver, loctype);

		return getpayment;
	}

	public boolean listComparison() {
		boolean value = true;
		List<String> getpayment = getpaymentMethods();
		List<String> setpayment = addpaymentMethods();
		for (int i = 0; i < getpayment.size(); i++) {
			if (!getpayment.get(i).equals(setpayment.get(i))) {
				value = false;
			}
		}

		return value;
	}

}
