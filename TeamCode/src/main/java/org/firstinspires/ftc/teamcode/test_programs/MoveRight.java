package org.firstinspires.ftc.teamcode.test_programs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive_trains.HolonomicDrive;

@Autonomous(name = "Moveright",group ="Test")
public class MoveRight extends LinearOpMode {
    @Override
    public void runOpMode () {
        HolonomicDrive Drivetrain;
        Drivetrain = new HolonomicDrive(this);
        Drivetrain.init();

        waitForStart();
        Drivetrain.pan(Math.PI/2.0, 0.5);
        sleep(5000);
        Drivetrain.stop();
    }
}