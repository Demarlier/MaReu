package johnny.demarlier.mareu.Controller;


import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;


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
    private MeetingListAdapter mListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_meeting);
        ButterKnife.bind(this);
        mMeetingApiService = DI.getMeetingApiService();
        initList();

        mFbAddMeeting.setOnClickListener(v -> startActivity(new Intent(ListMeetingActivity.this, AddMeetingActivity.class)));


    }

    private void loadData() {
        mListAdapter = (MeetingListAdapter) mRecyclerView.getAdapter();
        mListAdapter.updateList(mMeetingApiService.getMeetings());
    }

    /**
     * Init the List of meetings
     */
    private void initList() {
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


    @Override
    public void onClickDelete(Meeting meeting) {
        mMeetingApiService.deleteMeeting(meeting);
        loadData();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.reu_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mListAdapter.setMeetingsFull(mMeetingApiService.getMeetings());
                mListAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return true;
    }
}
