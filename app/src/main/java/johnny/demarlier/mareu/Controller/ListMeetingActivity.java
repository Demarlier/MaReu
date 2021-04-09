package johnny.demarlier.mareu.Controller;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import johnny.demarlier.mareu.Event.DeleteMeetingEvent;
import johnny.demarlier.mareu.Fragment.DatePickerFragment;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;
import johnny.demarlier.mareu.Service.DI;
import johnny.demarlier.mareu.Service.MeetingApiService;
import johnny.demarlier.mareu.View.MeetingListAdapter;

import static java.security.AccessController.getContext;

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

    //    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.list_meeting, container, false);
//        Context context = view.getContext();
//        mRecyclerView = (RecyclerView) view;
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
//        return view;
//    }
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
        //EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     *
     * @param event
     */
    public void onDeleteNeighbour(DeleteMeetingEvent event) {
        mMeetingApiService.deleteMeeting(event.meeting);
        loadData();
    }

    // @Override
    public void onClickDelete(Meeting meeting) {
        //TODO

    }
}
