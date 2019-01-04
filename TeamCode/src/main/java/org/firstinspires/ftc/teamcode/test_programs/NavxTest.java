package org.firstinspires.ftc.teamcode.test_programs;

import com.kauailabs.navx.ftc.AHRS;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="NavxTest", group="Test")
public class NavxTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        AHRS navx = AHRS.getInstance(hardwareMap.deviceInterfaceModule.get("dim"), 0, AHRS.DeviceDataType.kProcessedData);

        while (navx.isCalibrating()) {
            telemetry.addData("Navx", "Calibrating...");
            telemetry.update();
        }

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Navx", "Is Moving: " + Boolean.toString(navx.isMoving()));
            telemetry.update();
        }
    }
}
