package johnny.demarlier.mareu.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;

public class MeetingRecyclerViewAdapter extends RecyclerView.Adapter<MeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;

    public MeetingRecyclerViewAdapter(List<Meeting>items){
        mMeetings = items;
    }

    @NonNull
    @Override
    public MeetingRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingRecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.item_list_avatar)
//        public ImageView mNeighbourAvatar;
//        @BindView(R.id.item_list_name)
//        public TextView mNeighbourName;
//        @BindView(R.id.item_list_delete_button)
//        public ImageButton mDeleteButton;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
