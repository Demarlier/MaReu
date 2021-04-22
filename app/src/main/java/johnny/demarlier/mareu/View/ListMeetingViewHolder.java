package johnny.demarlier.mareu.View;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;

public class ListMeetingViewHolder  extends RecyclerView.ViewHolder {
    private ImageView roundImage;
    private TextView placeName;
    private TextView topicName;
    private TextView emailName;
    private TextView dateName;
    private TextView startMeetingName;
    private TextView stopMeetingName;
    private ImageButton deleteBtn;



    public ListMeetingViewHolder(@NonNull View itemView) {
        super(itemView);
        roundImage = itemView.findViewById(R.id.item_round_image);
        placeName = itemView.findViewById(R.id.textViewPlace);
        topicName = itemView.findViewById(R.id.textViewTopic);
        emailName = itemView.findViewById(R.id.textViewEmail);
        dateName = itemView.findViewById(R.id.textViewDate);
        startMeetingName = itemView.findViewById(R.id.textViewStartMeeting);
        stopMeetingName = itemView.findViewById(R.id.textViewStopMeeting);
        deleteBtn = itemView.findViewById(R.id.item_list_delete_button);

    }
    public void bind(Meeting meeting, MeetingListAdapter.Listener callback){
        roundImage.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
        deleteBtn.setOnClickListener(view -> callback.onClickDelete(meeting));
        placeName.setText(meeting.getPlace().getModelRoom());
        topicName.setText(meeting.getTopic());
        emailName.setText(meeting.getMail());
        dateName.setText(meeting.getDate());
        startMeetingName.setText(meeting.getStartMeeting().getModelHours());
        stopMeetingName.setText(meeting.getStopMeeting().getModelHours());
    }

}
