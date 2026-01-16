package org.firstinspires.ftc.teamcode.CompCode.SubsytemsAndDriveSetup;

import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

// Non-RR imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class Launcher {

    public DcMotorEx launcher;

    public void init(HardwareMap hardwareMap){

        launcher = hardwareMap.get(DcMotorEx.class, ("launcher"));
        launcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        launcher.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


       /* PIDFCoefficients pidfCoefficients = new PIDFCoefficients(170,0,0,12.9);
        launcher.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);*/
    }


    public class launchOn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet){
            /*change to launcher.setVelocity*/
            launcher.setVelocity(2060);
            return false;

        }
    }
    public Action launchOn(){
        return new launchOn();
    }
    public class launchOff implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet){
            launcher.setVelocity(0);
            return false;
        }
    }
    public Action launchOff() {return new launchOff();}

    public void on() {
        launcher.setVelocity(2060);
    }

    public void off() {
        launcher.setVelocity(0);
    }

    public double getVelocity(){
        double velocity = launcher.getVelocity();
        return velocity;
    }
}
//can you rewrite the opmode code to use this new launcher class