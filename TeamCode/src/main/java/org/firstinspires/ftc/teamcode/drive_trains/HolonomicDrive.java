package org.firstinspires.ftc.teamcode.drive_trains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by AshQuinn on 9/22/18.
 */

public class HolonomicDrive {
    public DcMotor NW;
    public DcMotor NE;
    public DcMotor SW;
    public DcMotor SE;

    private Thread driveThread;

    public HardwareMap hardwareMap;

    DcMotor.RunMode encMode = DcMotor.RunMode.RUN_USING_ENCODER;
    DcMotor.RunMode dumbMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;

    public HolonomicDrive (final LinearOpMode parent){
        hardwareMap = parent.hardwareMap;

        driveThread = new Thread() {
            @Override
            public void run() {
                super.run();
                // check opModeIsActive()
                while (parent.opModeIsActive()) {
                    
                }
            }
        };
    }

    public void init () {
        NW = hardwareMap.dcMotor.get("NW");
        NW.setMode(dumbMode);
        NW.setDirection(DcMotor.Direction.REVERSE);
        NW.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        NE = hardwareMap.dcMotor.get("NE");
        NE.setMode(dumbMode);
        NE.setDirection(DcMotor.Direction.FORWARD);
        NE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SW = hardwareMap.dcMotor.get("SW");
        SW.setMode(dumbMode);
        SW.setDirection(DcMotor.Direction.REVERSE);
        SW.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SE = hardwareMap.dcMotor.get("SE");
        SE.setMode(dumbMode);
        SE.setDirection(DcMotor.Direction.FORWARD);
        SE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        driveThread.start();
    }

    public void pan(double theta, double power) {
        //This is the pan function. If it is given an angle, it will move the robot at that angle.
        if (power <= 1 && power >= -1) {
            NW.setPower(-power * Math.cos(theta));
            SE.setPower(-power * Math.cos(theta));
            NE.setPower(-power * Math.sin(theta));
            SW.setPower(-power * Math.sin(theta));
        } else if (power > 1) {
            //If it is given a power outside of the allowable range, it will adjust to be within an allowable range
            NW.setPower(-Math.cos(theta));
            SE.setPower(-Math.cos(theta));
            NE.setPower(-Math.sin(theta));
            SW.setPower(-Math.sin(theta));
        } else {
            NW.setPower(Math.cos(theta));
            SE.setPower(Math.cos(theta));
            NE.setPower(Math.sin(theta));
            SW.setPower(Math.sin(theta));
        }
    }
    public void turn (double power){
        NE.setPower(power);
        SE.setPower(power);
        NW.setPower(-power);
        SW.setPower(-power);
    }
    public void stop () {
        NE.setPower(0);
        SE.setPower(0);
        NW.setPower(0);
        SW.setPower(0);
    }
}
