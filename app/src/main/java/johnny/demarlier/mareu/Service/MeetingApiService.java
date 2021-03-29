package johnny.demarlier.mareu.Service;

import java.util.List;

import johnny.demarlier.mareu.Model.Meeting;


/**
 * Meeting API client
 */
public interface MeetingApiService {


    /**
     * Get all the meetings
     *
     * @return {@Link link}
     */
    List<Meeting> getMeeting();

    /**
     * Delete a meeting
     *
     * @param meeting
     */
    void deleteMeeting(Meeting meeting);

    /**
     * Create a meeting
     *
     * @param meeting
     */
    void createMeeting(Meeting meeting);
}