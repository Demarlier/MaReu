package johnny.demarlier.mareu.Controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import johnny.demarlier.mareu.Fragment.DatePickerFragment;
import johnny.demarlier.mareu.Fragment.TimePickerFragment;
import johnny.demarlier.mareu.R;

public class AddMeetingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    @BindView(R.id.submitBtn)
    public Button submitMeeting;

    @BindView(R.id.dateMeeting)
    public Button  mAddBtnDateMeeting;

    @BindView(R.id.hoursMeeting)
    public Button mAddBtnHoursMeeting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meeting);
        ButterKnife.bind(this);

        mAddBtnDateMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        mAddBtnHoursMeeting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());


    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}
