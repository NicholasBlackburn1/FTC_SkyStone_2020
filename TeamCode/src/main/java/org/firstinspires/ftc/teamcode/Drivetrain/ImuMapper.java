package org.firstinspires.ftc.teamcode.Drivetrain;
import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Drivetrain.*;

/**
 * Init's and Reads Data form the Integrated  Rev Imu
 */

public class ImuMapper extends OpMode {



    public void Init() {

        // Uses Expansion hub imu to see what axis robot is moving on
        BNO055IMU.Parameters imuParameters;
        imuParameters = new BNO055IMU.Parameters();
        
        // Use degrees as angle unit.
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
       
        // Express acceleration as m/s^2.
        imuParameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        
        // Disable logging.
        imuParameters.loggingEnabled = false;
        
        // Initialize IMU.
        RobotMap.imu.initialize(imuParameters);

        // Prompt user to press start button.
        telemetry.addData("IMU Callabrated","is Callabrated");

    }

    public void ImuData(Telemetry telemetry) {
        // Get absolute orientation
        RobotMap.gravity = RobotMap.imu.getGravity();
        // Get acceleration due to force of gravity.
        RobotMap.angles = RobotMap.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
      


        // Display orientation info.
        telemetry.addData("rot about Z", RobotMap.angles.firstAngle);
        telemetry.addData("rot about Y", RobotMap.angles.secondAngle);
        telemetry.addData("rot about X", RobotMap.angles.thirdAngle);

        telemetry.addData("speed", RobotMap.imu.getAcceleration());
        // updates to screen
        telemetry.update();

    }
    public void init() {

    }


    public void loop() {

    }
}