// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.sensors.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    /**
     * The Drivetrain subsystem incorporates the sensors and actuators attached to
     * the robots chassis.
     * These include four drive motors, a left and right encoder and a gyro.
     */
    private final CANSparkMax m_leftFrontMotor = new CANSparkMax(Constants.kLeftFrontCANId, MotorType.kBrushless);
    private final CANSparkMax m_leftBackMotor = new CANSparkMax(Constants.kLeftBackCANId, MotorType.kBrushless);
    private final MotorController m_leftMotor = new MotorControllerGroup(m_leftFrontMotor, m_leftBackMotor);

    private final CANSparkMax m_rightFrontMotor = new CANSparkMax(Constants.kRightFrontCANId, MotorType.kBrushless);
    private final CANSparkMax m_rightBackMotor = new CANSparkMax(Constants.kRightBackCANId, MotorType.kBrushless);
    private final MotorController m_rightMotor = new MotorControllerGroup(m_rightFrontMotor, m_rightBackMotor);

    private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

    private final RelativeEncoder m_leftEncoder = m_leftFrontMotor.getEncoder();
    private final RelativeEncoder m_rightEncoder = m_rightFrontMotor.getEncoder();

    private final RangeFinder m_rangefinder = new RangeFinder();
    private final Pigeon2 m_gyro = new Pigeon2(5);


    /** Create a new drivetrain subsystem. */
    public Drivetrain() {
        super();

        m_leftFrontMotor.setSmartCurrentLimit(40);
        m_leftBackMotor.setSmartCurrentLimit(40);
        m_rightFrontMotor.setSmartCurrentLimit(40);
        m_rightBackMotor.setSmartCurrentLimit(40);

        // We need to invert one side of the drivetrain so that positive voltages
        // result in both sides moving forward. Depending on how your robot's
        // gearbox is constructed, you might have to invert the left side instead.
        m_rightMotor.setInverted(true);

        // Encoders may measure differently in the real world and in
        // simulation. In this example the robot moves 0.042 barleycorns
        // per tick in the real world, but the simulated encoders
        // simulate 360 tick encoders. This if statement allows for the
        // real robot to handle this difference in devices.

        // circumference (6*pi) / (8.45 * 42)
        double kDriveInchesPerPulse = (6 * Math.PI) / (8.45 * 42);
        m_leftEncoder.setPositionConversionFactor(kDriveInchesPerPulse);
        m_rightEncoder.setPositionConversionFactor(kDriveInchesPerPulse);

    }

    /** The log method puts interesting information to the SmartDashboard. */
    public void log() {
        SmartDashboard.putNumber("Left Distance", m_leftEncoder.getPosition());
        SmartDashboard.putNumber("Right Distance", m_rightEncoder.getPosition());
        SmartDashboard.putNumber("Left Speed", m_leftEncoder.getVelocity());
        SmartDashboard.putNumber("Right Speed", m_rightEncoder.getVelocity());
        SmartDashboard.putNumber("Gyro", m_gyro.getYaw());
    }

    /**
     */
    public void CurvatureDrive(double forward, double rotation) {
         m_drive.curvatureDrive(forward, rotation, false);
    }

    public void ArcadeDrive(double forward, double rotation) {
            m_drive.arcadeDrive(forward, rotation);
    }
    /**
     * Get the robot's heading.
     *
     * @return The robots heading in degrees.
     */
    public double getHeading() {
        return m_gyro.getYaw();
    }

    /** Reset the robots sensors to the zero states. */
    public void reset() {
        m_gyro.setYaw(0);
        m_leftEncoder.setPosition(0);
        m_rightEncoder.setPosition(0);
    }

    /**
     * Get the average distance of the encoders since the last reset.
     *
     * @return The distance driven (average of left and right encoders).
     */
    public double getDistance() {
        return (m_leftEncoder.getPosition() + m_rightEncoder.getPosition()) / 2;
    }

    /**
     * Get the distance to the obstacle.
     *
     * @return The distance to the obstacle detected by the rangefinder.
     */
    public double getDistanceToObstacle() {
        // Really meters in simulation since it's a rangefinder...
        return m_rangefinder.getDistance();
    }

    /** Call log method every loop. */
    @Override
    public void periodic() {
        log();
    }
}
