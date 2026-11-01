# Angle Between Hands of a Clock

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two numbers, `hour` and `minutes`, return  *the smaller angle (in degrees) formed between the* `hour` *and the* `minute` *hand*.

Answers within `10-5` of the actual value will be accepted as correct.

 

 **Example 1:** 

```
Input: hour = 12, minutes = 30
Output: 165

```

 **Example 2:** 

```
Input: hour = 3, minutes = 30
Output: 75

```

 **Example 3:** 

```
Input: hour = 3, minutes = 15
Output: 7.5

```

 

 **Constraints:** 

- 1 <= hour <= 12
- 0 <= minutes <= 59

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.2 MB (beats 93.20%)  
**Submitted:** 2026-11-01T11:24:29.108Z  

```java
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

```

---

[View on LeetCode](https://leetcode.com/problems/angle-between-hands-of-a-clock/)