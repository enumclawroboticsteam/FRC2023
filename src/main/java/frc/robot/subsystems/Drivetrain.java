// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.sensors.Pigeon2;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    /**
     * The Drivetrain subsystem incorporates the sensors and actuators attached to
     * the robots chassis.
     * These include four drive motors, a left and right encoder and a gyro.
     */
    private CANSparkMax m_leftFrontMotor;
    private CANSparkMax m_leftBackMotor;
    private MotorController m_leftMotor;

    private CANSparkMax m_rightFrontMotor;
    private CANSparkMax m_rightBackMotor;
    private MotorController m_rightMotor;

    private DifferentialDrive m_drive;

    private RelativeEncoder m_leftEncoder;
    private RelativeEncoder m_rightEncoder;

    private Pigeon2 m_gyro;

    /** Create a new drivetrain subsystem. */
    public Drivetrain() {
        super();

        m_leftFrontMotor = new CANSparkMax(Constants.kLeftFrontCANId, MotorType.kBrushless);
        m_leftFrontMotor.setInverted(true);
        m_leftFrontMotor.setSmartCurrentLimit(40);
        m_leftFrontMotor.setIdleMode(IdleMode.kBrake);

        m_leftBackMotor = new CANSparkMax(Constants.kLeftBackCANId, MotorType.kBrushless);
        m_leftBackMotor.setInverted(true);
        m_leftBackMotor.setSmartCurrentLimit(40);
        m_leftBackMotor.setIdleMode(IdleMode.kBrake);

        m_rightFrontMotor = new CANSparkMax(Constants.kRightFrontCANId, MotorType.kBrushless);
        m_rightFrontMotor.setInverted(false);
        m_rightFrontMotor.setSmartCurrentLimit(40);
        m_rightFrontMotor.setIdleMode(IdleMode.kBrake);

        m_rightBackMotor = new CANSparkMax(Constants.kRightBackCANId, MotorType.kBrushless);
        m_rightBackMotor.setInverted(false);
        m_rightBackMotor.setSmartCurrentLimit(40    );
        m_rightBackMotor.setIdleMode(IdleMode.kBrake);

        m_leftMotor = new MotorControllerGroup(m_leftFrontMotor, m_leftBackMotor);
        m_rightMotor = new MotorControllerGroup(m_rightFrontMotor, m_rightBackMotor);       

        m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);
    
        m_leftEncoder = m_leftFrontMotor.getEncoder();
        m_rightEncoder = m_rightFrontMotor.getEncoder();
    
        m_gyro = new Pigeon2(Constants.kGyroDevice);
        
        // circumference (6in*pi)/axlerev * axelrev/8.45mrev  = in / mrev
        double kDriveInchesPerRev = (6 * Math.PI) / 8.45;
        m_leftEncoder.setPositionConversionFactor(kDriveInchesPerRev);
        m_rightEncoder.setPositionConversionFactor(kDriveInchesPerRev);
    }

    /** The log method puts interesting information to the SmartDashboard. */
    public void log() {
        //SmartDashboard.putNumber("Left Speed", m_leftEncoder.getVelocity());
        // SmartDashboard.putNumber("Left Distance Inches", m_leftEncoder.getPosition());
        // SmartDashboard.putNumber("Left Distance Feet", m_leftEncoder.getPosition());

        // SmartDashboard.putNumber("Right Speed", m_rightEncoder.getVelocity());
        // SmartDashboard.putNumber("Right Distance Inches", m_rightEncoder.getPosition()/12);
        // SmartDashboard.putNumber("Right Distance Feet", m_rightEncoder.getPosition()/12);

        // SmartDashboard.putNumber("Gyro Yaw", m_gyro.getYaw());
        // SmartDashboard.putNumber("Gyro Pitch", m_gyro.getPitch());
        // SmartDashboard.putNumber("Gyro Roll", m_gyro.getRoll());
    }

    // /**
    //  */
    // public void CurvatureDrive(double forward, double rotation) {
    //     m_drive.curvatureDrive(forward, rotation, false);
    // }

    public void TankDrive(double left, double right) {
        m_drive.tankDrive(left, right);
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
    public double getPosition() {
        return (m_rightEncoder.getPosition());
    }

    /**
     * Get the distance to the obstacle.
     *
     * @return The distance to the obstacle detected by the rangefinder.
     */
    // public double getDistanceToObstacle() {
    // // Really meters in simulation since it's a rangefinder...
    // return m_rangefinder.getDistance();

    /** Call log method every loop. */
    @Override
    public void periodic() {
        log();
    }
}
