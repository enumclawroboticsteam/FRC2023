// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * Opens the claw for one second. Real robots should use sensors, stalling
 * motors is BAD!
 */
public class OpenGrabber extends WaitCommand {
    private final Grabber m_grabber;

    /**
     * Creates a new OpenClaw command.
     *
     * @param grabber The claw to use
     */
    public OpenGrabber(Grabber grabber) {
        super(1);
        m_grabber = grabber;
        addRequirements(m_grabber);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        m_grabber.open();
        super.initialize();
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_grabber.stop();
    }
}
