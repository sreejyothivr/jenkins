package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import ElementRepository.LoginPage;
import ElementRepository.ManageCodTab;
import ElementRepository.ManageDeliveryBoy;
import Utilities.GeneralUtilities;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class ManagedeliveryboyTest extends BaseClass {

	ManageDeliveryBoy md;
	LoginPage lp;
	GeneralUtilities go = new GeneralUtilities();

	@Test
	public void restbtnValidation() {
		lp = new LoginPage(driver);
		md = new ManageDeliveryBoy(driver);
		lp.presteps();
		md.managadeliveryboytabselection();
		String bgclr = md.managadeliveryboytab();

		String expected = "rgba(255, 193, 7, 1)";
		String actual = bgclr;
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void tooltipValidation() {
		lp = new LoginPage(driver);
		md = new ManageDeliveryBoy(driver);
		lp.presteps();
		md.managadeliveryboytabselection();

		String actual = md.tooltipVal();
		String expected = "Show Details";
		Assert.assertEquals(actual, expected);

	}

	@Test()
	public void elementpresentVal() throws InterruptedException {
		lp = new LoginPage(driver);
		md = new ManageDeliveryBoy(driver);
		lp.presteps();
		md.managadeliveryboytabselection();

		boolean actual = md.clicktooltip();
		boolean expected = true;
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void searchVal() throws InterruptedException {
		lp = new LoginPage(driver);
		md = new ManageDeliveryBoy(driver);
		lp.presteps();
		md.managadeliveryboytabselection();

		String actual = md.searchemail();
		System.out.println(actual);
		String expected = "Active";
		Assert.assertEquals(actual, expected);

	}

}
