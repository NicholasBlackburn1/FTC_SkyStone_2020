package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.RobotMap;

@TeleOp(name = "TeleOP_Strafe",group = "TeleOp")
public class TeleOpFun extends OpMode {

    DriveTrain driveTrain = new DriveTrain();
    RobotMap robotMap = new RobotMap();


    @Override
    public void init() {
        // Init's all drive train hardware
        driveTrain.Hardwareinit(hardwareMap);

        RobotMap.button.setMode(DigitalChannel.Mode.INPUT);

    }

    @Override
    public void loop() {

        driveTrain.Motor_control(gamepad1);

        if(RobotMap.button.getState() == true){
            telemetry.addData("BIG BRAIN TIME","BIG TIME");
        }


    }
}
