package org.firstinspires.ftc.teamcode.programs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Manipulators.GrabArm;
import org.firstinspires.ftc.teamcode.Manipulators.LinAct;
import org.firstinspires.ftc.teamcode.drive_trains.HolonomicDrive;

/**
 * Created by AshQuinn on 12/1/18.
 */
@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class AutonomousCrater extends LinearOpMode {
    //declaring manipulators and variables
    LinAct linAct;
    HolonomicDrive driveTrain;
    GrabArm grabArm;
    double power = 0.25;

    @Override
    public void runOpMode () throws InterruptedException {
        //allocation and initialization
        linAct = new LinAct(hardwareMap);
        driveTrain = new HolonomicDrive(this);
        grabArm = new GrabArm(hardwareMap);
        linAct.init();
        driveTrain.init();
        grabArm.init();

        waitForStart();

        //grab arm servo closes around team marker
        //grabArm.midway();

        //lift grab arm to avoid drag
        grabArm.raise();
        sleep(500);
        grabArm.stopLiftArm();

        //lowering robot using Linear Actuator
        linAct.extend();
        sleep(8500);
//        linAct.stop();

        //pause
        sleep(2000);

        //drive off hook (west)
        driveTrain.pan(7*Math.PI/4, power);
        sleep(500);
        driveTrain.stop();

        //pause
        sleep(500);



        //towards corner - either corner goal or crater (north)
        driveTrain.pan(Math.PI/4, power);
        sleep (5000);
        driveTrain.stop();

        //lower grabber
        grabArm.lower();
        sleep(500);
        grabArm.stopLiftArm();

        //open grabber
        grabArm.release();

        /*//pan backwards to deploy marker
        driveTrain.pan(5*Math.PI/4, power);
        sleep(1000);
        driveTrain.stop();*/

        /*driveTrain.pan(Math.PI/4, power);
        driveTrain.stop();*/
    }
}

