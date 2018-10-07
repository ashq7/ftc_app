package org.firstinspires.ftc.teamcode.test_programs;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.sensors.PhoneGyroscope;

@Autonomous(name="Test Phone Gyro", group="Test Programs")
// @Disabled
public class TestPhoneGyro extends LinearOpMode {
    @Override
    public void runOpMode() {
        waitForStart();
        PhoneGyroscope gyro = new PhoneGyroscope(PhoneGyroscope.PhoneOrientation.FACE_UP);
        gyro.start(this.hardwareMap);

        while(opModeIsActive()) {
            telemetry.addData("Gyro Z Position", gyro.getPosition());
            telemetry.update();
        }
    }
}
