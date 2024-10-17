package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.balldrive.BallDrive;
import org.firstinspires.ftc.teamcode.balldrive.BallDriveConfiguration;

@TeleOp
public class SampleOpMode extends LinearOpMode {
    BallDrive drivetrain;

    @Override
    public void runOpMode() {
        BallDriveConfiguration conf = new BallDriveConfiguration(
                "leftMotor",
                "rightMotor",
                "strafeMotor",
                "imu"
        );

        drivetrain = new BallDrive(hardwareMap, conf);
        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            drivetrain.setDrivePower(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        }
    }
}
