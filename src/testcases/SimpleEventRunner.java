package testcases;

import org.testng.annotations.Test;
import businessClasses.AbstractsEventCreator;
import businessClasses.AttendanceEventCreator;
import businessClasses.BulkEditEventCreator;
import businessClasses.CapacityEventCreator;
import businessClasses.EventEntryCodeCreator;
import businessClasses.SimpleEventCreator;
import businessClasses.TableBookingEventCreator;

public class SimpleEventRunner {

@Test
public void testSimpleEvent() {
		
		
		SimpleEventCreator simpleEvent = new SimpleEventCreator();
		simpleEvent.createSimpleEvent("ExcelDataFiles/SimpleEventData.xlsx");
	}
	
@Test
public void testTableBookingEvent() {
		
		TableBookingEventCreator tableEvent = new TableBookingEventCreator();
		tableEvent.createTableBookingEvent("ExcelDataFiles/TableBookingEventData.xlsx");
	}
	
@Test
public void testCapacityCheckingEvent() {
		
		CapacityEventCreator capacityEvent = new CapacityEventCreator();
		capacityEvent.createCapacityEvent("ExcelDataFiles/CapacityCheckingEventData.xlsx");
	}

@Test
public void testAttendanceRecording() {
	
	AttendanceEventCreator attendanceEvent = new AttendanceEventCreator();
	attendanceEvent.createAttendanceEvent("ExcelDataFiles/AttendanceRecording.xlsx");
	
	}

@Test
public void testBulkEdit() {
	
	BulkEditEventCreator bulkEditEvent = new BulkEditEventCreator();
	bulkEditEvent.createBulkEditEvent("ExcelDataFiles/BulkEditData.xlsx");
	
	}

@Test
public void testEventEntryCode() {
	
	EventEntryCodeCreator eventEntryCode = new EventEntryCodeCreator();
	eventEntryCode.createEventEntryCode("ExcelDataFiles/EventEntryCodeData.xlsx");
	
	}
}
