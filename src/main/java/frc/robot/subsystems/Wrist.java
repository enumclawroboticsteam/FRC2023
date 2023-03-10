// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The wrist subsystem torques the wrist up and out of the way.
 */
public class Wrist extends SubsystemBase {
    private final CANSparkMax m_motor;
    private final RelativeEncoder m_encoder;

    /** Create a new elevator subsystem. */
    public Wrist() {
        super();

        m_motor = new CANSparkMax(Constants.kWristCANId, MotorType.kBrushless);
        m_motor.setSmartCurrentLimit(5);
        m_encoder = m_motor.getEncoder();
        m_encoder.setPositionConversionFactor(.01529);

        // Conversion factor "napkin"
        // NEO?
        // TODO: WHAT TYPE OF MOTOR

    }

    public void log() {
        // SmartDashboard.putData("Wrist Position", m_encoder.getPosition());
    }

    public double getPosition() {
        return m_encoder.getPosition();
    }

    public void set(double speed) {
        m_motor.set(speed);
    }

    public void stop() {
        m_motor.set(0);
    }

    @Override
    public void periodic() {
        log();
    }
}

