package johnny.demarlier.mareu.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ListMeetingPagerAdapter extends FragmentStateAdapter {

    public ListMeetingPagerAdapter(@NonNull FragmentManager fm, Lifecycle lifecycle){
        super(fm, lifecycle);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}


