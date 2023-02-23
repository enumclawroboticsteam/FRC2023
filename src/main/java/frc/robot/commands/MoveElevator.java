// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * Move the elevator to a given location. This command finishes when it is
 * within the tolerance, but
 * leaves the PID loop running to maintain the position. Other commands using
 * the elevator should
 * make sure they disable PID!
 */
public class MoveElevator extends WaitCommand {
    private final Elevator m_elevator;
    private final double m_speed;

    /**
     * Create a new SetElevatorSetpoint command.
     *
     * @param setpoint The setpoint to set the elevator to
     * @param elevator The elevator to use
     */
    public MoveElevator(Elevator elevator, double speed) {
        super(1);
        m_elevator = elevator;
        m_speed = speed;
        addRequirements(m_elevator);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        m_elevator.set(m_speed);
        super.initialize();
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_elevator.stop();
    }

}