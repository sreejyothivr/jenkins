package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.LoginPage;

import ElementRepository.ManagePaymentMethods;
import Utilities.GeneralUtilities;
import constants.Constant;

public class ManagePaymentTest extends BaseClass {

	ManagePaymentMethods mp;
	LoginPage lp;
	GeneralUtilities go = new GeneralUtilities();

	@Test
	public void checkboxValidation() {
		lp = new LoginPage(driver);
		mp = new ManagePaymentMethods(driver);
		lp.presteps();
		mp.clickManagePaymentMethodstab();
		String colorActual = mp.colorValidation();
		System.out.println(colorActual);
		String expected = Constant.paymenttestcolor;
		Assert.assertEquals(colorActual, expected);

	}

	@Test
	public void Validation() {
		lp = new LoginPage(driver);
		mp = new ManagePaymentMethods(driver);
		lp.presteps();
		mp.clickManagePaymentMethodstab();

		boolean value = mp.listComparison();
		System.out.println(value);
	}

}