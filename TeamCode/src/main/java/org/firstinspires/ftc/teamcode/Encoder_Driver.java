package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Drivetrain.*;

@Autonomous(name = "Sample_Encoder",group = "Auto")
public class Encoder_Driver extends OpMode {

    int turn = 1120 *4;
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


            RobotMap.BackL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RobotMap.BackR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Back Drive Motors

            RobotMap.FrontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// Front Drive Motors
            RobotMap.FrontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


            // Sets turn Target pos
            RobotMap.BackR.setTargetPosition(turn);
            RobotMap.BackL.setTargetPosition(0);
            RobotMap.FrontL.setTargetPosition(0);
            RobotMap.FrontR.setTargetPosition(turn);

            RobotMap.BackL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RobotMap.BackR.setMode(DcMotor.RunMode.RUN_TO_POSITION); // Back Drive Motors

            RobotMap.FrontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);// Front Drive Motors
            RobotMap.FrontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            RobotMap.BackR.setPower(1);
            RobotMap.BackL.setPower(0);
            RobotMap.FrontL.setPower(0);
            RobotMap.FrontR.setPower(1);
        }
    }

    @Override
    public void stop(){

        drive.Auto_Stop();
    }
}
