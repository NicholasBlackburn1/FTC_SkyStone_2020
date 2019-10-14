package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Drivetrain.*;

@TeleOp(name = "IMU TES ",group = "Teleop")
public class IMU_TeleOP extends OpMode {

    DriveTrain driveTrain = new DriveTrain();
    ImuMapper imuMapper = new ImuMapper();

    @Override
    public void init() {
        driveTrain.Hardwareinit(hardwareMap);
        imuMapper.Init();

    }

    @Override
    public void loop() {
        imuMapper.ImuData(telemetry);
    }
}
