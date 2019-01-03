package org.firstinspires.ftc.teamcode.sensors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;

/**
 * Created by AshQuinn on 1/3/19.
 */

public class GyroThread extends Thread {

    private LinearOpMode parent;
    private GyroSensor gyro;
    private double position;

    public GyroThread(LinearOpMode parent, GyroSensor gyro) {
        position = 0;
        this.parent = parent;
    }
}
    /*@Override
    public void run() {
        while (parent.opModeIsActive()){
            UpdatePosition;
        }
    }

    public void UpdatePosition () {
        new time = System.currentTimeMillis();


        sleep(10);
    }

}*/
