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
        Pose2d beginPose = new Pose2d(-52.5, 52.5, Math.toRadians(-232.5));
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
                            .strafeToLinearHeading(new Vector2d(-12,12), Math.toRadians(-225))
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
                            .splineToLinearHeading(new Pose2d(-24,48, Math.toRadians(0)),Math.toRadians(0))





                            .build());

    }
}