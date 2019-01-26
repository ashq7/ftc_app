package org.firstinspires.ftc.teamcode.Manipulators;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by AshQuinn on 10/27/18.
 */

public class GrabArm {
    DcMotor.RunMode encMode = DcMotor.RunMode.RUN_USING_ENCODER;
    public DcMotor liftArm; //arm to lift the ball bucket
    public CRServo bucketWheel; //wheel that rolls in balls

    //RUN__USING_ENCODER;
    //where do I put this?

    private double raisePower = -0.6;
    private double lowerPower = 0.4;

    /*private double open = 0.4;
    private double closed = 1;*/

    private HardwareMap HWMap;


    public GrabArm (HardwareMap newHWMap) {
        HWMap = newHWMap;

    }

    public void init (){
        bucketWheel = HWMap.crservo.get("bucketWheel");
        liftArm = HWMap.dcMotor.get("liftArm");
        //initial();
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
        bucketWheel.setPower(1);
    }

    public void release() {
        //Releases the block
        bucketWheel.setPower(-1);

    }

    public void stop(){
        bucketWheel.setPower(0);
    }
    /*public void initial(){
        //initialize position to fit in 18 inches
        bucketWheel.setPosition(0);
    }

    public void midway(){
        bucketWheel.setPosition(0.2);
    }*/

}
