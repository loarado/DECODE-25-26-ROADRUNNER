package org.firstinspires.ftc.teamcode.TEST_CODES;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MecanumDrive;

/*@Autonomous(name = "EasyTest", group = "Autonomous")
public class EasyTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        Pose2d beginPose = new Pose2d(-62, -20, Math.toRadians(0));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);

        waitForStart();

            if (isStopRequested()) return;

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .strafeTo(new Vector2d(24, -30))
                            .waitSeconds(1)
                            .strafeTo(new Vector2d(24, -48))
                            .waitSeconds(1)
                            .strafeTo(new Vector2d(40, -48))

                            .build());

    }
}*/