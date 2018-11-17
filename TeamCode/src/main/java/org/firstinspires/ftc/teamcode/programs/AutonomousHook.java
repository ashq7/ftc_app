package org.firstinspires.ftc.teamcode.programs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Manipulators.LinAct;
import org.firstinspires.ftc.teamcode.drive_trains.HolonomicDrive;

/**
 * Created by AshQuinn on 11/16/18.
 */

public class AutonomousHook extends LinearOpMode {

    LinAct linAct;
    HolonomicDrive driveTrain;
    double power = 0.25;

    @Override
    public void runOpMode () throws InterruptedException {
        linAct = new LinAct(hardwareMap);
        driveTrain = new HolonomicDrive(hardwareMap);
        linAct.init();
        driveTrain.init();



        waitForStart();

        linAct.extend();
        sleep(8200);

        linAct.stop();

        sleep(2000);

        //off hook (west)
        driveTrain.pan(7*Math.PI/4, power);
        sleep(500);

        driveTrain.stop();
    }
}

