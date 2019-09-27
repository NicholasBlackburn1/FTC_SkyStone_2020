package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@TeleOp(name = "TeleOp-Test_V2",group = "TeleOP")
public class TeleOp_V2 extends OpMode {

    public DcMotor BackL;
    public DcMotor BackR;

    public String helloworld = "hellow world";

    @Override
    public void init() {

        //Defines backL var as Back left robot motor

        BackL = hardwareMap.dcMotor.get("BackL");
        BackR = hardwareMap.dcMotor.get("BackR");

        BackR.setDirection(DcMotorSimple.Direction.FORWARD);
        BackL.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        BackR.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
        BackL.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x);
    }
}
