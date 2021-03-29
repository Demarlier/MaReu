package johnny.demarlier.mareu.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import johnny.demarlier.mareu.Model.Meeting;


public abstract class DummyMeetingGenerator {
    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            //new Meeting()
    );

    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }
}
