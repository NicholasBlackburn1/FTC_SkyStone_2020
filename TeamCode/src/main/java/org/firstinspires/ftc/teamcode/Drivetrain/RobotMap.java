package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.io.File;

/**
 * Maps out the Motors,Sensors Vars and FilePaths to be used in Robot OP_Modes
 */
public class RobotMap {

    // Drive Train Motors
    public static DcMotor BackR;
    public static DcMotor BackL;
    public static DcMotor FrontR;
    public static DcMotor FrontL;


    // Intake Motor
    public static DcMotor Intake;

    // Sensor inputs 
    public static BNO055IMU imu;
    public static DigitalChannel button;


}
