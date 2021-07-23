package johnny.demarlier.mareu.Service;

import java.util.List;

import johnny.demarlier.mareu.Model.Meeting;


/**
 * Meeting API client
 */
public interface MeetingApiService {


    List<Meeting> getMeetings();


    void deleteMeeting(Meeting meeting);


    boolean createMeeting(Meeting meeting);
}