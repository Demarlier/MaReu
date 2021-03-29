package johnny.demarlier.mareu.Event;

import johnny.demarlier.mareu.Model.Meeting;

/**
 * Event fired when a user delete a meeting
 */


public class DeleteMeetingEvent {
    public Meeting meeting;

    /**
     * Constructor.
     * @param meeting
     */
    
    public DeleteMeetingEvent(Meeting meeting) {
        this.meeting = meeting;
    }
}
