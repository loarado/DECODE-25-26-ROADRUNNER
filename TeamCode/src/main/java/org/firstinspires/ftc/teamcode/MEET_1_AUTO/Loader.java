package org.firstinspires.ftc.teamcode.MEET_1_AUTO;
import androidx.annotation.NonNull;

// RR-specific imports
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

// Non-RR imports
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.hardware.ServoControllerEx;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
public class Loader {
    public CRServo loaderright;
    public CRServo loaderleft;

    Loader(HardwareMap hardwareMap){
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
}

