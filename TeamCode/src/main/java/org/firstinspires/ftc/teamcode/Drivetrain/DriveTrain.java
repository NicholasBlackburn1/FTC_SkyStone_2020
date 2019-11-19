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

import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.BackL;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.BackR;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.FrontL;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.FrontR;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.HookL;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.HookR;

/**
 * Init's and Sets each Drive train motors brake mode and control mode for each defined in the Robotmap class
 *
 */

public class DriveTrain extends OpMode{

  

    public void Auto_Stop(){

        MotorPower(0);
        BackL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RobotMap.BackR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Back Drive Motors

        FrontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// Front Drive Motors
        RobotMap.FrontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       
    }



    public void init_Auto(int Pos, Telemetry telemetry) {

        BackL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RobotMap.BackR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER); // Back Drive Motors
        
        FrontL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// Front Drive Motors
        RobotMap.FrontR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();
        

            RobotMap.BackR.setTargetPosition(Pos);
            BackL.setTargetPosition(Pos);
            FrontL.setTargetPosition(Pos);
            RobotMap.FrontR.setTargetPosition(Pos);

        BackL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RobotMap.BackR.setMode(DcMotor.RunMode.RUN_TO_POSITION); // Back Drive Motors

        FrontL.setMode(DcMotor.RunMode.RUN_TO_POSITION);// Front Drive Motors
        RobotMap.FrontR.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }



    public void MotorPower(int Power){

        // sets motor power
        RobotMap.BackR.setPower(Power);
        BackL.setPower(Power);
        FrontL.setPower(Power);
        RobotMap.FrontR.setPower(Power);

    }


    public void Motor_control(Gamepad gamepad1) {
        
        // Uses Driver controller to set the power of the Drivetrain motors
        FrontL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Front set of wheels
        RobotMap.FrontR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);

        BackL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Back Set of Wheels s
        RobotMap.BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
       
    }

    public void Motor_Strafe_Control(Gamepad gamepad1, Telemetry telemetry) {




        if (gamepad1.right_bumper == true) {

            telemetry.addData("Strafing right","true");

            BackR.setPower(1);
            BackL.setPower(-1);
            FrontR.setPower(-1);
            FrontL.setPower(1);
            Motor_Coast();
        } else {
            telemetry.addData("Strafing right","false");
        }

        if (gamepad1.left_bumper == true) {

            telemetry.addData("Strafing left","true");

            BackR.setPower(-1);
            BackL.setPower(1);
            FrontR.setPower(1);
            FrontL.setPower(-1);
            Motor_Coast();

        } else{
            telemetry.addData("Strafing left","false");
        }
    }
        



    public void Motor_Coast() {
        // Sets Zero power mode for all the Drive train Motors -> Float mode 
        FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        


    }

    public void Motor_Break() {
        // Sets Zero power mode for all the Drive train Motors -> Break mode 
        FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void Hardwareinit(HardwareMap hardwareMap) {
     
        // Defines Robot Drive motors  and maps them to Robot Controllers hardware config
        BackL = hardwareMap.dcMotor.get("BackL"); // Back set of wheels
        BackR = hardwareMap.dcMotor.get("BackR");
           
        FrontL = hardwareMap.dcMotor.get("FrontL"); // Front set of wheels
        FrontR = hardwareMap.dcMotor.get("FrontR");

        // Hooks / claws for picking up  stones
        HookL = hardwareMap.servo.get("HookL");
        HookR = hardwareMap.servo.get("HookR");
           
        // Defines winch motor for scissor lift
        RobotMap.Winch = hardwareMap.dcMotor.get("Winch");

        // Defines Inertial measurement unit for Exact measurement of robot in space  
        RobotMap.imu = hardwareMap.get(BNO055IMU.class, "imu");

       

        //  Sets Direction of Linier extension servo motor   
       // RobotMap.Vex_Extension.setDirection(Servo.Direction.FORWARD);

        // Sets Run direction Of the Drivetrain Motors
        RobotMap.FrontR.setDirection(DcMotorSimple.Direction.FORWARD);
        BackL.setDirection(DcMotorSimple.Direction.REVERSE);
        
        FrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        RobotMap.BackR.setDirection(DcMotorSimple.Direction.FORWARD);

         // Sets Drive Direction of Winch control motor
        //RobotMap.Winch.setDirection(DcMotorSimple.Direction.REVERSE);

        // Sets Zero Power Action for Drive Motor
        RobotMap.FrontR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Set to Brake mode
        FrontL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RobotMap.BackR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
        public void Hooking(Gamepad gamepad1, Telemetry telemetry){

        if(gamepad1.a == true){
            telemetry.addData("Hooks","all lower true");

            HookL.setPosition(-gamepad1.right_trigger);
            HookR.setPosition(gamepad1.right_trigger);

        }else{

            telemetry.addData("Hooks","all lower false");

        }
        if(gamepad1.x == true){
            telemetry.addData("Hooks","independent true");

            telemetry.addData("HookL",HookL.getPosition());
            telemetry.addData("HookR",HookR.getPosition());

            HookL.setPosition(-gamepad1.left_trigger);
            HookR.setPosition(gamepad1.right_trigger);


        }else{

            telemetry.addData("Hooks","independent false");
        }

        }
    @Override
    public void init() {

    }
    @Override
    public void loop() {
    }
}
