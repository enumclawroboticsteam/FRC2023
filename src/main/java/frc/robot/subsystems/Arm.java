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
 * The Arm subsystem has a continuous multi section lift with 3 parts. Retraction is handled by constant force springs. 
 */
public class Arm extends SubsystemBase {
    private final CANSparkMax m_motor;
    private final RelativeEncoder m_encoder;

    /** Create a new elevator subsystem. */
    public Arm() {
        super();

        m_motor = new CANSparkMax(Constants.kArmCANId, MotorType.kBrushless);
        m_motor.setSmartCurrentLimit(40);
        m_motor.setInverted(false);
        m_motor.setIdleMode(IdleMode.kBrake);

        // Conversion factor "napkin"
        // (1.5" * PI)/orev  *  orev/12mrev = .39"/mrev 
        m_encoder = m_motor.getEncoder();
        m_encoder.setPositionConversionFactor(.39);
    }

    public void stop() {
        m_motor.set(0);
    }

    /** The log method puts interesting information to the SmartDashboard. */
    public void log() {
        //SmartDashboard.putNumber("Arm Position", m_encoder.getPosition());
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

