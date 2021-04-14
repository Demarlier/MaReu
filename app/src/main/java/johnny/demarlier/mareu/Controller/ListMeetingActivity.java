package johnny.demarlier.mareu.Controller;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;
import johnny.demarlier.mareu.Service.DI;
import johnny.demarlier.mareu.Service.MeetingApiService;
import johnny.demarlier.mareu.View.MeetingListAdapter;


public class ListMeetingActivity extends AppCompatActivity implements MeetingListAdapter.Listener {

    @BindView(R.id.addMeeting_btn)
    public com.google.android.material.floatingactionbutton.FloatingActionButton mFbAddMeeting;

    @BindView(R.id.listMeeting_RecyclerView)
    public RecyclerView mRecyclerView;

    private MeetingApiService mMeetingApiService;
    private List<Meeting> mMeetings;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_meeting);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getMeetingApiService();
        initList();

        mFbAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListMeetingActivity.this, AddMeetingActivity.class));
            }
        });


    }

    private void loadData() {
        MeetingListAdapter adapter = (MeetingListAdapter) mRecyclerView.getAdapter();
        adapter.updateList(mMeetingApiService.getMeeting());
    }

    /**
     * Init the List of meetings
     */
    private void initList() {
        mMeetings = mMeetingApiService.getMeeting();
        mRecyclerView.setAdapter(new MeetingListAdapter(this));
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }


    // @Override
    public void onClickDelete(Meeting meeting) {
        mMeetingApiService.deleteMeeting(meeting);
        loadData();

    }
}
