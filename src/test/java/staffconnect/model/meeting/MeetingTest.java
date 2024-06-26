package staffconnect.model.meeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class MeetingTest {
    private static final MeetingDescription TEST_DESCRIPTION = new MeetingDescription("Valid description");
    private static final MeetingDateTime TEST_DATE = new MeetingDateTime("12/04/2023 12:00");
    private static final MeetingDescription TEST_OTHERDESCRIPTION = new MeetingDescription("Another valid description");
    private static final MeetingDateTime TEST_OTHERDATE = new MeetingDateTime("13/04/2023 13:00");

    @Test
    public void equals() {

        Meeting testMeeting = new Meeting(TEST_DESCRIPTION, TEST_DATE);
        Meeting diffMeetingDescription = new Meeting(TEST_OTHERDESCRIPTION, TEST_DATE);
        Meeting diffMeetingTime = new Meeting(TEST_DESCRIPTION, TEST_OTHERDATE);
        MeetingDateTime testDate = new MeetingDateTime("12/04/2023 12:00");


        // same values -> returns true
        assertEquals(testMeeting, new Meeting(new MeetingDescription("Valid description"),
                                              new MeetingDateTime("12/04/2023 12:00")));

        // same object -> returns true
        assertEquals(testMeeting, testMeeting);

        // null -> returns false
        assertNotEquals(null, testMeeting);

        // different type -> returns false
        assertNotEquals(5, testMeeting);

        //Different object type -> returns false
        assertFalse(testMeeting.equals(testDate));

        // different description -> returns false
        assertNotEquals(testMeeting, diffMeetingDescription);

        // different time -> returns false
        assertNotEquals(testMeeting, diffMeetingTime);
    }

    @Test
    public void asSymmetricHashcode() {
        Meeting first = new Meeting(new MeetingDescription("test"), new MeetingDateTime("12/04/2023 12:00"));
        Meeting second = new Meeting(new MeetingDescription("test"), new MeetingDateTime("12/04/2023 12:00"));
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void toStringMethod() {
        Meeting testMeeting = new Meeting(TEST_DESCRIPTION, TEST_DATE);
        String expected = TEST_DATE + ":" + TEST_DESCRIPTION;
        assertEquals(expected, testMeeting.toString());
    }


}
