package org.firstinspires.ftc.teamcode.Manipulators;

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

    public GrabArm () {
    }
    public void init (HardwareMap newHWMap){
        HWMap = newHWMap;
        grabArmLeft = HWMap.servo.get("grabArmLeft");
        grabArmRight = HWMap.servo.get("grabArmRight");
        release();

    }


}
