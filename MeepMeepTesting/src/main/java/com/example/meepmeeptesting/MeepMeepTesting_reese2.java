package com.example.meepmeeptesting;


import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting_reese2 {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(600);


        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(42, 90, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-49.5, -49.5, Math.toRadians(55)))
                .waitSeconds(5)
                .strafeToLinearHeading(new Vector2d(0,0),Math.toRadians(45))
                .splineToLinearHeading(new Pose2d(24,24,Math.toRadians(0)),Math.toRadians(90))
                .strafeTo(new Vector2d(24,44))
                .waitSeconds(.5)
                .strafeToLinearHeading(new Vector2d(48,54),Math.toRadians(45))
                .waitSeconds(5)
                .strafeToLinearHeading(new Vector2d(-49.5,-49.5), Math.toRadians(55))
                .waitSeconds(3)
                .strafeToLinearHeading(new Vector2d(38,32), Math.toRadians(90))

                .build());
        myBot.setDimensions(15.5, 17);

        meepMeep.setBackground(MeepMeep.Background.FIELD_DECODE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}