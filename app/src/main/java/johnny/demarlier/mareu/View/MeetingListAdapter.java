package johnny.demarlier.mareu.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import johnny.demarlier.mareu.MeetingDiffCallback;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;

public class MeetingListAdapter extends RecyclerView.Adapter<ListMeetingViewHolder> {
    private List<Meeting> mMeetings = new ArrayList<>();

    private final Listener callback;
    public interface Listener {
        void onClickDelete(Meeting meeting);
    }
    public MeetingListAdapter(Listener callback){
        this.callback = callback;
    }


    @NonNull
    @Override
    public ListMeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_meeting, parent, false);
        return new ListMeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMeetingViewHolder holder, int position) {
        holder.bind(mMeetings.get(position),callback);

    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }
    public void updateList(List<Meeting> newList){
        DiffUtil.DiffResult diffResult= DiffUtil.calculateDiff(new MeetingDiffCallback(newList, this.mMeetings));
        this.mMeetings = new ArrayList<>(newList);
        diffResult.dispatchUpdatesTo(this);
    }
}
