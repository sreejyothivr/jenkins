package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.LoginPage;
import ElementRepository.ManageExpense;
import ElementRepository.ManageLocation;
import Utilities.GeneralUtilities;
import constants.Constant;

public class ManageLocationTest extends BaseClass {

	GeneralUtilities go = new GeneralUtilities();
	LoginPage lp;
	ManageLocation ml;

	@Test

	public void manageLocationTabValidation() throws InterruptedException {
		ml = new ManageLocation(driver);
		lp = new LoginPage(driver);
		lp.presteps();

		ml.clicktab();

		String actual = ml.displayTabName();

		String expected = Constant.location;
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.tabname);
	}

	@Test
	public void displayColorNewbutton() {
		ml = new ManageLocation(driver);
		lp = new LoginPage(driver);
		lp.presteps();

		ml.clicktab();

		String expected = Constant.bgclr1;
		String actual = ml.displaycolor();
		Assert.assertEquals(actual, expected, Constant.bgColorErrorMessage);
	}

	@Test
	public void searchMethod() throws InterruptedException {
		ml = new ManageLocation(driver);
		lp = new LoginPage(driver);
		lp.presteps();

		ml.clicktab();

		String actual = ml.searchMethod();
		System.out.println(actual);
		String expected = Constant.status;
		Assert.assertEquals(actual, expected, Constant.locationAssert);

	}
}
