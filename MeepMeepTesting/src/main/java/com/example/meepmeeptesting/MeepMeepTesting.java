package com.example.meepmeeptesting;


import static java.lang.Math.PI;
import static java.lang.Math.toRadians;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;


public class MeepMeepTesting {
    public static double dummyP = 3;

    public static double dropX = -29, dropY = 17.5, dropA = toRadians(210), dropET = toRadians(30);

    public static double pickupX1 = -46, pickupY1 = 10, pickupA1 = toRadians(180), pickupET1 = toRadians(180);
    public static double pickupX2 = -63, pickupY2 = 13, pickupA2 = toRadians(180), pickupET2 = toRadians(180);

    public static void main(String[] args) {

        MeepMeep meepMeep = new MeepMeep(600);


        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                .setDimensions(13.5,14.5)
                .setConstraints(50, 40, 4 * PI, 2 * PI, 11)
                .setConstraints(60, 60, toRadians(180), toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(-35.1 , 62.25, toRadians(90)))
                                        .setReversed(true)
//                                        .splineToSplineHeading(new Pose2d(-32, 52, toRadians(70)), toRadians(0))
                                        .lineToLinearHeading(new Pose2d(-34, 46, toRadians(90)))
                                        .splineToSplineHeading(new Pose2d(-34, 9, toRadians(225)), toRadians(270))
                                        .lineToLinearHeading(new Pose2d(-29, 18.5, toRadians(225)))

                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}