package org.firstinspires.ftc.teamcode.CompCode.Autonomous;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.CompCode.SubsytemsAndDriveSetup.Launcher;
import org.firstinspires.ftc.teamcode.CompCode.SubsytemsAndDriveSetup.Loader;
import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "RedObeliskAuto", group = "Autonomous")
public class RedObeliskAuto extends LinearOpMode {

    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(-52.5, 52.5, Math.toRadians(-52.5));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        Launcher launcher = new Launcher();
        Loader loader = new Loader();
        loader.init(hardwareMap);
        launcher.init(hardwareMap);

        waitForStart();

            if (isStopRequested()) return;

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .afterTime(0, loader.loadOff())
                            .afterTime(0, launcher.launchOn())
                            .waitSeconds(2)
                            .afterTime(0, loader.loadOn())
                            .afterTime(.2, loader.loadOff())
                            .afterTime(1.2, loader.loadOn())
                            .afterTime(1.4, loader.loadOff())
                            .afterTime(2.4, loader.loadOn())
                            .afterTime(2.6, loader.loadOff())
                            .afterTime(3.6, loader.loadOn())
                            .afterTime(4, loader.loadOff())
                            .afterTime(5, launcher.launchOff())
                            .waitSeconds(5)//change based on the total time for launching
                            .strafeToLinearHeading(new Vector2d(0,0),Math.toRadians(-45))
                            .strafeToLinearHeading(new Vector2d(24,-24),Math.toRadians(0))
                            .strafeTo(new Vector2d(24,-44))
                            .strafeToLinearHeading(new Vector2d(48,-54),Math.toRadians(-45))




                            .build());

    }
}