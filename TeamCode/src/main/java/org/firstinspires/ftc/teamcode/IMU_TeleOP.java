package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Drivetrain.*;

public class IMU_TeleOP extends OpMode {

    DriveTrain driveTrain = new DriveTrain();
    ImuMapper imuMapper = new ImuMapper();

    @Override
    public void init() {

        imuMapper.Init();

    }

    @Override
    public void loop() {

        

    }
}
