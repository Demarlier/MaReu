package johnny.demarlier.mareu.Controller;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import android.widget.Button;
import android.widget.DatePicker;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import johnny.demarlier.mareu.Fragment.DatePickerFragment;
import johnny.demarlier.mareu.R;

public class ListMeetingActivity extends AppCompatActivity {

    @BindView(R.id.addMeeting_btn)
    public com.google.android.material.floatingactionbutton.FloatingActionButton mFbAddMeeting;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_meeting);
        ButterKnife.bind(this);

        mFbAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListMeetingActivity.this, AddMeetingActivity.class));
            }
        });

}}
