package org.firstinspires.ftc.teamcode.Drivetrain;

import java.io.File;
/**
 * Init's Sound Vars and Makes them public 
 */

public class SoundMapper {

    // Sets Sound File path
    public static String soundPath = "/FIRST/blocks/sounds";
    public static File screampath   = new File("/sdcard" + soundPath + "/core_death.wav");
    public static File hellopath = new File("/sdcard" + soundPath + "/hello.wav");
    public static File turretpath = new File("/sdcard" + soundPath + "/fizzel.wav");
    public static File disablepath = new File("/sdcard" + soundPath + "/disable.wav");

}
