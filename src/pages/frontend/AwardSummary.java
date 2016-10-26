package pages.frontend;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CommonElements;

public class AwardSummary extends CommonElements {

	@FindBy(linkText="Enter Category") 
	public  WebElement PF_enterCategory;
	
	@FindBy(xpath=".//span[contains(@id,'expand_contract_icon_section')]")
	public WebElement PF_expandSection;
	
	@FindBy(xpath=".//td[contains(text(),'Best Film')]//following::a[1]")
	public WebElement PF_bestFilmCategory;
	
	@FindBy(xpath=".//td[contains(text(),'Best Actor')]//following::a[1]")
	public WebElement PF_bestActorCategory;
	
	@FindBy(xpath=".//td[contains(text(),'Best Director')]//following::a[1]")
	public WebElement PF_bestDirectorCategory;
	
	@FindBy(xpath=".//input[contains(@id,'txtQuestion_')]")
	public WebElement PF_projectName;
	
	@FindBy(xpath=".//input[contains(@name,'chkEntry')]")
	public WebElement PF_checkEntry;
}
