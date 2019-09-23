package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.ftccommon.internal.RunOnBoot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Arrays;

/**
 * Init's and Sets each Drive train motors brake mode and control mode
 *
 */

public  class DriveTrain extends OpMode{

    public int Pos = 1120;
    public int turn = 1120*2;

    public void Auto_Stop(){

        MotorPower(0);
        RobotMap.BackL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RobotMap.BackR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Back Drive Motors

        RobotMap.FrontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// Front Drive Motors
        RobotMap.FrontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void init_Auto() {
        RobotMap.BackL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RobotMap.BackR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Back Drive Motors

        RobotMap.FrontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// Front Drive Motors
        RobotMap.FrontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        RobotMap.BackR.setTargetPosition(Pos);
        RobotMap.BackL.setTargetPosition(Pos);
        RobotMap.FrontL.setTargetPosition(Pos);
        RobotMap.FrontR.setTargetPosition(Pos);

        RobotMap.BackL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RobotMap.BackR.setMode(DcMotor.RunMode.RUN_TO_POSITION); // Back Drive Motors

        RobotMap.FrontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);// Front Drive Motors
        RobotMap.FrontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }



    public void MotorPower(int Power){

        // sets motor power
        RobotMap.BackR.setPower(Power);
        RobotMap.BackL.setPower(Power);
        RobotMap.FrontL.setPower(Power);
        RobotMap.FrontR.setPower(Power);

    }


    public void Motor_control(){
        RobotMap.FrontL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Front set of wheels
        RobotMap.FrontR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);

        RobotMap.BackL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Back Set of Wheels s
        RobotMap.BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);

    }

    public void Motor_Strafe_Control(){

            double FrontLeftVal =  gamepad1.left_stick_y - (gamepad1.left_stick_x)  + -gamepad1.right_stick_x;
            double FrontRightVal =  gamepad1.left_stick_y  + (gamepad1.left_stick_x) - -gamepad1.right_stick_x;
            double BackLeftVal = gamepad1.left_stick_y  + (gamepad1.left_stick_x)  + -gamepad1.right_stick_x;
            double BackRightVal = gamepad1.left_stick_y - (gamepad1.left_stick_x) - -gamepad1.right_stick_x;

            //Move range to between 0 and +1, if not already
            double[] wheelPowers = {FrontRightVal, FrontLeftVal, BackLeftVal, BackRightVal};
            Arrays.sort(wheelPowers);
            if (wheelPowers[3] > 1) {
                FrontLeftVal /= wheelPowers[3];
                FrontRightVal /= wheelPowers[3];
                BackLeftVal /= wheelPowers[3];
                BackRightVal /= wheelPowers[3];
            }
            RobotMap.FrontL.setPower(FrontLeftVal);
            RobotMap.FrontR.setPower(FrontRightVal);
            RobotMap.BackL.setPower(BackLeftVal);
            RobotMap.BackR.setPower(BackRightVal);

    }

    public static void Motor_Coast() {
        RobotMap.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RobotMap.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        RobotMap.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RobotMap.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


    }

    public static void Motor_Break(){
        RobotMap.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotMap.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RobotMap.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotMap.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void Strafe_active(){

        if(gamepad1.a == true){
            Motor_Strafe_Control();

        }

    }


    public void Hardwareinit(HardwareMap hardwareMap) {

        RobotMap.BackL = hardwareMap.dcMotor.get("BackL"); // Back set of wheels
        RobotMap. BackR = hardwareMap.dcMotor.get("BackR");
        // enbles imu to be programend in code
        RobotMap. imu = hardwareMap.get(BNO055IMU.class, "imu");

        // Defines Robot Drive motors in Java

        RobotMap.BackL = hardwareMap.dcMotor.get("BackL"); // Back set of wheels
        RobotMap. BackR = hardwareMap.dcMotor.get("BackR");


        RobotMap. FrontL = hardwareMap.dcMotor.get("FrontL"); // Front set of wheels
        RobotMap.FrontR = hardwareMap.dcMotor.get("FrontR");

        RobotMap.FrontR.setDirection(DcMotorSimple.Direction.FORWARD);
        RobotMap.BackL.setDirection(DcMotorSimple.Direction.REVERSE);

        RobotMap.FrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        RobotMap.BackR.setDirection(DcMotorSimple.Direction.FORWARD);

        // Sets Zero Power Action for Drive Motor
        RobotMap.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to Brake mode
        RobotMap.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RobotMap.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotMap.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



    }


    @Override
    public void init() {

    }
    @Override
    public void loop() {
    }
}
