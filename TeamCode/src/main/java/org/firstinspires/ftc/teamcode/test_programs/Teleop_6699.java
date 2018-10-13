package org.firstinspires.ftc.teamcode.test_programs;

/**
 * Created by AshQuinn on 10/13/18.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Molly on 9/30/2017.
 */
@TeleOp(name="Holonomic + LinAct Teleop", group="Test")
//@Disabled
public class Teleop_6699 extends LinearOpMode {
    //Testing GitHub push
    DcMotor NW;
    DcMotor NE;
    DcMotor SW;
    DcMotor SE;
    DcMotor LinAct;

    DcMotor.RunMode encMode = DcMotor.RunMode.RUN_USING_ENCODER;

    @Override
    public void runOpMode() {
        double theta;
        double power;
        double pivotpower;

        //Scaling factors for speed
        double driveScale = 0.5;
        double turnScale = 0.5;
        double LinActPower = 0.5;

        double leftX;
        double leftY;
        double rightX;

        NW = hardwareMap.dcMotor.get("NW");
        NW.setMode(encMode);
        NW.setDirection(DcMotor.Direction.FORWARD);
        NW.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        NE = hardwareMap.dcMotor.get("NE");
        NE.setMode(encMode);
        NE.setDirection(DcMotor.Direction.REVERSE);
        NE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SW = hardwareMap.dcMotor.get("SW");
        SW.setMode(encMode);
        SW.setDirection(DcMotor.Direction.FORWARD);
        SW.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SE = hardwareMap.dcMotor.get("SE");
        SE.setMode(encMode);
        SE.setDirection(DcMotor.Direction.REVERSE);
        SE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        LinAct = hardwareMap.dcMotor.get("LinAct");

        waitForStart();
        while (opModeIsActive()) {
            leftX = scaleInput(gamepad1.left_stick_x);
            leftY = scaleInput(gamepad1.left_stick_y);
            rightX = scaleInput(gamepad1.right_stick_x);

            //Define angle for pan function by using trigonometry to calculate it from joystick
            theta = -Math.PI / 4 + Math.atan2(-leftY, -leftX);
            //Define power for pan function by using math to calculate the length of the hypotenuse between the x and y axes
            power = Math.pow(Math.sqrt((leftX) * (leftX) + (leftY) * (leftY)), 3);
            //Define power for turning, based solely on the x and y axes
            pivotpower = -rightX;

            telemetry.addData("JoyStickX", gamepad1.left_stick_x);
            telemetry.addData("ScaledX", leftX);
            telemetry.addData("JoyStickY", gamepad1.left_stick_y);
            telemetry.addData("ScaledY",leftY);
            //telemetry.addData("Power", power);
            telemetry.update();
            if (gamepad1.dpad_up) {
                //Toggles slow mode.
                if (turnScale == 0.5) {
                    //If it's fast, make it slow
                    driveScale = 0.3;
                    turnScale = 0.3;
                } else {
                    //If it's slow, make it fast
                    driveScale = 0.5;
                    turnScale = 0.5;
                }
                while (gamepad1.dpad_up) {
                    //Don't constantly change back and forth. One change per button press.
                    idle();
                }
            }

            if (power > 0.01) {
                //Power restrictions are so that random slightly-incorrect resets don't move the robot
                pan(theta, power * driveScale);
            } else if (Math.abs(pivotpower) > 0.1) {
                //Only turn it if it isn't driving
                NE.setPower(pivotpower * turnScale);
                SE.setPower(pivotpower * turnScale);
                NW.setPower(-pivotpower * turnScale);
                SW.setPower(-pivotpower * turnScale);
            } else {
                //Otherwise, don't move
                stopmotors();
            }

            if (gamepad1.a) {
                LinAct.setPower(-LinActPower);
            } else if (gamepad1.y) {
                LinAct.setPower(LinActPower);
            } else {
                LinAct.setPower(0);
            }
        }
    }

    void pan(double theta, double power) {
        //This is the pan function. If it is given an angle, it will move the robot at that angle.
        if (power <= 1 && power >= -1) {
            NW.setPower(-power*Math.cos(theta));
            SE.setPower(-power*Math.cos(theta));
            NE.setPower(-power*Math.sin(theta));
            SW.setPower(-power*Math.sin(theta));
        } else if (power>1) {
            //If it is given a power outside of the allowable range, it will adjust to be within an allowable range
            NW.setPower(-1*Math.cos(theta));
            SE.setPower(-1*Math.cos(theta));
            NE.setPower(-1*Math.sin(theta));
            SW.setPower(-1*Math.sin(theta));
        } else {
            NW.setPower(1*Math.cos(theta));
            SE.setPower(1*Math.cos(theta));
            NE.setPower(1*Math.sin(theta));
            SW.setPower(1*Math.sin(theta));
        }
    }

    void stopmotors() {
        NW.setPower(0);
        NE.setPower(0);
        SW.setPower(0);
        SE.setPower(0);
    }

    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }

}
