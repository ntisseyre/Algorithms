package com.supperslonic.algos.search;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 */

public class MeetingRooms {
    static class Meeting {
        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }

    private List<Meeting> meetingList;

    public MeetingRooms() {
        meetingList = Arrays.asList(
                new Meeting(0, 30),
                new Meeting(5, 10),
                new Meeting(15, 20));// 2 rooms

        meetingList = Arrays.asList(
                new Meeting(7, 10),
                new Meeting(2, 4)); //1 room
    }
 }
