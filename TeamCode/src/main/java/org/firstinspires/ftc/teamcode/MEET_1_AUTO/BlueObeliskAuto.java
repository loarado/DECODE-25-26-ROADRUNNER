package org.firstinspires.ftc.teamcode.MEET_1_AUTO;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name = "BlueObeliskAuto", group = "Autonomous")
public class  BlueObeliskAuto extends LinearOpMode {

    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(-52.5, -52.5, Math.toRadians(52.5));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        Launcher launcher = new Launcher(hardwareMap);
        Loader loader = new Loader(hardwareMap);

        waitForStart();

            if (isStopRequested()) return;

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            //spin up launcher
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
                            //move to human player and push artifacts into human player zone
                            .strafeToLinearHeading(new Vector2d(0,0),Math.toRadians(45))
                            .strafeToLinearHeading(new Vector2d(24,24),Math.toRadians(0))
                            .strafeTo(new Vector2d(24,44))
                            .strafeToLinearHeading(new Vector2d(48,54),Math.toRadians(45))







                            .build());

    }
}