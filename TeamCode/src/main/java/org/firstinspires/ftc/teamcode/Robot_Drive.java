package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.ImuMapper;
import org.firstinspires.ftc.teamcode.Drivetrain.Robot_OI;

public class Robot_Drive extends OpMode {

    private static Robot_OI oi = new Robot_OI();
    private static DriveTrain driveTrain = new DriveTrain();
    private static ImuMapper Imu = new ImuMapper();

    @Override
    public void init() {

        oi.init();

        Imu.init();

        driveTrain.init();
    }

    @Override
    public void loop() {

        driveTrain.Motor_control();

        Imu.ImuData();

    }
}
