package businessClasses;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.frontend.AwardSummary;

public class AwardSubmission extends Registration {

	
protected AwardSubmission(WebDriver driver, Map<String, String> systemDataTemp, Map<String, String> eventDataTemp, Map<String, String> registrationDataTemp) {
		super(driver, systemDataTemp, eventDataTemp, registrationDataTemp );
	}
	
	
protected void performAwardSubmission(){
		
		testRegistrationDefault();
	}


@Override
protected void createRegistration() {
	
		enterEmail();
		enterPersonalDetails();
		personalDetails.PF_saveAndProceed.click();
		makeSubmission();
	}


protected void makeSubmission() {
	
		String filmName = "Titanic";
		String actorName = "Tom Hanks";
		String dirName = "Steven S";
		
		AwardSummary awardSummary = PageFactory.initElements(driver, AwardSummary.class);
		pageLoader.waitForPageToLoad(driver, awardSummary.PF_enterCategory);
	
		for(int i = 1 ; i <= 3; i++)
		{
			awardSummary.PF_enterCategory.click();
			awardSummary.PF_expandSection.click();
			
			if(i == 1)
			{
				awardSummary.PF_bestFilmCategory.click();
				log.logMessage("Film Category entered");
				pageLoader.waitForPageToLoad(driver, awardSummary.PF_projectName);
				awardSummary.PF_projectName.sendKeys(filmName);
				log.logDataToFile("info", "Submission started for ", filmName);
			}
	
			if(i == 2)
			{
				awardSummary.PF_bestActorCategory.click();
				log.logMessage("Actor Category entered");
				pageLoader.waitForPageToLoad(driver, awardSummary.PF_projectName);
				awardSummary.PF_projectName.sendKeys(actorName);
				log.logDataToFile("info", "Submission started for ", actorName);
			}
			
			if(i == 3)
			{
				awardSummary.PF_bestDirectorCategory.click();
				log.logMessage("Director Category entered");
				pageLoader.waitForPageToLoad(driver, awardSummary.PF_projectName);
				awardSummary.PF_projectName.sendKeys(dirName);
				log.logDataToFile("info", "Submission started for ", dirName);
			}
			
			awardSummary.PF_saveByName.click();
	
			pageLoader.waitForPageToLoad(driver, awardSummary.PF_checkEntry);
			awardSummary.PF_checkEntry.click();
			awardSummary.PF_submitButton.click();
	
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			log.logMessage("Submission completed successfully");
			
			pageLoader.waitForPageToLoad(driver, awardSummary.PF_enterCategory);
		}
	}
}
