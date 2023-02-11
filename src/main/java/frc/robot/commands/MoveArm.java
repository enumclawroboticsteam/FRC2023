// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Move the elevator to a given location. This command finishes when it is within the tolerance, but
 * leaves the PID loop running to maintain the position. Other commands using the elevator should
 * make sure they disable PID!
 */
public class MoveArm extends CommandBase {
  private final Arm m_arm;
  private final double m_setpoint;

  /**
   * Create a new SetElevatorSetpoint command.
   *
   * @param setpoint The setpoint to set the elevator to
   * @param elevator The elevator to use
   */
  public MoveArm(Arm arm, double setPoint) {
    m_arm = arm;
    m_setpoint = setPoint;
    addRequirements(m_arm);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_arm.setSetpoint(m_setpoint);
    m_arm.enable();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return m_arm.getController().atSetpoint();
  }
}
