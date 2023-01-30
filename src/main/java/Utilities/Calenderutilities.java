package Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Calenderutilities {

	
	public void calefunc(WebElement x,WebElement month,WebElement nextbtn,WebElement date,List <WebElement>dates) throws InterruptedException
	{
	x.click();
	
	
	Thread.sleep(3000);
System.out.println(month.getText());
	while(month.getText().contains("April"))
	{
	nextbtn.click();
	}



	//Grab common attribute//Put into list and iterate
	int count=31;

	for(int i=0;i<count;i++)
	{
	String text=((WebElement) dates.get(i)).getText();
	if(text.equalsIgnoreCase("27"))
	{
	dates.get(i).click();
	break;
	}


}}}
	


