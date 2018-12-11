package org.firstinspires.ftc.teamcode.test_programs;

import android.os.SystemClock;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ExampleThread extends Thread {
    private Telemetry telemetry;
    private int counter;

    public ExampleThread(Telemetry telemetry) {
        this.telemetry = telemetry;
        counter = 0;
    }

    @Override
    public void run() {
        while (true) {
            UpdateCounter();
            telemetry.addData("Thread Status", counter);
            telemetry.update();
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

    public int GetCounter() { return counter; }
}
