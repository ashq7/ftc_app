package org.firstinspires.ftc.teamcode.programs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Manipulators.GrabArm;
import org.firstinspires.ftc.teamcode.Manipulators.LinAct;
import org.firstinspires.ftc.teamcode.drive_trains.HolonomicDrive;

/**
 * Created by AshQuinn on 11/14/18.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class AutonomousStraight extends LinearOpMode{

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

        //lowering robot using Linear Actuator
        linAct.extend();
        sleep(8000);
        linAct.stop();

        //pause
        sleep(2000);

        //drive off hook (west)
        driveTrain.NW.setPower(.25);
        driveTrain.NE.setPower(-.25);
        driveTrain.SW.setPower(-.25);
        driveTrain.SE.setPower(.25);

        //driveTrain.pan(3*Math.PI/4, power);

        sleep(400);
        driveTrain.stop();

        //pause
        sleep(500);

        //drive towards corner (south)
        /*driveTrain.NE.setPower(.25);
        driveTrain.SW.setPower(-.25);
        driveTrain.SE.setPower(.25);
        driveTrain.NW.setPower(-.25);

        sleep(3000);
        driveTrain.stop();*/

        //towards corner - either corner goal or crater (north)
        /*driveTrain.pan(5*Math.PI/4, power);
        sleep (5000);
        driveTrain.stop();/*

        //lower grabber
        //grabArm.lower();
        sleep(500);
        //grabArm.stopLiftArm();

        //open grabber
        grabArm.release();
        sleep(500);

        //pan backwards to deploy marker
        /*driveTrain.pan(5*Math.PI/4, power);
        sleep(1000);
        driveTrain.stop();

        /*driveTrain.pan(Math.PI/4, power);
        driveTrain.stop();*/
    }
}


