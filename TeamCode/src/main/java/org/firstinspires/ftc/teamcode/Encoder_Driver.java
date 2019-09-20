package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.RobotMap;

@Autonomous(name = "Sample_Encoder",group = "Auto")
public class Encoder_Driver extends OpMode {

     private DriveTrain drive = new DriveTrain();


    @Override
    public void init() {

        // init main motor config
        drive.init();

        // init motors for Auto
        drive.init_Auto();
    }

    @Override
    public void loop() {

        drive.EncoderRun(1120);

        drive.MotorPower(1);

        // reads motor tick
        drive.AutoLOOP();


    }

    @Override
    public void stop(){

        drive.Auto_Stop();
    }
}
