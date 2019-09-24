package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Drivetrain.*;

@Autonomous(name = "Sample_Encoder",group = "Auto")
public class Encoder_Driver extends OpMode {

    private DriveTrain drive = new DriveTrain();

    @Override
    public void init() {

        // init main motor config
        drive.Hardwareinit(hardwareMap);
        // init motors for Auto
        drive.init_Auto();

    }

    @Override
    public void loop() {


        drive.MotorPower(1);

        //Prints out Drive Motors Position from encoders
        telemetry.addData("BACK L pos", RobotMap.BackL.getCurrentPosition());
        telemetry.addData("BACK R pos", RobotMap.BackR.getCurrentPosition());
        telemetry.addData("FRONT L POS", RobotMap.FrontL.getCurrentPosition());
        telemetry.addData("FRONT R POS", RobotMap.FrontR.getCurrentPosition());




        if (RobotMap.BackR .getCurrentPosition() == 1120){

            drive.Auto_Turn();
        }
    }

    @Override
    public void stop(){

        drive.Auto_Stop();
    }
}
