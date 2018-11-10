package org.firstinspires.ftc.teamcode.test_programs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="RunDriveMotors", group="Test")
public class RunDriveMotors extends LinearOpMode {
    public DcMotor NW;
    public DcMotor NE;
    public DcMotor SW;
    public DcMotor SE;

    DcMotor.RunMode dumbMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;

    @Override
    public void runOpMode() {
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

        waitForStart();

        NW.setPower(1);
        sleep(1000);
        NW.setPower(0);
        NE.setPower(1);
        sleep(1000);
        NE.setPower(0);
        SE.setPower(1);
        sleep(1000);
        SE.setPower(0);
        SW.setPower(1);
        sleep(1000);
        SW.setPower(0);
    }
}
