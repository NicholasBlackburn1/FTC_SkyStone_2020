package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.robot.Robot;


public  class IntakeControl extends OpMode {


    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }

    // controls scissor Lift winch to move scissor up and down
    public void Winch_Control(Gamepad gamepad2){

        // Extends scissor lift up with controlled right trigger
        RobotMap.Winch.setPower(gamepad2.right_trigger);

        // ReTracts scissor lift down with left trigger
        RobotMap.Winch.setPower(-gamepad2.left_trigger);

    }

    // Controls Liner Motion on Carriage to grab / Place Stones
    public void Carriage_control(Gamepad gamepad2){

        // sets Vex cr servo pos
        if(gamepad2.a = true){
            // sets servo to pos 225
            RobotMap.Vex_Extension.setPosition(255);
        }
        else{
            RobotMap.Vex_Extension.setPosition(0);
        }


    }
}
