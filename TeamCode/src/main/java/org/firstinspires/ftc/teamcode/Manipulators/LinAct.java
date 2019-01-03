package org.firstinspires.ftc.teamcode.Manipulators;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by AshQuinn on 11/9/18.
 */

public class LinAct {
    public DcMotor linAct;
    double Power = 0.5;
    int Retract = 0;
    int Extend = 3000;
    public HardwareMap hardwareMap;
    public LinAct (HardwareMap HWMap){
        hardwareMap = HWMap;
    }
    public void init () {
        linAct = hardwareMap.dcMotor.get("linAct");
        linAct.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Retract = linAct.getCurrentPosition();
        Extend = Retract + Extend;
        retract();
        linAct.setPower(Power);
    }

    public void extend() {
        linAct.setTargetPosition(Extend);
    }
    public void retract() {
        linAct.setTargetPosition(Retract);
    }
    public boolean atTarget() {
        return Math.abs(linAct.getTargetPosition() - linAct.getCurrentPosition())< 5;
    }
}
