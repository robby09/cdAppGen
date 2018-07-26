package iquestgroup.com.festivalapp;


import com.greasemonk.timetable.IGridItem;
import com.greasemonk.timetable.TimeRange;

import java.util.Date;

/**
 * @author Andreea Both
 */

public class Artist implements IGridItem {


    private String employeeName, projectName;
    private TimeRange timeRange;

    public Artist() {
    }

    public Artist(String stage, String name, Date planStart, Date planEnd) {
        this.employeeName = name;
        this.projectName = stage;
        this.timeRange = new TimeRange(planStart, planEnd);
    }

    @Override
    public TimeRange getTimeRange() {
        return timeRange;
    }

    @Override
    public String getName() {
        return projectName;
    }

    @Override
    public String getPersonName() {
        return employeeName;
    }

}
