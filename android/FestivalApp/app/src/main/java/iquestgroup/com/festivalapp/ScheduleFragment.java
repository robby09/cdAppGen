package iquestgroup.com.festivalapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cleveroad.adaptivetablelayout.AdaptiveTableLayout;
import com.greasemonk.timetable.TimeTable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Andreea Both
 */

public class ScheduleFragment extends Fragment {

    private TimeTable timeTable;
    private AdaptiveTableLayout mTableLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, null);
        timeTable = view.findViewById(R.id.time_table);
        timeTable.setItems(generateSamplePlanData());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }


    private List generateSamplePlanData() {
        ArrayList<Artist> artists = new ArrayList<>();
        Calendar calendarS = Calendar.getInstance();
        Calendar calendarE = Calendar.getInstance();

        calendarS.set(2018, 07, 15);
        calendarE.set(2018, 07, 16);
        Artist artist = new Artist("Eminem", "Main Stage", calendarS.getTime(), calendarE.getTime());

        calendarS.set(2018, 07, 17);
        calendarE.set(2018, 07, 18);
        Artist artist2 = new Artist("Dana", "Main Stage", calendarS.getTime(), calendarE.getTime());

        calendarS.set(2018, 07, 14);
        calendarE.set(2018, 07, 15);
        Artist artist3 = new Artist("Adele", "DayDream", calendarS.getTime(), calendarE.getTime());

        calendarS.set(2018, 07, 16);
        calendarE.set(2018, 07, 16);
        Artist artist4 = new Artist("Netsky", "DayDream", calendarS.getTime(), calendarE.getTime());

        calendarS.set(2018, 07, 20);
        calendarE.set(2018, 07, 21);
        Artist artist5 = new Artist("ACDC", "Booha", calendarS.getTime(), calendarE.getTime());
        calendarS.set(2018, 07, 18);
        calendarE.set(2018, 07, 18);
        Artist artist6 = new Artist("Bose", "Booha", calendarS.getTime(), calendarE.getTime());

        artists.add(artist);
        artists.add(artist2);
        artists.add(artist3);
        artists.add(artist4);
        artists.add(artist5);
        artists.add(artist6);
        return artists;
    }
}
