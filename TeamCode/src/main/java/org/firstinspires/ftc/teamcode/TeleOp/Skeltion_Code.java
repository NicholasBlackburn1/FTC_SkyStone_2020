package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Drivetrain.*;

public class Skeltion_Code extends OpMode
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

        if(gamepad1.a = true){ 

            drivetrain.Motor_Strafe_Control(gamepad1); // Enables us to strafe while the gamepad1 button a is presses

        }
    }
}
