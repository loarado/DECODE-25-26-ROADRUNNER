package org.firstinspires.ftc.teamcode.CompCode.SubsytemsAndDriveSetup;
import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

// Non-RR imports
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

public class Loader {
    public CRServo loaderright;
    public CRServo loaderleft;

    public void init(HardwareMap hardwareMap){
        loaderright = hardwareMap.get(CRServo.class, ("Right Loader"));
        loaderright.setDirection(CRServo.Direction.REVERSE);
        loaderleft = hardwareMap.get(CRServo.class, ("Left Loader"));
    }



    public class loadOn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet){
            loaderright.setPower(1);
            loaderleft.setPower(1);
            return false;

        }
    }
    public Action loadOn() { return new loadOn(); }

    public class loadOff implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet){
            loaderright.setPower(0);
            loaderleft.setPower(0);
            return false;
        }

    }
    public Action loadOff() { return new loadOff();}

    public void on(){
        loaderleft.setPower(1);
        loaderright.setPower(1);
    }
    public void off(){
        loaderleft.setPower(0);
        loaderright.setPower(0);
    }
}

