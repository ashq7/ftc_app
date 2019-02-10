package org.firstinspires.ftc.teamcode.programs;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Manipulators.GrabArm;
import org.firstinspires.ftc.teamcode.Manipulators.LinAct;
import org.firstinspires.ftc.teamcode.drive_trains.HolonomicDrive;

/**
 * Created by AshQuinn on 11/9/18.
 */

@TeleOp (name = "Teleop", group = "Actual")
public class Teleop extends LinearOpMode {
    LinAct linAct;
    HolonomicDrive driveTrain;
    GrabArm grabArm;

    double powerScale = 0.5;
    double turnScale = 0.5;

    @Override
    public void runOpMode () {
        linAct = new LinAct(hardwareMap);
        driveTrain = new HolonomicDrive(this);
        grabArm = new GrabArm(hardwareMap);
        linAct.init();
        driveTrain.init();
        grabArm.init();

        waitForStart();
        while (opModeIsActive()){
            double leftX = gamepad1.left_stick_x;
            double leftY = gamepad1.left_stick_y;
            double rightX = gamepad1.right_stick_x;
            /*
            //Define angle for pan function by using trigonometry to calculate it from joystick
            double theta = -Math.PI / 4 + Math.atan2(-leftY, -leftX);
            //Define power for pan function by using math to calculate the length of the hypotenuse between the x and y axes
            double power = Math.pow(Math.sqrt((leftX) * (leftX) + (leftY) * (leftY)), 3);
            //Define power for turning, based solely on the x and y axes
            double pivotpower = -rightX;

            telemetry.addData("Theta", theta);
            telemetry.addData("Power", power);
            telemetry.addData("Turn Power", pivotpower);
            telemetry.update();

            //pan and turn
            if (Math.abs(power) > 0.1) {
                driveTrain.pan(theta, power * powerScale);
            }
            else if (Math.abs(pivotpower) > 0.1) {
                driveTrain.turn(pivotpower * turnScale);
            }
            else {
                driveTrain.stop();
            }*/
            driveTrain.NE.setPower(powerScale*(leftY+leftX+rightX));
            driveTrain.SW.setPower(powerScale*(leftY+leftX-rightX));
            driveTrain.SE.setPower(powerScale*(leftY-leftX+rightX));
            driveTrain.NW.setPower(powerScale*(leftY-leftX-rightX));
            //retract and extend Linear Actuator, the rover lifter
            if (gamepad1.y) {
                linAct.retract();
            }
            else if (gamepad1.x) {
                linAct.extend();
            }
            else {
                linAct.stop();
            }

            //retract and extend grab arm
            /*if (gamepad1.right_bumper){
                grabArm.liftArm.setTargetPosition(grabArm.liftArm.getCurrentPosition() + 1);
                //sleep(3);
            }
            else if (gamepad1.left_bumper){
                grabArm.liftArm.setTargetPosition(grabArm.liftArm.getCurrentPosition() - 1);
                //sleep(3);
            }*/

            //open and close grabbers
            if (gamepad1.a){
                grabArm.grab();
            }
            else if (gamepad1.b){
                grabArm.release();
            }
            else {
                grabArm.stop();
            }

            if (gamepad1.right_bumper){
                grabArm.pinRelease();
            }
            else {
                grabArm.pinStop();
            }

            if (gamepad1.dpad_left){
                grabArm.ground();
            }
            else if (gamepad1.dpad_up){
                grabArm.dump();
            }
            else if (gamepad1.dpad_right){
                grabArm.adjust();
            }
            else if (gamepad1.dpad_down){
                grabArm.collect();
            }
        }

    }
}
/*results:

 */
