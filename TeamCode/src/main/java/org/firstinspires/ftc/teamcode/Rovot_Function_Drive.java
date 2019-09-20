package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Drivetrain.DriveTrain;
import org.firstinspires.ftc.teamcode.Drivetrain.Robot_OI;

public class Rovot_Function_Drive extends OpMode {

    private static DriveTrain driveTrain = new DriveTrain();
    private static Robot_OI oi = new Robot_OI();

    @Override
    public void init() {

        driveTrain.init();
    }

    @Override
    public void loop() {

    }
}
