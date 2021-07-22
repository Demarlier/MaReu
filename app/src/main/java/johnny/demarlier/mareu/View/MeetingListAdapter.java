package johnny.demarlier.mareu.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import johnny.demarlier.mareu.Controller.DetailMeetingActivity;
import johnny.demarlier.mareu.Model.Meeting;
import johnny.demarlier.mareu.R;

public class MeetingListAdapter extends RecyclerView.Adapter<ListMeetingViewHolder> implements Filterable {
    private List<Meeting> mMeetings = new ArrayList<>();
    private List<Meeting> mMeetingsFull;


    public void setMeetingsFull(List<Meeting> meetingsFull) {
        mMeetingsFull = meetingsFull;
    }

    private final Listener callback;

    public interface Listener {
        void onClickDelete(Meeting meeting);
    }

    public MeetingListAdapter(Listener callback) {
        this.callback = callback;
        mMeetingsFull = new ArrayList<>(mMeetings);
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
        holder.bind(mMeetings.get(position), callback);


        holder.itemView.setOnClickListener(v -> {
            Intent detailActivity = new Intent(holder.itemView.getContext(), DetailMeetingActivity.class);
            detailActivity.putExtra(DetailMeetingActivity.MEETING_EXTRA_KEY, mMeetings.get(position));
            v.getContext().startActivity(detailActivity);
        });
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public void updateList(List<Meeting> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MeetingDiffCallback(newList, this.mMeetings));
        this.mMeetings = new ArrayList<>(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public Filter getFilter() {
        return meetingFilter;
    }

    private Filter meetingFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Meeting> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mMeetingsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Meeting item : mMeetingsFull) {
                    if (item.getDate().toLowerCase().contains(filterPattern) || item.getPlace().getModelRoom().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mMeetings.clear();
            mMeetings.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}
