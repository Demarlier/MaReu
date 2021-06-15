package johnny.demarlier.mareu.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import johnny.demarlier.mareu.Model.Hours;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.Model.Room;


public abstract class DummyMeetingGenerator {


    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(new Hours(14, 00), new Hours(15, 00), "28/6/21", new Room("Peach"), "Réunion A", "maxime@lamzone.com, alex@lamzone"),
            new Meeting(new Hours(16,00), new Hours(17,00),"28/6/21",new Room("Mario"),"Réunion B","paul@lamzone.com, viviane@lamzone"),
            new Meeting(new Hours(19, 00), new Hours(20, 00), "28/6/21", new Room("Luigi"), "Réunion C", "amandine@lamazone.com, luc@lamzone"
    ));

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
