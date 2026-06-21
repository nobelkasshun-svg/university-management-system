package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    public enum RoomType {
        LECTURE_HALL,
        LABORATORY,
        SEMINAR_ROOM,
        COMPUTER_LAB,
        TUTORIAL_ROOM
    }

    private String roomNumber;
    private String building;
    private int capacity;
    private RoomType roomType;
    private boolean hasProjector;
    private boolean hasWhiteboard;
    private boolean isAvailable;
    private List<Schedule> schedules;    // links to your Schedule.java

    public Classroom(String roomNumber, String building,
                     int capacity, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.building = building;
        this.capacity = capacity;
        this.roomType = roomType;
        this.hasProjector = false;
        this.hasWhiteboard = true;
        this.isAvailable = true;
        this.schedules = new ArrayList<>();
    }

    // Full constructor with facilities
    public Classroom(String roomNumber, String building, int capacity,
                     RoomType roomType, boolean hasProjector,
                     boolean hasWhiteboard) {
        this(roomNumber, building, capacity, roomType);
        this.hasProjector = hasProjector;
        this.hasWhiteboard = hasWhiteboard;
    }

    // ─── Getters ────────────────────────────────────────────
    public String getRoomNumber()      { return roomNumber; }
    public String getBuilding()        { return building; }
    public int getCapacity()           { return capacity; }
    public RoomType getRoomType()      { return roomType; }
    public boolean hasProjector()      { return hasProjector; }
    public boolean hasWhiteboard()     { return hasWhiteboard; }
    public boolean isAvailable()       { return isAvailable; }
    public List<Schedule> getSchedules(){ return schedules; }

    // ─── Setters ────────────────────────────────────────────
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public void setHasProjector(boolean hasProjector) { this.hasProjector = hasProjector; }
    public void setHasWhiteboard(boolean hasWhiteboard) { this.hasWhiteboard = hasWhiteboard; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    // ─── Schedule Management ────────────────────────────────
    public boolean addSchedule(Schedule schedule) {
        // check if room is already booked at that day and time
        for (Schedule existing : schedules) {
            if (existing.conflictsWith(schedule)) {
                System.out.println("Room conflict! " + roomNumber
                        + " is already booked on " + schedule.getDay()
                        + " at " + schedule.getTimeSlot().getDisplayTime());
                return false;
            }
        }
        schedules.add(schedule);
        System.out.println("Schedule added to room " + roomNumber + " successfully.");
        return true;
    }

    public boolean removeSchedule(Schedule schedule) {
        if (schedules.remove(schedule)) {
            System.out.println("Schedule removed from room " + roomNumber);
            return true;
        }
        System.out.println("Schedule not found in room " + roomNumber);
        return false;
    }

    // Check if room can fit a course's students
    public boolean canFit(Course course) {
        return course.getStudents().size() <= capacity;
    }

    // Check if room is free at a specific day and time
    public boolean isFreeAt(Schedule.DayOfWeek day, Schedule.TimeSlot timeSlot) {
        for (Schedule s : schedules) {
            if (s.getDay() == day && s.getTimeSlot() == timeSlot) {
                return false;
            }
        }
        return true;
    }

    // ─── Display ────────────────────────────────────────────
    public void displayInfo() {
        System.out.println("═".repeat(55));
        System.out.println("Room      : " + roomNumber);
        System.out.println("Building  : " + building);
        System.out.println("Type      : " + roomType);
        System.out.println("Capacity  : " + capacity + " students");
        System.out.println("Projector : " + (hasProjector ? "Yes" : "No"));
        System.out.println("Whiteboard: " + (hasWhiteboard ? "Yes" : "No"));
        System.out.println("Available : " + (isAvailable ? "Yes" : "No"));
        System.out.println("Scheduled : " + schedules.size() + " session(s)");
        System.out.println("═".repeat(55));
    }

    public void displaySchedule() {
        System.out.println("── Schedule for Room " + roomNumber + " ──");
        if (schedules.isEmpty()) {
            System.out.println("   No schedules assigned.");
        } else {
            schedules.forEach(Schedule::displayShort);
        }
    }

    @Override
    public String toString() {
        return "Classroom [Room=" + roomNumber
                + ", Building=" + building
                + ", Type=" + roomType
                + ", Capacity=" + capacity
                + ", Available=" + isAvailable + "]";
    }
}
