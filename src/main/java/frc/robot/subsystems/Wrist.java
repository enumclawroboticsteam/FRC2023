// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

/**
 * The wrist subsystem is like the elevator, but with a rotational joint instead
 * of a linear joint.
 */
public class Wrist extends PIDSubsystem {
    private final CANSparkMax m_motor;
    private final AnalogPotentiometer m_pot;

    private static final double kP = 1;

    /** Create a new wrist subsystem. */
    public Wrist() {
        super(new PIDController(kP, 0, 0));
        getController().setTolerance(2.5);

        m_motor = new CANSparkMax(Constants.kWristCANId, MotorType.kBrushless);
        m_pot = new AnalogPotentiometer(3, -270.0 / 5);

    }

    /** The log method puts interesting information to the SmartDashboard. */
    public void log() {
        SmartDashboard.putData("Wrist Angle", m_pot);
    }

    /**
     * Use the potentiometer as the PID sensor. This method is automatically called
     * by the subsystem.
     */
    @Override
    public double getMeasurement() {
        return m_pot.get();
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
