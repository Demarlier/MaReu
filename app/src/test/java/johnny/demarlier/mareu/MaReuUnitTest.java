package johnny.demarlier.mareu;

import org.junit.Before;
import org.junit.Test;

import johnny.demarlier.mareu.Model.Hours;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.Model.Room;
import johnny.demarlier.mareu.Service.DI;
import johnny.demarlier.mareu.Service.MeetingApiService;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MaReuUnitTest {
    MeetingApiService api =  DI.getMeetingApiService();

    @Before
    public void initialize(){
        api.getMeetings().clear();
        api.createMeeting(new Meeting(new Hours(14,00),new Hours (15,00),"28/6/21",new Room("Peach"),"Réunion A", "maxime@lamazone.com, alex@lamzone"));

    }
    // Add a meeting with the same hours and place should not works ---
    @Test
    public void addMeetingsWithSameHoursAndRooms_ShouldNotWorks() {
        assertEquals(api.getMeetings().size(),1);
        api.createMeeting(new Meeting(new Hours(14,00),new Hours (15,00),"28/6/21",new Room("Peach"),"Réunion B", "maxime@lamazone.com, alex@lamzone"));
        assertEquals(api.getMeetings().size(),1);
    }

    // Add a meeting 30 min before one is already set should not work if it's not finish yet ---
    @Test
    public void addMeetingsBeforeAnActualOneWithSameRooms_ShouldNotWorks(){
        assertEquals(api.getMeetings().size(),1);
        api.createMeeting(new Meeting(new Hours(13,30),new Hours (15,00),"28/6/21",new Room("Peach"),"Réunion B", "maxime@lamazone.com, alex@lamzone"));
        assertEquals(api.getMeetings().size(),1);
    }

    // Add a meeting during one is already happening should not works ---
    @Test
    public void addMeetingWhileAnActualOneWithSameRooms_ShouldNotWorks(){
        assertEquals(api.getMeetings().size(),1);
        api.createMeeting(new Meeting(new Hours(14,30),new Hours (15,00),"28/6/21",new Room("Peach"),"Réunion B", "maxime@lamazone.com, alex@lamzone"));
        assertEquals(api.getMeetings().size(),1);
    }

    // Add a meeting who doesn't interfere with another one and change the size of the list ---
    @Test
    public void addMeeting_ShouldWorks(){
        assertEquals(api.getMeetings().size(),1);
        api.createMeeting(new Meeting(new Hours(15,30),new Hours (16,30),"29/6/21",new Room("Bowser"),"Réunion D", "maxime@lamazone.com, alex@lamzone"));
        assertEquals(api.getMeetings().size(),2);
    }

    // Delete a meeting should works and change the size of the list ---
    @Test
    public void deleteMeeting_ShouldWork(){
        assertEquals(api.getMeetings().size(),1);
        api.deleteMeeting(api.getMeetings().get(0));
        assertEquals(api.getMeetings().size(),0);
    }

    // Add a meeting withe same hours and place, but whith another shouldn't interfere and change the size of the list ---
    @Test
    public void addMeetingWithSamePlaceAndRoomsButDifferentDate_ShouldWorks(){
        assertEquals(api.getMeetings().size(),1);
        api.createMeeting(new Meeting(new Hours(14,00),new Hours (15,00),"29/6/21",new Room("Peach"),"Réunion G", "maxime@lamazone.com, alex@lamzone"));
        assertEquals(api.getMeetings().size(),2);

    }
}