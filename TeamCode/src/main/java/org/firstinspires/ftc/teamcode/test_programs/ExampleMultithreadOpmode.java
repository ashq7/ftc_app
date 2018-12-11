package org.firstinspires.ftc.teamcode.test_programs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="ExampleMultithread", group="Test")
public class ExampleMultithreadOpmode extends LinearOpMode {
    @Override
    public void runOpMode() {

        ExampleThread counter = new ExampleThread(telemetry);

        waitForStart();

        counter.start();
        int counter_val = counter.GetCounter();

        while (opModeIsActive() && counter_val < 10) {
            telemetry.addData("Main Counter Value", counter_val);
            telemetry.update();
            counter_val = counter.GetCounter();
        }
    }
}
