// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

/**
 * The elevator subsystem uses PID to go to a given height. Unfortunately, in
 * it's current state PID
 * values for simulation are different than in the real world do to minor
 * differences.
 */
public class Arm extends PIDSubsystem {
    private final CANSparkMax m_motor;
    private final RelativeEncoder m_encoder;

    private static final double kP_real = 4; // TODO: get correct values
    private static final double kI_real = 0.07;

    /** Create a new elevator subsystem. */
    public Arm(int canID) {
        super(new PIDController(kP_real, kI_real, 0));

        getController().setTolerance(1);

        m_motor = new CANSparkMax(canID, MotorType.kBrushless);
        m_encoder = m_motor.getEncoder();
        m_encoder.setPositionConversionFactor(1); // TODO: get factor

    }

    /** The log method puts interesting information to the SmartDashboard. */
    public void log() {
        // SmartDashboard.putData("Elevator Pot", m_encoder.getPosition());
    }

    /**
     * Use the potentiometer as the PID sensor. This method is automatically called
     * by the subsystem.
     */
    @Override
    public double getMeasurement() {
        return m_encoder.getPosition();
    }

    /**
     * Use the motor as the PID output. This method is automatically called by the
     * subsystem.
     */
    @Override
    public void useOutput(double output, double setpoint) {
        m_motor.set(output);
    }

    /** Call log method every loop. */
    @Override
    public void periodic() {
        log();
    }
}