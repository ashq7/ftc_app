package org.firstinspires.ftc.teamcode.test_programs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by AshQuinn on 12/8/18.
 */

public class ServoLinActTest extends LinearOpMode {
    public CRServo SmallLinAct;
    double Power = 0.5;

    @Override
    public void runOpMode() {
        SmallLinAct = hardwareMap.servo.get("SmallLinAct");
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.a) {
                SmallLinAct.setPower(-1);
            } else if (gamepad1.y) {
                SmallLinAct.setPower(1);
            }
            else {
                SmallLinAct.setPower(0);
            }

        }
    }
}
