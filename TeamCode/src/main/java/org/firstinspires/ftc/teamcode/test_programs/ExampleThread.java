package org.firstinspires.ftc.teamcode.test_programs;

import android.os.SystemClock;

public class ExampleThread extends Thread {
    private int counter;

    public ExampleThread (int starting_val) {
        counter = starting_val;
    }

    @Override
    public void run() {
        while (true) {
            UpdateCounter();
        }
    }

    private void UpdateCounter() {
        try {
            SystemClock.sleep(1000);
            counter++;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public int getCounter() { return counter; }
}
