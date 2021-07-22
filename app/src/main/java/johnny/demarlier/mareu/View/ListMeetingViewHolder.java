package johnny.demarlier.mareu.View;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageButton;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;

public class ListMeetingViewHolder  extends RecyclerView.ViewHolder {
    private View mColorImageView;
    private TextView mPlaceName;
    private TextView mTopicName;
    private TextView mEmailName;
    private TextView mStartMeetingName;
    private ImageButton mDeleteBtn;
    private TextView mSeparation1;
    private TextView mSeparation2;


    public ListMeetingViewHolder(@NonNull View itemView) {
        super(itemView);
        mColorImageView = itemView.findViewById(R.id.item_round_image);
        mPlaceName = itemView.findViewById(R.id.textViewPlace);
        mTopicName = itemView.findViewById(R.id.textViewTopic);
        mEmailName = itemView.findViewById(R.id.textViewEmail);
        mStartMeetingName = itemView.findViewById(R.id.textViewStartMeeting);
        mDeleteBtn = itemView.findViewById(R.id.item_list_delete_button);
        mSeparation1 = itemView.findViewById(R.id.textViewSeparation);
        mSeparation2 = itemView.findViewById(R.id.textViewSeparationTwo);

    }
    public void bind(Meeting meeting, MeetingListAdapter.Listener callback){
        mColorImageView.setBackgroundTintList(ColorStateList.valueOf(meeting.getMeetingColor()));
        mDeleteBtn.setOnClickListener(view -> callback.onClickDelete(meeting));
        mPlaceName.setText(meeting.getPlace().getModelRoom());
        mTopicName.setText(meeting.getTopic());
        mEmailName.setText(meeting.getMail());
        mStartMeetingName.setText(meeting.getStartMeeting().toString());
    }

}
