// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The elevator subsystem lifts near the from of the arm which changes the arm angle  
 */
public class Elevator extends SubsystemBase {
    private final CANSparkMax m_motor;
    private final RelativeEncoder m_encoder;

    public Elevator() {
        super();

        m_motor = new CANSparkMax(Constants.kElevatorCANId, MotorType.kBrushless);
        m_motor.setSmartCurrentLimit(40);
        m_motor.setInverted(false);
        m_motor.setIdleMode(IdleMode.kBrake);

        // Conversion factor "napkin"
        // (1" * PI)/orev * orev/64mrev = .015625"/mrev
        m_encoder = m_motor.getEncoder();
        m_encoder.setPositionConversionFactor(015625);
    }

    public void stop() {
        m_motor.set(0);
    }

    public void log() {
        SmartDashboard.putNumber("Elevator Position", m_encoder.getPosition());
    }

    public double getPosition() {
        return m_encoder.getPosition();
    }

    public void set(double speed) {
        m_motor.set(speed);
    }

    @Override
    public void periodic() {
        log();
    }
}