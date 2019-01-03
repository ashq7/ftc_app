package org.firstinspires.ftc.teamcode.test_programs;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

@Autonomous(name="GyroSensorTest", group="Test")
public class GyroSensorTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        GyroSensor gyro = hardwareMap.gyroSensor.get("gyro");
        gyro.calibrate();

        while (gyro.isCalibrating()) {
            telemetry.addData("Gyro", "Calibrating...");
            telemetry.update();
        }

        telemetry.addData("Gyro", "Ready");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            String gyroData = "Heading: ";
            gyroData += Integer.toString(gyro.getHeading());
            gyroData += ", Rotation: ";
            gyroData += Integer.toString(gyro.rawZ());
            telemetry.addData("Gyro", gyroData);
            telemetry.update();
        }
    }
}
