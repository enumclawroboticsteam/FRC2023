// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Closes the claw until the limit switch is tripped. */
public class CloseGrabber extends CommandBase {
  private final Grabber m_grabber;

  public CloseGrabber(Grabber grabber) {
    m_grabber = grabber;
    addRequirements(m_grabber);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_grabber.close();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return m_grabber.isGrabbing();
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    // NOTE: Doesn't stop in simulation due to lower friction causing the
    // can to fall out
    // + there is no need to worry about stalling the motor or crushing the
    // can.
    if (!Robot.isSimulation()) {
      m_grabber.stop();
    }
  }
}
