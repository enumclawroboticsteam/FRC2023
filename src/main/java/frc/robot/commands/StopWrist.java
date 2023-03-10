// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Closes the claw until the limit switch is tripped. */
public class StopWrist extends CommandBase {
    private final Wrist m_wrist;

    public StopWrist(Wrist wrist) {
        super();
        m_wrist = wrist;
        addRequirements(m_wrist);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        m_wrist.stop();
        super.initialize();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_wrist.stop();
    }
}
