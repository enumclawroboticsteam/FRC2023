// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

/** Have the robot drive tank style. */
public class ArcadeDrive extends CommandBase {
    private final Drivetrain m_drivetrain;
    private final DoubleSupplier m_speed;
    private final DoubleSupplier m_rotation;

    /**
     * @param drivetrain The drivetrain subsystem to drive
     */
    public ArcadeDrive(Drivetrain drivetrain, DoubleSupplier speed, DoubleSupplier rotation) {
        m_drivetrain = drivetrain;
        m_speed = rotation;
        m_rotation = speed;
        addRequirements(m_drivetrain);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        m_drivetrain.ArcadeDrive(m_speed.getAsDouble(), m_rotation.getAsDouble());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_drivetrain.ArcadeDrive(0, 0);
    }
}
