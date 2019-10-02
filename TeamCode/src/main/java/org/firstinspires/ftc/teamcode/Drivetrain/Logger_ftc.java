package org.firstinspires.ftc.teamcode.Drivetrain;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.vuforia.CameraDevice;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity.TAG;

public class Logger_ftc extends OpMode{
    public Logger Log;

    public void Logger_init() {

        Log.info("**************************************");
        Log.info("* FTC LOGGER ACTIVE BY Nick's Log    *");
        Log.info("**************************************");
    }

    public void Logger_RobotMaping(){
        Log.info("**************************************");
        Log.info("Logging Robot init's");
        Log.info("**************************************");

    }

    @Override
    public void init() {
        
    }

    @Override
    public void loop() {

    }

}

