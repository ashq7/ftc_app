package org.firstinspires.ftc.teamcode.test_programs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="ExampleMultithread", group="Test")
public class ExampleMultithreadOpmode extends LinearOpMode {
    @Override
    public void runOpMode() {
        int counter_val = 0;
        ExampleThread counter = new ExampleThread(counter_val);

        waitForStart();
        counter.start();

        while (opModeIsActive() && counter_val < 10) {
            telemetry.addData("Main Counter Value", counter_val);
            telemetry.update();
            counter_val = counter.getCounter();
        }
    }
}
