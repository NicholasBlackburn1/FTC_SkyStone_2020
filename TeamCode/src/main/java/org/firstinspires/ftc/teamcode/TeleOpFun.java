package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.RobotMap;
import org.firstinspires.ftc.teamcode.Drivetrain.RobotSpeak;

@TeleOp(name = "TeleOP_Strafe",group = "TeleOp")
public class TeleOpFun extends OpMode {

    DriveTrain driveTrain = new DriveTrain();
    RobotSpeak robotSpeak = new RobotSpeak();


    @Override
    public void init() {
        // Init's all drive train hardware
        driveTrain.Hardwareinit(hardwareMap);
        robotSpeak.Speak_Init();
    }

    @Override
    public void loop() {

        driveTrain.Motor_control(gamepad1);

        if(RobotMap.button.getState() == true){


            try {
                
                // Makes robot say big brain time
                robotSpeak.Speek(50,1);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }


    }
}
