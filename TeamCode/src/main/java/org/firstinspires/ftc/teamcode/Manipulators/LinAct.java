package org.firstinspires.ftc.teamcode.Manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by AshQuinn on 11/9/18.
 */

public class LinAct {
    public DcMotor linAct;
    double Power = 0.5;
    public HardwareMap hardwareMap;
    public LinAct (HardwareMap HWMap){
        hardwareMap = HWMap;
    }
    public void init () {
        linAct = hardwareMap.dcMotor.get("linAct");
    }

    public void extend() {
        linAct.setPower(Power);
    }
    public void retract() {
        linAct.setPower(-Power);
    }
    public void stop () {
        linAct.setPower(0);
    }
}
