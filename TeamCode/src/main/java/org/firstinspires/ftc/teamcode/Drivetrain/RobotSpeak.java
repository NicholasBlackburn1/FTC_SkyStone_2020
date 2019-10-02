package org.firstinspires.ftc.teamcode.Drivetrain;

import android.speech.tts.TextToSpeech;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.w3c.dom.Text;

import java.util.Locale;

public class RobotSpeak extends OpMode {
    public TextToSpeech tts;

    public void Speak_Init(){
        tts = new TextToSpeech(hardwareMap.appContext, null);
        tts.setLanguage(Locale.US);
        tts.speak("Hello world Time to DESTROY WORLD", TextToSpeech.QUEUE_FLUSH, null);
    }

    public void Speek(int mills,int nanos ) throws InterruptedException {
        wait(mills,nanos);
        tts.speak("Big_BRAIN_TIME",TextToSpeech.QUEUE_FLUSH,null);

    }
    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
