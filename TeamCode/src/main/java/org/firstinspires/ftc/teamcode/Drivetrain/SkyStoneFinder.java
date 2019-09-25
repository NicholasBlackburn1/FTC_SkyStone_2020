package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

import static org.firstinspires.ftc.robotcore.external.tfod.TfodSkyStone.TFOD_MODEL_ASSET;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.LABEL_FIRST_ELEMENT;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.VUFORIA_KEY;
import static org.firstinspires.ftc.teamcode.Drivetrain.RobotMap.tfod;

public class SkyStoneFinder extends OpMode {

    RobotMap robotMap = new RobotMap();

    public void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */

        robotMap.parameters.vuforiaLicenseKey = VUFORIA_KEY;
        robotMap.parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        //  Instantiate the Vuforia engine
        robotMap.vuforia = ClassFactory.getInstance().createVuforia(robotMap.parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.

    }
    public void initTfod(HardwareMap hardwareMap) {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());

        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minimumConfidence = 0.8;

        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, robotMap.vuforia);
        tfod.loadModelFromAsset(robotMap.TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT,  robotMap.LABEL_SECOND_ELEMENT);
        }

    public void Skystonefinder_INIT(HardwareMap hardwareMap){
        initVuforia();


        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod(hardwareMap);
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

    }
    public void SkyStone_RUN(Telemetry telemetry){



                if (tfod != null) {
                    tfod.activate();
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                    if (updatedRecognitions != null) {
                        telemetry.addData("# Object Detected", updatedRecognitions.size());
                        // step through the list of recognitions and display boundary info.
                        int i = 0;
                        for (Recognition recognition : updatedRecognitions) {
                            telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                            telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                                    recognition.getLeft(), recognition.getTop());
                            telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                                    recognition.getRight(), recognition.getBottom());

                            // Prints out (X,Y) Calulated by X2-X1 and Y2-Y1 to find center of images

                            telemetry.addData("delta x",recognition.getRight() - recognition.getLeft());
                            telemetry.addData("delta Y",recognition.getTop() - recognition.getBottom());
                        }
                        telemetry.update();

                    }
                }
        }
    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
    @Override
    public void stop(){

        tfod.deactivate();
    }
}