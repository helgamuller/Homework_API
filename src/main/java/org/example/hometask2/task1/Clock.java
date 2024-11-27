package org.example.hometask2.task1;

public class Clock implements Readable {
    private int hours;
    private int minutes;
    private int seconds;

    //setters
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    // getters
    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    // tick
    public void tick() {
        this.seconds++;
    }

    @Override
    public void readTime() {
        System.out.println(this.hours +"." + this.minutes + "." + this.seconds);
    }
}
