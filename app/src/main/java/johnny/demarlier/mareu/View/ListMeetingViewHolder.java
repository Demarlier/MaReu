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
    private TextView startMeetingName;
    private ImageButton deleteBtn;
    private TextView separation1;
    private TextView separation2;



    public ListMeetingViewHolder(@NonNull View itemView) {
        super(itemView);
        roundImage = itemView.findViewById(R.id.item_round_image);
        placeName = itemView.findViewById(R.id.textViewPlace);
        topicName = itemView.findViewById(R.id.textViewTopic);
        emailName = itemView.findViewById(R.id.textViewEmail);
        startMeetingName = itemView.findViewById(R.id.textViewStartMeeting);
        deleteBtn = itemView.findViewById(R.id.item_list_delete_button);
        separation1 = itemView.findViewById(R.id.textViewSeparation);
        separation2 = itemView.findViewById(R.id.textViewSeparationTwo);

    }
    public void bind(Meeting meeting, MeetingListAdapter.Listener callback){
        roundImage.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
        deleteBtn.setOnClickListener(view -> callback.onClickDelete(meeting));
        placeName.setText(meeting.getPlace().getModelRoom());
        topicName.setText(meeting.getTopic());
        emailName.setText(meeting.getMail());
        startMeetingName.setText(meeting.getStartMeeting().toString());
    }

}
