package org.firstinspires.ftc.teamcode.programs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Manipulators.GrabArm;
import org.firstinspires.ftc.teamcode.Manipulators.LinAct;
import org.firstinspires.ftc.teamcode.drive_trains.HolonomicDrive;

/**
 * Created by AshQuinn on 11/16/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class AutonomousOpposite extends LinearOpMode {

    LinAct linAct;
    HolonomicDrive driveTrain;
    GrabArm grabArm;
    double power = 0.25;

    @Override
    public void runOpMode () throws InterruptedException {
        linAct = new LinAct(hardwareMap);
        driveTrain = new HolonomicDrive(hardwareMap);
        grabArm = new GrabArm(hardwareMap);
        linAct.init();
        driveTrain.init();
        grabArm.init();

        waitForStart();

        grabArm.midway();

        linAct.extend();
        sleep(9000);

        linAct.stop();

        sleep(2000);

        //off hook (west)
        driveTrain.pan(7*Math.PI/4, power);
        sleep(500);
        driveTrain.stop();

        sleep(500);

        //out of pole's way (north)
        driveTrain.pan(Math.PI/2, power);
        sleep (2000);
        driveTrain.stop();

        sleep(500);

        //into corner (east)
        driveTrain.pan(3*Math.PI/4, power);
        sleep(2000);

        driveTrain.stop();

        grabArm.release();
    }
}
