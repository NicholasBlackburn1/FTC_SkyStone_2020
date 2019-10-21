package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;

public class Auto_2020 extends OpMode {

    DriveTrain driveTrain = new DriveTrain();

    @Override
    public void init() {

        driveTrain.Hardwareinit(hardwareMap); //init hardware for robot

        driveTrain.init_Auto(4000,telemetry);// sets encoder pos

    }

    @Override
    public void loop() {

        driveTrain.MotorPower(1);  //sets robot

    }
}
