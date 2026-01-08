package org.firstinspires.ftc.teamcode.CompCode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.CompCode.SubsytemsAndDriveSetup.Launcher;
import org.firstinspires.ftc.teamcode.CompCode.SubsytemsAndDriveSetup.Loader;
import org.firstinspires.ftc.teamcode.CompCode.SubsytemsAndDriveSetup.MecanumDrive;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends OpMode {
MecanumDrive drive = new MecanumDrive();
Launcher launcher = new Launcher();
Loader loader = new Loader();
double forward, strafe, rotate;
boolean launcherOn = false;
boolean lastRB = false;

    @Override
    public void init() {
        drive.init(hardwareMap);
        launcher.init(hardwareMap);
        loader.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        boolean currentRB = gamepad1.right_bumper;

        if(gamepad1.a){
            loader.on();
        }
        else {
            loader.off();
        }
        if(currentRB && !lastRB){
            launcherOn = !launcherOn;
            if (launcherOn){
                launcher.on();
            }
            else {
                launcher.off();
            }
        }
        lastRB = currentRB;
        drive.drive(forward, strafe, rotate);
    }
}
//can you implement those changes into this code
