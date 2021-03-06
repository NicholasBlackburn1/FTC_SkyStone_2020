package org.firstinspires.ftc.teamcode.Learning;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.RobotMap;

@Autonomous(name = "Sample_Encoder",group = "Auto")
public class Encoder_Driver extends OpMode {

    int turn = 1120 *3;
    private DriveTrain drive = new DriveTrain();

    @Override
    public void init() {

        // init main motor config
        drive.Hardwareinit(hardwareMap);
        // init motors for Auto
        drive.init_Auto(1120,telemetry);

    }

    @Override
    public void loop() {


        drive.MotorPower(1);

        //Prints out Drive Motors Position from encoders
        telemetry.addData("BACK L pos", RobotMap.BackL.getCurrentPosition());
        telemetry.addData("BACK R pos", RobotMap.BackR.getCurrentPosition());
        telemetry.addData("FRONT L POS", RobotMap.FrontL.getCurrentPosition());
        telemetry.addData("FRONT R POS", RobotMap.FrontR.getCurrentPosition());



            if (RobotMap.BackR.getCurrentPosition() == 4478) {


                // Sets turn Target pos
                RobotMap.BackR.setTargetPosition(turn);
                RobotMap.BackL.setTargetPosition(turn);
                RobotMap.FrontL.setTargetPosition(turn);
                RobotMap.FrontR.setTargetPosition(turn);

                RobotMap.BackL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                RobotMap.BackR.setMode(DcMotor.RunMode.RUN_TO_POSITION); // Back Drive Motors

                RobotMap.FrontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);// Front Drive Motors
                RobotMap.FrontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                RobotMap.BackR.setPower(1);
                RobotMap.BackL.setPower(1);
                RobotMap.FrontL.setPower(1);
                RobotMap.FrontR.setPower(1);

            }
        drive.MotorPower(0);

        }


    @Override
    public void stop(){

        drive.Auto_Stop();
    }
}
