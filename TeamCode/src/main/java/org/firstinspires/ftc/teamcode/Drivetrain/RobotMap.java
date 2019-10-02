package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

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

    // Servo Motors
    public static Servo Servo1;
    public static Servo Servo2;

    // Sensor inputs
    public static BNO055IMU imu;
    public static DigitalChannel button;


    // Vuforia
    public static final String VUFORIA_KEY = "AfqrfAP/////AAABmbpuXhZBNUQwn1VZRlAAkjZyl/zIGqLIpcM+FSLaiHSsg7e2qHZDDAo2CFSDYXTxu/Zxp1hlDatILth7lcj9XX8murMllglToHb0078rANa/Vs4W1WKWObjC+tTeRi/icnNXPbv2APvIs0b8hYGV3fI3njZrXF/mm0u3uFYGZVFBQxWr6Ef/naDoxlrGFPNAR/7yxsnRBrWSlie6i9h19VjoXdu/Rf8gE72CwvXJYy9+DKbN12MlxdRmJx9U71p1SI4sZBY7yTTG0W/4UGEn4v4Nh86conA8o9aMe4/2wm4rGKJ8J75zr2+iubOf80cqvfU30D2dD3Vq95qy4EM+160iMKRKzS41UNZBFYrZayTN";
    public static VuforiaLocalizer vuforia;
    public VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

    // Tensorflow
    public static final String TFOD_MODEL_ASSET = "Skystone.tflite";
    public static final String LABEL_FIRST_ELEMENT = "Stone";
    public static final String LABEL_SECOND_ELEMENT = "Skystone";
    public static TFObjectDetector tfod;

}
