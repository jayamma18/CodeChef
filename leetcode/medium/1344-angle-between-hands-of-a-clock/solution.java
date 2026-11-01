class Solution {
    public double angleClock(int hour, int minutes) {
        // Position of the minute hand in degrees (6 degrees per minute)
        double minuteAngle = minutes * 6.0;
        
        // Position of the hour hand in degrees (30 degrees per hour + 0.5 degrees per minute)
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
        
        // Find the absolute difference
        double diff = Math.abs(hourAngle - minuteAngle);
        
        // Return the smaller of the two angles formed
        return Math.min(diff, 360.0 - diff);
    }
}
