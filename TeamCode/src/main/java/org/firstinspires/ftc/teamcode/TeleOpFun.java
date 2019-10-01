package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;

@TeleOp(name = "TeleOP_Strafe",group = "TeleOp")
public class TeleOpFun extends OpMode {

    DriveTrain driveTrain = new DriveTrain();

    @Override
    public void init() {
        // Init's all drive train hardware
        driveTrain.Hardwareinit(hardwareMap);



    }

    @Override
    public void loop() {

        driveTrain.Motor_control(gamepad1);


    }
