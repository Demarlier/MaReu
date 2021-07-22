package johnny.demarlier.mareu.View;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

import johnny.demarlier.mareu.Model.Meeting;

public class MeetingDiffCallback extends DiffUtil.Callback {
    private final List<Meeting> mOldMeetings;
    private final List<Meeting> mNewMeetings;

    public MeetingDiffCallback(List<Meeting> newMeetings, List<Meeting> oldMeetings) {
        this.mNewMeetings = newMeetings;
        this.mOldMeetings = oldMeetings;
    }


    @Override
    public int getOldListSize() {
        return mOldMeetings.size();
    }

    @Override
    public int getNewListSize() {
        return mNewMeetings.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldMeetings.get(oldItemPosition).getTopic().equals(mNewMeetings.get(newItemPosition).getTopic());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldMeetings.get(oldItemPosition).equals(mNewMeetings.get(newItemPosition));
    }
}
