package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.RobotMap;
@Autonomous(name = "Nicks testauto", group = "Auto")
public class Test_Auto extends OpMode {

    DriveTrain driveTrain = new DriveTrain();
    RobotMap robotMap = new RobotMap();

    @Override
    public void init() {
        driveTrain.Hardwareinit(hardwareMap);

        driveTrain.init_Auto(1120,telemetry);

    }

    @Override
    public void loop() {
        driveTrain.MotorPower(1);

        if(RobotMap.BackR.getCurrentPosition() == 1220){


            RobotMap.BackR.setTargetPosition(0);
            RobotMap.BackL.setTargetPosition(2240);
            RobotMap.FrontL.setTargetPosition(2240);
            RobotMap.FrontR.setTargetPosition(0);


            driveTrain.MotorPower(1);

        }

    }
}
