package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Pid_Controller extends OpMode {

    PIDFCoefficients pidCoefficients = new PIDFCoefficients();

    public void PID_input(){
    pidCoefficients.p = 0;
    pidCoefficients.i = 0;
    pidCoefficients.d = 0;
    pidCoefficients.f = 0;


    }

    public void PID_OUTPUT(){

    }


    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
