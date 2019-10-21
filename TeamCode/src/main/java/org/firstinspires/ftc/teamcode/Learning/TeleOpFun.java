package org.firstinspires.ftc.teamcode.Learning;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.RobotSpeak;

@TeleOp(name = "TeleOP_Strafe",group = "TeleOp")

public class TeleOpFun extends OpMode {

    DriveTrain driveTrain = new DriveTrain();
    RobotSpeak robotSpeak = new RobotSpeak();



    @Override
    public void init() {
        // Init's all drive train hardware

        driveTrain.Hardwareinit(hardwareMap);



    }

    @Override
    public void loop() {
        // regular drive control
        driveTrain.Motor_control(gamepad1);

        // Enables you to strafe while button a on gampad1 is held down

    }
}
