package johnny.demarlier.mareu.Controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;
import johnny.demarlier.mareu.Service.DI;
import johnny.demarlier.mareu.Service.MeetingApiService;

public class DetailMeetingActivity extends AppCompatActivity {

    private MeetingApiService mMeetingApiService;
    private Meeting mMeeting;

    @BindView(R.id.detail_place)
    public TextView mDetailPlace;

    @BindView(R.id.detail_topic)
    public TextView mDetailTopic;

    @BindView(R.id.detail_date)
    public TextView mDetailDate;

    @BindView(R.id.detail_start_meeting)
    public TextView mDetailStartMeeting;

    @BindView(R.id.detail_stop_meeting)
    public TextView mDetailStopMeeting;

    @BindView(R.id.detail_meeting_mail)
    public TextView mDetailMail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_meeting);
        ButterKnife.bind(this);

        mMeetingApiService = DI.getMeetingApiService();
        getMeeting();
        seeDetailMeeting();
    }

    private void getMeeting() {
        mMeeting = getIntent().getParcelableExtra("meeting");
    }

    private void seeDetailMeeting() {
        mDetailPlace.setText(mMeeting.getPlace().toString());
        mDetailTopic.setText(mMeeting.getTopic());
        mDetailDate.setText(mMeeting.getDate());
        mDetailStartMeeting.setText(mMeeting.getStartMeeting().toString());
        mDetailStopMeeting.setText(mMeeting.getStopMeeting().toString());
        mDetailMail.setText(mMeeting.getMail());
    }
}
