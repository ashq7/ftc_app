package org.firstinspires.ftc.teamcode.test_programs;

import android.os.SystemClock;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ExampleThread extends Thread {
    private int counter;
    private LinearOpMode parent;

    public ExampleThread (LinearOpMode parent) {
        counter = 0;
        this.parent = parent;
    }

    @Override
    public void run() {
        while (parent.opModeIsActive()) {
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
