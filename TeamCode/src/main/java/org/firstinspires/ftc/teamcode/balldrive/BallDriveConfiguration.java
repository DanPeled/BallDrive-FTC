package org.firstinspires.ftc.teamcode.balldrive;

public class BallDriveConfiguration {
    public final String leftMotorName, rightMotorName, strafeMotorName, imuName;

    public BallDriveConfiguration(String leftMotorName, String rightMotorName, String strafeMotorName, String imuName) {
        this.leftMotorName = leftMotorName;
        this.rightMotorName = rightMotorName;
        this.strafeMotorName = strafeMotorName;
        this.imuName = imuName;
    }
}
