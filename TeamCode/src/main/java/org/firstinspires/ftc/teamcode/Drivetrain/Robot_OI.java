package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class Robot_OI extends OpMode {

    public void init() {
        // enbles imu to be programend in code
        RobotMap.imu = hardwareMap.get(BNO055IMU.class, "imu");

        // Defines Robot Drive motors in Java

        RobotMap.BackL = hardwareMap.dcMotor.get("BackL"); // Back set of wheels
        RobotMap.BackR = hardwareMap.dcMotor.get("BackR");

        RobotMap.FrontL = hardwareMap.dcMotor.get("FrontL"); // Front set of wheels
        RobotMap.FrontR = hardwareMap.dcMotor.get("FrontR");
    }


    public void loop() {

    }
}
