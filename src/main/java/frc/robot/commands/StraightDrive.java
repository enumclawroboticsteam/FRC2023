// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.PIDCommand;

/**
 * Drive the given distance straight (negative values go backwards). Uses a
 * local PID controller to
 * run a simple PID loop that is only enabled while this command is running. The
 * input is the
 * averaged values of the left and right encoders.
 */
public class StraightDrive extends PIDCommand {
    private final Drivetrain m_drivetrain;
    private double m_maxSpeed;

    // NOTE: Resets positions in initialize so we can send in raw distance 
    public StraightDrive(Drivetrain drivetrain, double distance, double maxSpeed) {
        super(new PIDController(4, 0, 0), drivetrain::getPosition, distance, o -> drivetrain.TankDrive(o * maxSpeed, o * maxSpeed));
        m_drivetrain = drivetrain;
        m_maxSpeed = maxSpeed;
        addRequirements(m_drivetrain);

        getController().setTolerance(2);
    }

    // Todo: Lmit speed using bounds?
    public static double bounds(double value, double maxVariance) {
        double maxValue = Math.abs(maxVariance);
        double minValue = -Math.abs(maxVariance);

        if (value <= minValue) {
            return minValue;
        } else if (value > maxValue) {
            return maxValue;
        } else {
            return value;
        }
    }

    // (o > maxSpeedFactor? maxSpeedFactor: (0 < -maxSpeedFactor ? -maxSpeedFactor :
    // o)

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        super.initialize();
        // Get everything in a safe starting state.
        m_drivetrain.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }
}
