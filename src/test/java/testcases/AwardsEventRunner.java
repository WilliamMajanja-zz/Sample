package testcases;

import org.testng.annotations.Test;

import businessClasses.AwardsEventCreator;


public class AwardsEventRunner {

@Test
public void testSimpleEvent() {
			
		AwardsEventCreator awardsEvent = new AwardsEventCreator();
		awardsEvent.createAwardsEvent("ExcelDataFiles/AwardsEventData.xlsx");
	}
}
