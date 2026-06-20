package interfaces;

public interface Attendable {
    void markPresent();
    void markAbsent();
    int getTotalDays();
    int getDaysPresent();
    double getAttendancePercentage();
    boolean meetsAttendanceRequirement(double requiredPercentage);
}