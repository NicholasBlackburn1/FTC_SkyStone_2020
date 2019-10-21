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

        intake_Control.Winch_Control(gamepad2); // Controls The scissor lift movement with the winch using Trigger buttons on gamepad2

        intake_Control.Carriage_control(gamepad2); // Controls The Liner control for the  scissor lift carriage

        while(gamepad1.a = true){ // conditional statement to enable strafe on driver controller

            drivetrain.Motor_Strafe_Control(gamepad1); // Enables us to strafe while the gamepad1 button a is presses
            
        }
    }
}
