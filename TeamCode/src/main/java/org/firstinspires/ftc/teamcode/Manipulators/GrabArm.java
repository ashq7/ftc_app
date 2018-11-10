package org.firstinspires.ftc.teamcode.Manipulators;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by AshQuinn on 10/27/18.
 */

public class GrabArm {
    public DcMotor liftArm; //arm to lift the grabbers
    public Servo grabArmRight; //servo right
    public Servo grabArmLeft; //servo left

    private double rightOpen = 0.6;
    private double rightClosed = 1;
    private double leftOpen = 0.4;
    private double leftClosed = 0;
    private double raisePower = 0.25;
    private double lowerPower = -0.1;

    private HardwareMap HWMap;

    public GrabArm (HardwareMap newHWMap) {
        HWMap = newHWMap;
    }

    public void init (){
        grabArmLeft = HWMap.servo.get("grabArmLeft");
        grabArmRight = HWMap.servo.get("grabArmRight");
        liftArm = HWMap.dcMotor.get("liftArm");
        release();
    }

    public void raise () {
        liftArm.setPower(raisePower);
    }

    public void lower () {
        liftArm.setPower(lowerPower);
    }

    public void stopLiftArm (){
        liftArm.setPower(0);
    }

    public void grab() {
//       Grabs a block
        grabArmLeft.setPosition(leftClosed);
        grabArmRight.setPosition(rightClosed);
    }

    public void release() {
        //Releases the block
        grabArmLeft.setPosition(leftOpen);
        grabArmRight.setPosition(rightOpen);
    }

}
