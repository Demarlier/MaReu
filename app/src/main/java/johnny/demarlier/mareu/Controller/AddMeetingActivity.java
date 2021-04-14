package johnny.demarlier.mareu.Controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import johnny.demarlier.mareu.Fragment.DatePickerFragment;
import johnny.demarlier.mareu.Fragment.TimePickerFragment;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.Model.Room;
import johnny.demarlier.mareu.R;
import johnny.demarlier.mareu.Service.DI;
import johnny.demarlier.mareu.Service.MeetingApiService;

public class AddMeetingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.submitBtn)
    public Button submitMeeting;

    @BindView(R.id.dateMeeting)
    public Button mAddBtnDateMeeting;

    @BindView(R.id.startMeeting)
    public Button mStartMeeting;

    @BindView(R.id.stopMeeting)
    public Button mStopMeeting;

    @BindView(R.id.topicMeeting)
    public EditText mTopicMeeting;

    @BindView(R.id.placeMeeting)
    public EditText mPlaceMeeting;

    @BindView(R.id.mailMeeting)
    public EditText mMailMeeting;

    private MeetingApiService mMeetingApiService;
    private String currentDateString;
    private String startTimeString;
    private String stopTimeString;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meeting);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getMeetingApiService();

        mAddBtnDateMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        mStartMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "start time picker");

            }
        });
        mStopMeeting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"stop time picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        startTimeString = hourOfDay + ":" + minute;
        stopTimeString = hourOfDay + ":" + minute;

    }

    @OnClick(R.id.submitBtn)
    void addMeeting() {
        String startMeeting = startTimeString;
        String stopMeeting = stopTimeString;
        String date = currentDateString;
        Room place = new Room(mPlaceMeeting.getEditableText().toString());
        String topic = mTopicMeeting.getEditableText().toString();
        String mail = mMailMeeting.getEditableText().toString();
        Meeting meeting = new Meeting(startMeeting, stopMeeting, date, place, topic, mail);
        mMeetingApiService.createMeeting(meeting);
        finish();


    }
}
