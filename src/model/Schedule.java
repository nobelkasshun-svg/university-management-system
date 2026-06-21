package model;

public class Schedule {
    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public enum TimeSlot {
        PERIOD_1("08:00 - 09:30"),
        PERIOD_2("09:45 - 11:15"),
        PERIOD_3("11:30 - 13:00"),
        PERIOD_4("14:00 - 15:30"),
        PERIOD_5("15:45 - 17:15");

        private final String displayTime;

        TimeSlot(String displayTime) {
            this.displayTime = displayTime;
        }

        public String getDisplayTime() {
            return displayTime;
        }
    }

    private DayOfWeek day;
    private TimeSlot timeSlot;

    public Schedule(DayOfWeek day, TimeSlot timeSlot) {
        this.day = day;
        this.timeSlot = timeSlot;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public boolean conflictsWith(Schedule other) {
        return this.day == other.day && this.timeSlot == other.timeSlot;
    }

    public void displayShort() {
        System.out.println("   - " + day + " at " + timeSlot.getDisplayTime());
    }

    @Override
    public String toString() {
        return "Schedule [Day=" + day + ", TimeSlot=" + timeSlot.getDisplayTime() + "]";
    }
}
