package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.teamcode.Drivetrain.*;

public class Skeltion_Code extends OpMode
{
    DriveTrain drivetrain = new DriveTrain();

    @Override
    public void init() {
    drivetrain.Hardwareinit(hardwareMap); //init hardware for robot



    }

    @Override
    public void loop() {

    }
}
