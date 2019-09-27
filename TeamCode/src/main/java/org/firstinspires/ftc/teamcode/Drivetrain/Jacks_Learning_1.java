package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Jack_test_1",group = "TeleOp") //sets this code to when teleop mode is activated - "TeleOp" is on the phone - "Jacks_test_1" is name of program on phone

public class Jacks_Learning_1 extends OpMode {

    //Define variables here

    public DcMotor BackL;
    public DcMotor BackR;
    public DcMotor FrontL;
    public DcMotor FrontR;


    @Override
    public void init() {
        //Initialize means run programs once

        BackL = hardwareMap.dcMotor.get("BackL"); //this defines the variable BackL to the BackL port on the robot
        //BackL is variable we defined earlier, hardwareMap.dcmotor is defining it as a physical motor, the "BackL" motor on the robot
        BackR = hardwareMap.dcMotor.get("BackR"); //this defines the variable BackR to the BackR port on the robot

        //next you need to define motor direction - one side will be reversed, because the motors are flipped

        BackL.setDirection(DcMotorSimple.Direction.FORWARD); //setting BackL to simple direction forward
        BackR.setDirection(DcMotorSimple.Direction.REVERSE); //setting BackR to simple direction reverse

        FrontL.setDirection(DcMotorSimple.Direction.FORWARD); //setting the FrontL to forward
        FrontR.setDirection(DcMotorSimple.Direction.REVERSE); //setting the FrontR to reverse

    }

    @Override
    public void loop() {
        //loop runs programs over and over

        //set the controller values to the motors

        FrontL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); //setting the back motors to the power the controller joystick relays
        FrontR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);

        BackL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); //setting the back motors to the power the controller joystick relays
        BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);


    }
}
//strings are variables that complete data tasks ex) saying "hello world" or finding centerpoints