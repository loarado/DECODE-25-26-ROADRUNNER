package org.firstinspires.ftc.teamcode.MEET_1_AUTO;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

// Non-RR imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import java.time.OffsetDateTime;

public class Launcher {

    public DcMotorEx launcher;

    Launcher(HardwareMap hardwareMap){

        launcher = hardwareMap.get(DcMotorEx.class, ("launcher"));
        launcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launcher.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    public class launchOn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet){
            launcher.setPower(.55);
            return false;

        }
    }
    public Action launchOn(){
        return new launchOn();
    }
    public class launchOff implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet){
            launcher.setPower(0);
            return false;
        }
    }
    public Action launchOff() {return new launchOff();}

}
