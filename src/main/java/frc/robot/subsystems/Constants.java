package frc.robot.subsystems;

public final class Constants {
    public final int kFloor = 0;

//  CAN IDs 

    public static final int kLeftFrontCANId = 7;
    public static final int kLeftBackCANId = 1;
    public static final int kRightFrontCANId = 2;
    public static final int kRightBackCANId = 3;
    public static final int kElevatorCANId = 4;
    public static final int kGrabberCANId = 5;
    public static final int kWristCANId = 8;
    public static final int kArmCANId = 6;


// Arm PID Values 

    public static final double kArmP = 8;
    public static final double kArmI = 0;
    public static final double kArmD = 0;
    public static final double kArmToleranceInch = 1;
    public static final double kArmRateToleranceInchPerS = 1;


    // Elevator PID Values

    public static final double kElevatorP = 8;
    public static final double kElevatorI = 0;
    public static final double kElevatorD = 0;
    public static final double kElevatorToleranceInch = 1;
    public static final double kElevatorRateToleranceInchPerS = 1;

}
