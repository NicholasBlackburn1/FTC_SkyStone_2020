package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.hardware.DigitalChannel;

public class DigitalSensors {

    public static void Init(){

        RobotMap.button.setMode(DigitalChannel.Mode.INPUT);
    }
}
