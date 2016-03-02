package com.kronologia.civlike;

import java.util.ArrayList;

/**
 * Created by Maxence on 27/01/2016.
 */
public class Journal {

    ArrayList<Event> list_events = new ArrayList<Event>();

    public Journal() {

    }

    public void addEvent(Event e) {
        list_events.add(e);
    }

    public String toString() {
        String result = "";

        for(Event e : this.list_events) {
            result += (e.toString() + System.getProperty("line.separator"));
        }
        return result;
    }

}
