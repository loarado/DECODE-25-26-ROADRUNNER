package org.firstinspires.ftc.teamcode.MEET_1_AUTO;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "RedObeliskAuto", group = "Autonomous")
public class RedObeliskAuto extends LinearOpMode {

    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(-49.5, 49.5, Math.toRadians(-55));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        Launcher launcher = new Launcher(hardwareMap);
        Loader loader = new Loader(hardwareMap);

        waitForStart();

            if (isStopRequested()) return;

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .afterTime(0, launcher.launchOn())
                            .afterTime(2, loader.loadOn())
                            .afterTime(.5, loader.loadOff())
                            .afterTime(.5, loader.loadOn())
                            .afterTime(.5, loader.loadOff())
                            .afterTime(.5, loader.loadOn())
                            .afterTime(.5)
                            .waitSeconds(2)//change based on the total time for launching
                            .strafeToLinearHeading(new Vector2d(0,0),Math.toRadians(-45))
                            .splineToLinearHeading(new Pose2d(24,-24,Math.toRadians(0)),Math.toRadians(-90))
                            .strafeTo(new Vector2d(24,-44))
                            .waitSeconds(.5)
                            .strafeToLinearHeading(new Vector2d(48,-54),Math.toRadians(-45))


                            .build());

    }
}