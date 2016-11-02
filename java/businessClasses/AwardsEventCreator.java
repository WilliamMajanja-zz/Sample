package businessClasses;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.backend.AwardCategories;
import pages.backend.AwardSections;
import pages.backend.AwardSettings;
import pages.backend.AwardTypes;

public class AwardsEventCreator extends EventCreator {

protected String sectionName = "Film";

public AwardsEventCreator() {
		super();		
	}


public void createAwardsEvent(String fileName) {
			
			log.logHeader("AWARDS EVENT");
			
			try 
			{
				createEvents(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
@Override
protected void setupEvent() {
		
		log.logFunctionTrace("entry");
	
		goToEventCreationMenu();
		setEventPropertiesPage();
		setEventRegistrationPage();
		createEventPrice();
		selectVATcode();
		setPaymentMethod();
		setupAwardsSettings();
		setupAwardsSections();
		setupAwardCategories();
		setupAwardTypes();
		makeEventLive();
		
		log.logFunctionTrace("exit");
	}


@Override
protected void testEvent() {
		
		log.logFunctionTrace("entry");
	
		AwardSubmission awardSubmission = new AwardSubmission(driver, systemData, eventData, registrationData);
		awardSubmission.performAwardSubmission();
			
		log.logFunctionTrace("exit");
	}


protected void setupAwardsSettings() {
	
		AwardSettings awardSettings = PageFactory.initElements(driver, AwardSettings.class);
	
		pageNavigator.navigateTo("Event", "Awards Setup", "Award Settings");
		pageLoader.waitForPageToLoad(driver, awardSettings.PF_lastAwardSubmission);
	
		awardSettings.PF_lastAwardSubmission.sendKeys(eventData.get("EventEndDate"));
		log.logDataToFile("info", "Last Award Submission Date", eventData.get("EventEndDate"));
	
		Select selectFileUpload = new Select(awardSettings.PF_optionalFileUpload);
		selectFileUpload.selectByVisibleText("Optional");
		log.logDataToFile("info", "File Upload is", "Optional");
	
		awardSettings.PF_useSections.click();
		log.logDataToFile("info", "Use Sections", "Checked");
	
		awardSettings.PF_chkManyEntriesPerCategory.click();
		log.logDataToFile("info", "Allow submissions for more categories", "Checked");
	
		Select deletionMode = new Select(awardSettings.PF_selDeletionMode);
		deletionMode.selectByValue("lastSubmissionDate");
		log.logDataToFile("info", "Allow Deletion of Submitted Entries", "Until Last Submission date");
	
		awardSettings.PF_saveByName.click();
	
		log.logMessage("Award Settings are done");
	}


protected void setupAwardsSections() {
	
		AwardSections awardSections = PageFactory.initElements(driver, AwardSections.class);
		
		String minEntries = "2";
		String maxEntries = "6";
		
		pageNavigator.navigateTo("Event", "Awards Setup", "Sections");
		pageLoader.waitForPageToLoad(driver, awardSections.PF_addNew);
		
		awardSections.PF_addNew.click();
		pageLoader.waitForPageToLoad(driver, awardSections.PF_description);
		
		awardSections.PF_description.sendKeys(sectionName);
		awardSections.PF_minEntries.sendKeys(minEntries);
		awardSections.PF_maxEntries.sendKeys(maxEntries);
		
		awardSections.PF_saveByName.click();
		
		log.logMessage("Award Section is created");
	}


protected void setupAwardCategories() {
	
		AwardCategories awardCategories = PageFactory.initElements(driver, AwardCategories.class);
	
		String category1 = "Best Film";
		String category2 = "Best Actor";
		String category3 = "Best Director";
			
		pageNavigator.navigateTo("Event", "Awards Setup", "Categories");
		
		for(int i = 1 ; i < 4 ; i++)
		{
			pageLoader.waitForPageToLoad(driver, awardCategories.PF_addNew);
			awardCategories.PF_addNew.click();
			pageLoader.waitForPageToLoad(driver, awardCategories.PF_descriptionByName);
		
			if(i == 1)
			{
				awardCategories.PF_descriptionByName.sendKeys(category1);
				log.logDataToFile("info", "Award category added", category1);
			}
		
			if(i == 2)
			{
				awardCategories.PF_descriptionByName.sendKeys(category2);
				log.logDataToFile("info", "Award category added", category2);
			}
			
			if(i == 3)
			{
				awardCategories.PF_descriptionByName.sendKeys(category3);
				log.logDataToFile("info", "Award category added", category3);
			}
			
			Select selectSection = new Select(awardCategories.PF_selectSection);
			selectSection.selectByVisibleText(sectionName);
	
			awardCategories.PF_saveByName.click();
			
		}
			log.logMessage("Award Categories are created");
   	}


protected void setupAwardTypes() {
	
		AwardTypes awardTypes = PageFactory.initElements(driver, AwardTypes.class);
	
		String awardType1 = "Gold";
		String awardType2 = "Silver";
		String awardType3 = "Bronze";
		
		pageNavigator.navigateTo("Event", "Awards Setup", "Award Types");
		
		for(int i = 1 ; i < 4 ; i++)
		{
			pageLoader.waitForPageToLoad(driver, awardTypes.PF_addNew);
			awardTypes.PF_addNew.click();
			pageLoader.waitForPageToLoad(driver, awardTypes.PF_description);
	
			if(i == 1)
			{
				awardTypes.PF_description.sendKeys(awardType1);
				log.logDataToFile("info", "New Award Type added", awardType1);
			}
		
			if(i == 2)
			{
				awardTypes.PF_description.sendKeys(awardType2);
				log.logDataToFile("info", "New Award Type added", awardType2);
			}
			
			if(i == 3)
			{
				awardTypes.PF_description.sendKeys(awardType3);
				log.logDataToFile("info", "New Award Type added", awardType3);
			}
			
			Select section = new Select(awardTypes.PF_selectSection);
			section.selectByVisibleText(sectionName);
	
			awardTypes.PF_saveByName.click();
		}
		
			log.logMessage("Award Types are created");
	}
}
