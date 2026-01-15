package org.firstinspires.ftc.teamcode.tuning;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp

public class FlywheelPIDFTuning extends OpMode {
    public DcMotorEx flyWheelMotor;
    public double highVelocity = 1620;
    public double lowVelocity = 900;

    double curTargetVelocity = highVelocity;

    double F = 0;
    double P = 0;

    double[] stepSizes = {10, 1, .1, .001, .0001};
    int stepIndex = 1;






    @Override
    public void init() {
        flyWheelMotor = hardwareMap.get(DcMotorEx.class,"launcher");
        flyWheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flyWheelMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);




    }


    @Override
    public void loop() {

        if (gamepad1.yWasPressed()){
            if (curTargetVelocity == highVelocity){
                curTargetVelocity = lowVelocity;
            }
            else {
                curTargetVelocity = highVelocity;
            }
        }

        if (gamepad1.bWasPressed()){
            stepIndex = (stepIndex + 1) % stepSizes.length;
        }

        if (gamepad1.dpadRightWasPressed()){
            F += stepSizes[stepIndex];
        }
        if (gamepad1.dpadLeftWasPressed()){
            F -= stepSizes[stepIndex];
        }
        if (gamepad1.dpadUpWasPressed()){
            P += stepSizes[stepIndex];
        }
        if (gamepad1.dpadDownWasPressed()){
            P -= stepSizes[stepIndex];
        }

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P, 0, 0, F);
        flyWheelMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);

        flyWheelMotor.setVelocity(curTargetVelocity);
        double curVelocity = flyWheelMotor.getVelocity();
        double error = curTargetVelocity-curVelocity;

        telemetry.addData("Target Velocity", curTargetVelocity);
        telemetry.addData("Current Velocity","%.2f", curVelocity );
        telemetry.addData("Error", "%.2f", error);
        telemetry.addLine("-------------------------------");
        telemetry.addData("Tuning P", "%.4f (D-PadU/D)",P );
        telemetry.addData("Tuning F", "%.4f (D-Pad L/R)",F);
        telemetry.addData("Step Sizes", "%.4f (B Button)", stepSizes[stepIndex]);





    }
}
