package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.DcMotor;


import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;

import org.firstinspires.ftc.ftccommon.internal.RunOnBoot;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.usb.exception.RobotUsbDeviceClosedException;
import org.firstinspires.ftc.robotcore.internal.usb.exception.RobotUsbException;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * Init's and Sets each Drive train motors brake mode and control mode for each defined in the Robotmap class
 *
 */

public class DriveTrain extends OpMode{

  

    public void Auto_Stop(){

        MotorPower(0);
        RobotMap.BackL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RobotMap.BackR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Back Drive Motors

        RobotMap.FrontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// Front Drive Motors
        RobotMap.FrontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       
    }



    public void init_Auto(int Pos, Telemetry telemetry) {

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


    public void Motor_control(Gamepad gamepad1) {
        
        // Uses Driver controller to set the power of the Drivetrain motors
        RobotMap.FrontL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Front set of wheels
        RobotMap.FrontR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);

        RobotMap.BackL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Back Set of Wheels s
        RobotMap.BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
       
    }

    public void Motor_Strafe_Control(Gamepad gamepad1){

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

    public void Motor_Coast() {
        // Sets Zero power mode for all the Drive train Motors -> Float mode 
        RobotMap.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RobotMap.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        RobotMap.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        RobotMap.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        


    }

    public void Motor_Break() {
        // Sets Zero power mode for all the Drive train Motors -> Break mode 
        RobotMap.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotMap.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RobotMap.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotMap.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void Hardwareinit(HardwareMap hardwareMap) {
     
        // Defines Robot Drive motors  and maps them to Robot Controllers hardware config
        RobotMap.BackL = hardwareMap.dcMotor.get("BackL"); // Back set of wheels
        RobotMap.BackR = hardwareMap.dcMotor.get("BackR");
           
        RobotMap.FrontL = hardwareMap.dcMotor.get("FrontL"); // Front set of wheels
        RobotMap.FrontR = hardwareMap.dcMotor.get("FrontR");
           
        // Defines winch motor for scissor lift
        RobotMap.Winch = hardwareMap.dcMotor.get("Winch");
           
        // Defines  Liner extension control for Scissor lift
        RobotMap.Vex_Extension = hardwareMap.get(Servo.class, "extend");

        // Defines Inertial measurement unit for Exact measurement of robot in space  
        RobotMap.imu = hardwareMap.get(BNO055IMU.class, "imu");

       

        //  Sets Direction of Linier extension servo motor   
        RobotMap.Vex_Extension.setDirection(Servo.Direction.FORWARD);

        // Sets Run direction Of the Drivetrain Motors
        RobotMap.FrontR.setDirection(DcMotorSimple.Direction.FORWARD);
        RobotMap.BackL.setDirection(DcMotorSimple.Direction.REVERSE);
        
        RobotMap.FrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        RobotMap.BackR.setDirection(DcMotorSimple.Direction.FORWARD);

         // Sets Drive Direction of Winch control motor
        RobotMap.Winch.setDirection(DcMotorSimple.Direction.REVERSE);

        // Sets Zero Power Action for Drive Motor
        RobotMap.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to Brake mode
        RobotMap.FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RobotMap.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RobotMap.BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

         // Sets Winch Zero Power Mode to Brake mode 
        RobotMap.Winch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



    }
    @Override
    public void init() {

    }
    @Override
    public void loop() {
    }
}
