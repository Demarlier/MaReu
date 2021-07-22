package johnny.demarlier.mareu.Controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.colorpicker.FloatingButton;

import java.text.DateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import johnny.demarlier.mareu.Fragment.DatePickerFragment;
import johnny.demarlier.mareu.Fragment.TimePickerFragment;
import johnny.demarlier.mareu.Model.Hours;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.Model.Room;
import johnny.demarlier.mareu.R;
import johnny.demarlier.mareu.Service.DI;
import johnny.demarlier.mareu.Service.MeetingApiService;

public class AddMeetingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @BindView(R.id.submitBtn)
    public Button mSubmitMeeting;

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

    @BindView(R.id.fabColorPicker)
    public FloatingButton mFabColorPicker;


    private MeetingApiService mMeetingApiService;
    private String mCurrentDateString;
    private Hours mStartTimeMeeting;
    private Hours mStopTimeMeeting;
    private int color = -16777216;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meeting);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getMeetingApiService();
        mFabColorPicker.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purple_500)));

        mAddBtnDateMeeting.setOnClickListener(v -> {
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "date picker");
        });
        mStartMeeting.setOnClickListener(v -> {
            DialogFragment timePicker = new TimePickerFragment((view, hourOfDay, minute) -> {
                mStartTimeMeeting = new Hours(hourOfDay, minute);
                mStartMeeting.setText(hourOfDay + ":" + minute);
            });
            timePicker.show(getSupportFragmentManager(), "start time picker");

        });
        mStopMeeting.setOnClickListener(v -> {
            DialogFragment timePicker = new TimePickerFragment((view, hourOfDay, minute) -> {
                mStopTimeMeeting = new Hours(hourOfDay, minute);
                mStopMeeting.setText(hourOfDay + ":" + minute);
            });
            timePicker.show(getSupportFragmentManager(), "stop time picker");
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        mCurrentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());
        mAddBtnDateMeeting.setText(mCurrentDateString);
    }


    @OnClick(R.id.submitBtn)
    void addMeeting() {

        String date = mCurrentDateString;
        color = mFabColorPicker.getBackgroundTintList().getDefaultColor();
        Room place = new Room(mPlaceMeeting.getEditableText().toString());
        String topic = mTopicMeeting.getEditableText().toString();
        String mail = mMailMeeting.getEditableText().toString();
        if (mStartTimeMeeting == null || mStopTimeMeeting == null || date == null || place.getModelRoom().equals("") || topic.equals("")) {
            Toast.makeText(AddMeetingActivity.this, "Please write a place and the hours of a meeting before submit", Toast.LENGTH_SHORT).show();
            return;
        }
        Meeting meeting = new Meeting(mStartTimeMeeting, mStopTimeMeeting, date, place, topic, mail);
        meeting.setMeetingColor(color);
        if (!mMeetingApiService.createMeeting(meeting)) {
            Toast.makeText(AddMeetingActivity.this, "This Hours and Place are already used", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddMeetingActivity.this, "Your meeting has been set", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}
