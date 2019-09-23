package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Drivetrain.SkyStoneFinder;

@TeleOp(name = "Tensorflow skystone rec",group = "TeleOP")
public class SkyStoneLocator extends OpMode {

     SkyStoneFinder stoneFinder = new SkyStoneFinder();

    @Override
    public void init() {
        // Inits vuforia and tenserfo
        stoneFinder.Skystonefinder_INIT(hardwareMap);


    }

    @Override
    public void loop() {

        stoneFinder.SkyStone_RUN(telemetry);

    }
    @Override
    public void stop(){
        stoneFinder.stop();
    }
}
