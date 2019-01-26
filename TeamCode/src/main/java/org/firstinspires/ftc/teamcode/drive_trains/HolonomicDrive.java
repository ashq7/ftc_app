package org.firstinspires.ftc.teamcode.drive_trains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by AshQuinn on 9/22/18.
 */

public class HolonomicDrive {
    public DcMotor NW;
    public DcMotor NE;
    public DcMotor SW;
    public DcMotor SE;
    //public DcMotor positionEncoderX;
    //public DcMotor positionEncoderY;

    private Thread driveThread;

    public HardwareMap hardwareMap;

    DcMotor.RunMode encMode = DcMotor.RunMode.RUN_USING_ENCODER;
    DcMotor.RunMode dumbMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;

    public double targetX = 0;
    public double targetY = 0;

    public HolonomicDrive (final LinearOpMode parent){
        hardwareMap = parent.hardwareMap;

        driveThread = new Thread() {
            @Override
            public void run() {
                super.run();
                // check opModeIsActive()
                LinkedList<Double> velocitiesX = new LinkedList();
                LinkedList<Double> velocitiesY = new LinkedList();
                for (int i = 0; i<5; i++){
                    velocitiesX.push(new Double(0));
                    velocitiesY.push(new Double(0));

                }

                //int previousX = positionEncoderX.getCurrentPosition();
                //int previousY = positionEncoderY.getCurrentPosition();

                long previousTime = System.currentTimeMillis();


                /*while (parent.opModeIsActive()) {
                    long nowTime = System.currentTimeMillis();
                    long diffTime = nowTime-previousTime;

                    int nowX = positionEncoderX.getCurrentPosition();
                    int diffX = nowX-previousX;

                    int nowY = positionEncoderY.getCurrentPosition();
                    int diffY = nowY-previousY;

                    Double currVelX = new Double(ticksToMeters(diffX)/(diffTime/1000.0));
                    Double currVelY = new Double(ticksToMeters(diffY)/(diffTime/1000.0));

                    velocitiesX.remove();
                    velocitiesX.push(currVelX);
                    velocitiesY.remove();
                    velocitiesY.push(currVelY);

                    double avgVelX = 0;
                    double avgVelY = 0;

                    for (int i = 0; i<5; i++){
                        avgVelX += velocitiesX.get(i);
                        avgVelY += velocitiesY.get(i);
                    }
                    avgVelX /= 5;
                    avgVelY /= 5;

                    /**
                     * General structure for checking your position
                     * Use the gyroscope to get your heading
                    
                    if (not in target position) {
                        newAngle = arctan(y differential, x differential) - heading

                        // Here, you can make yourself move slower or faster depending on how close you are
                        // Or, simply just use a pre-defined power (make a class variable at the top for this)
                        newPower = clamp(3 feet / distance from target, 0, 1.0) + slowest desired speed

                        pan(newAngle, newPower);
                    } else {
                        stop();
                    }

                }*/
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

        //positionEncoderX = hardwareMap.dcMotor.get("positionEncoderX");

        //positionEncoderY = hardwareMap.dcMotor.get("positionEncoderY");

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

    public void setTarget (double deltaX, double deltaY){

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

    private double ticksToMeters(int ticks){
        return ticks*((3*0.0254*Math.PI)/1000);
    }
}
