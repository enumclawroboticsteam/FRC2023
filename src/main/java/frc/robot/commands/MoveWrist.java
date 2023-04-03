// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class MoveWrist extends CommandBase {
    private final Wrist m_wrist;
    private double m_speed;

    public MoveWrist(Wrist wrist, double speed) {
        super();
        m_wrist = wrist;
        m_speed = speed;
        addRequirements(m_wrist);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        m_wrist.set(m_speed);
        super.initialize();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

      // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        // m_wrist.stop();
    }
}
