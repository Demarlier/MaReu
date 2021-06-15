package johnny.demarlier.mareu.Service;

import java.util.List;

import johnny.demarlier.mareu.Model.Meeting;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    /**
     * {@inheritDoc}
     *
     * @param meeting
     */
    @Override
    public boolean createMeeting(Meeting meeting) {
        if (!meeting.isConflict(meetings)) {

            meetings.add(meeting);
            return true;
        }
        return false;
    }
}
