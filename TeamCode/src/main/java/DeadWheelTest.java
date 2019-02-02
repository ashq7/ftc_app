import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by AshQuinn on 2/2/19.
 */
@Autonomous(name="DeadWheelTest", group="Test")
public class DeadWheelTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor deadWheel = hardwareMap.dcMotor.get("NW");
        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Position", deadWheel.getCurrentPosition());
            telemetry.update();
        }
    }
}
