package org.firstinspires.ftc.teamcode.Learning;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "TeleOp-Test_V2",group = "TeleOP")
public class TeleOp_V2 extends OpMode {

    public DcMotor BackL;
    public DcMotor BackR;
    public DcMotor FrontL;
    public DcMotor FrontR;

    public Servo  Servo1;

    public String helloworld = "hellow world";

    @Override
    public void init() {

        //Defines backL var as Back left robot motor

        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");
        FrontL = hardwareMap.dcMotor.get("FrontL"); // Front set of wheels
        FrontR = hardwareMap.dcMotor.get("FrontR");

        Servo1 = hardwareMap.servo.get("servo1");

        // Sets Robot's Motor Direction

        Servo1.setDirection(Servo.Direction.FORWARD);

        FrontR.setDirection(DcMotorSimple.Direction.FORWARD);
        BackL.setDirection(DcMotorSimple.Direction.REVERSE);

        FrontL.setDirection(DcMotorSimple.Direction.REVERSE);
        BackR.setDirection(DcMotorSimple.Direction.FORWARD);

    }

    @Override
    public void loop() {
        // Calulates joysticks Pos and uses that input to drive motor power

        FrontL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Front set of wheels
        FrontR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);

        BackL.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x); // Back Set of Wheels s
        BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);

        // if Statement that controls Servo motor by pressing The a button
        if (gamepad1.a = true){

            Servo1.setPosition(180);
        }
        else {
            Servo1.setPosition(0);
        }

    }
}
