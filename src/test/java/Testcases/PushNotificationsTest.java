package Testcases;
import java.util.List;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.Dashboard;
import ElementRepository.LoginPage;
import ElementRepository.ManageProductTab;
import ElementRepository.PushNotifications;
import Utilities.ExplitWait;
import Utilities.GeneralUtilities;
import constants.Constant;



public class PushNotificationsTest extends BaseClass {

	GeneralUtilities go = new GeneralUtilities();
	LoginPage lp;
	PushNotifications pn;
/*
	@Test

	public void pushnotificationsTabValidation() throws InterruptedException {
		pn = new PushNotifications(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		pn.clickpushnotifications();
		String actual = pn.displayTabName();

		String expected = Constant.pushexp;
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constant.tabname);
	}*/
	@Test(retryAnalyzer = Testcases.RetryAnalyzer.class)
		public void displayColorSearchbutton() {
		pn = new PushNotifications(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		pn.clickpushnotifications();
		String expected = "hello";
				//Constant.bgclr3;
		String actual = pn.displaycolor();
		Assert.assertEquals(actual, expected, Constant.bgColorErrorMessage);
	}
	
		/*@Test
	public void xyz() {
	int x=0;
	x=x+10;
	System.out.println(x);
}
*/
	/*@Test(groups = { "Showstopper" })
	public void AlertTextValidation() throws InterruptedException {
		pn = new PushNotifications(driver);
		lp = new LoginPage(driver);
		lp.presteps();
		pn.clickpushnotifications();

		String real = Constant.push_success;
		String actual = pn.getAlertText("jyothi", "jyothi");
		Assert.assertEquals(actual, real, Constant.alert_ntexp);

	}
*/
}
