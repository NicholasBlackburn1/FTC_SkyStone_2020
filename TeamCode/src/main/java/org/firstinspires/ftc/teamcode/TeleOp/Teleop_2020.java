package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Drivetrain.*;

@TeleOp(name = "Teleop2020",group = "TeleOp")

public class Teleop_2020 extends OpMode
{
    // Calls DriveTrain Method to be used in our Teleop Code 
    DriveTrain drivetrain = new DriveTrain();
    IntakeControl intake_Control = new IntakeControl(); 

    @Override
    public void init() {

    drivetrain.Hardwareinit(hardwareMap); //init hardware for robot
    
    

    }


    @Override
    public void loop() {

        drivetrain.Motor_control(gamepad1); // controls regular driving for robot controls


        drivetrain.Motor_Strafe_Control(gamepad1,telemetry); // Enables us to strafe while the gamepad1 while bumpers are presses

        drivetrain.Hooking(gamepad1,telemetry); // Independetly controls robot hooks useing gamepad1 triggers



    }
}
