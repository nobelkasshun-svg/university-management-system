package model;

public class Schedule {

    public enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public enum TimeSlot {
        SLOT_8_9("8:00 AM - 9:00 AM"),
        SLOT_9_10("9:00 AM - 10:00 AM"),
        SLOT_10_11("10:00 AM - 11:00 AM"),
        SLOT_11_12("11:00 AM - 12:00 PM"),
        SLOT_12_1("12:00 PM - 1:00 PM"),
        SLOT_1_2("1:00 PM - 2:00 PM"),
        SLOT_2_3("2:00 PM - 3:00 PM"),
        SLOT_3_4("3:00 PM - 4:00 PM"),
        SLOT_4_5("4:00 PM - 5:00 PM");

        private String displayTime;

        TimeSlot(String displayTime) {
            this.displayTime = displayTime;
        }

        public String getDisplayTime() { return displayTime; }
    }

    private Course course;          // your Course.java
    private Teacher teacher;        // your Teacher.java
    private DayOfWeek day;
    private TimeSlot timeSlot;
    private String room;
    private String semester;
    private boolean isActive;

    public Schedule(Course course, Teacher teacher, DayOfWeek day,
                    TimeSlot timeSlot, String room, String semester) {
        this.course = course;
        this.teacher = teacher;
        this.day = day;
        this.timeSlot = timeSlot;
        this.room = room;
        this.semester = semester;
        this.isActive = true;
    }

    // ─── Getters ────────────────────────────────────────────
    public Course getCourse()     { return course; }
    public Teacher getTeacher()   { return teacher; }
    public DayOfWeek getDay()     { return day; }
    public TimeSlot getTimeSlot() { return timeSlot; }
    public String getRoom()       { return room; }
    public String getSemester()   { return semester; }
    public boolean isActive()     { return isActive; }

    // ─── Setters ────────────────────────────────────────────
    public void setDay(DayOfWeek day)         { this.day = day; }
    public void setTimeSlot(TimeSlot timeSlot){ this.timeSlot = timeSlot; }
    public void setRoom(String room)          { this.room = room; }
    public void setActive(boolean active)     { this.isActive = active; }

    // ─── Conflict checking ──────────────────────────────────

    // Check if this schedule conflicts with another
    public boolean conflictsWith(Schedule other) {
        return this.day == other.day
                && this.timeSlot == other.timeSlot
                && this.room.equalsIgnoreCase(other.room);
    }

    // Check if teacher is double booked
    public boolean teacherConflictsWith(Schedule other) {
        return this.teacher.equals(other.teacher)
                && this.day == other.day
                && this.timeSlot == other.timeSlot;
    }

    // ─── Display ────────────────────────────────────────────
    public void displayInfo() {
        System.out.println("─".repeat(60));
        System.out.println("Course   : " + course.getCourseCode()
                + " - " + course.getCourseName());
        System.out.println("Teacher  : " + teacher.getName());
        System.out.println("Day      : " + day);
        System.out.println("Time     : " + timeSlot.getDisplayTime());
        System.out.println("Room     : " + room);
        System.out.println("Semester : " + semester);
        System.out.println("Status   : " + (isActive ? "Active" : "Inactive"));
        System.out.println("─".repeat(60));
    }

    public void displayShort() {
        System.out.printf("%-10s | %-30s | %-25s | Room: %-10s | %s%n",
                day,
                course.getCourseCode() + " - " + course.getCourseName(),
                timeSlot.getDisplayTime(),
                room,
                isActive ? "Active" : "Inactive");
    }

    @Override
    public String toString() {
        return "Schedule [Course=" + course.getCourseCode()
                + ", Teacher=" + teacher.getName()
                + ", Day=" + day
                + ", Time=" + timeSlot.getDisplayTime()
                + ", Room=" + room
                + ", Semester=" + semester
                + ", Active=" + isActive + "]";
    }
}
