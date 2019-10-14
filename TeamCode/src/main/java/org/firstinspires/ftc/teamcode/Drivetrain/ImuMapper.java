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

/**
 * Init's and Reads Data form the Integrated  Rev Imu
 */
public class ImuMapper extends OpMode {

    public static Orientation angles;
    public static Acceleration gravity;


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
        // Prompt user to press start buton.
         telemetry.addData("IMU Callabrated","is Callabrated");

    }

    public void ImuData(Telemetry telemetry) {
        // Get absolute orientation
        // Get acceleration due to force of gravity.
        angles = RobotMap.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        gravity =RobotMap.imu.getGravity();

        // Display orientation info.
        telemetry.addData("rot about Z", angles.firstAngle);
        telemetry.addData("rot about Y", angles.secondAngle);
        telemetry.addData("rot about X", angles.thirdAngle);
        telemetry.addData("speed",RobotMap.imu.getAcceleration());
        // updates to screen
        telemetry.update();


        // if robot falls over than plays this file
        if (angles.secondAngle < -70.625) {


        }

            if (angles.secondAngle != -74.625) {

            }
        }




    public void init() {

    }


    public void loop() {

    }
}