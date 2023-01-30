package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.LoginPage;
import ElementRepository.ManageLocation;
import ElementRepository.ManageOfferCode;
import Utilities.GeneralUtilities;
import constants.Constant;

public class ManageOfferCodeTestcase extends BaseClass {

	GeneralUtilities go = new GeneralUtilities();
	LoginPage lp = new LoginPage(driver);;
	ManageOfferCode moc;

	@Test

	public void ManageOfferCodeTitleValidation() throws InterruptedException {

		moc = new ManageOfferCode(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		moc.clickmanageOfferCodetab();

		String actual = moc.displayTabName();

		String expected = "List Offercodes";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.tabname);

	}

	@Test

	public void ManageOfferCode_search() {
		moc = new ManageOfferCode(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		moc.clickmanageOfferCodetab();

		String actual = moc.search("101");
		String expected = "Active";
		Assert.assertEquals(actual, expected, Constant.offer);

	}

	@Test

	public void ManageOfferCode_newoffer() {
		moc = new ManageOfferCode(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		moc.clickmanageOfferCodetab();

		moc.newOrder("65", "345", "45");

	}

}
