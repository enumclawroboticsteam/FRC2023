// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/** Closes the claw until the limit switch is tripped. */
public class CloseGrabber extends WaitCommand {
    private final Grabber m_grabber;

    public CloseGrabber(Grabber grabber) {
        super(1);
        m_grabber = grabber;
        addRequirements(m_grabber);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        m_grabber.close();
        super.initialize();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return m_grabber.isGrabbing();
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_grabber.stop();
    }
}
