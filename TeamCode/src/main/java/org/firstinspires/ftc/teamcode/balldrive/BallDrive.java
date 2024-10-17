package org.firstinspires.ftc.teamcode.balldrive;

import androidx.annotation.NonNull;

import com.qualcomm.hardware.rev.Rev9AxisImuOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class BallDrive {
    DcMotor leftMotor, rightMotor, strafeMotor;
    IMU imu;

    public BallDrive(@NonNull HardwareMap hw, @NonNull BallDriveConfiguration conf) {
        leftMotor = hw.get(DcMotor.class, conf.leftMotorName);
        rightMotor = hw.get(DcMotor.class, conf.rightMotorName);
        strafeMotor = hw.get(DcMotor.class, conf.strafeMotorName);
        imu = hw.get(IMU.class, conf.imuName);

        initIMU();
    }

    private void initIMU() {
        imu.initialize(new IMU.Parameters(
                new Rev9AxisImuOrientationOnRobot(
                        Rev9AxisImuOrientationOnRobot.LogoFacingDirection.BACKWARD, // change to match to your robot
                        Rev9AxisImuOrientationOnRobot.I2cPortFacingDirection.BACKWARD) // change to match to your robot
        ));
    }

    public void setDrivePower(double x, double y, double turn) {
        leftMotor.setPower(x - y);
        rightMotor.setPower(x + y);
        strafeMotor.setPower(turn);
    }

    public double getHeading() {
        return imu.getRobotYawPitchRollAngles().getYaw(); // Change to match orientation of chub
    }
}
