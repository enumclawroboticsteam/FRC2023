// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class MoveWrist extends WaitCommand {
    private final Wrist m_wrist;
    private final double m_speed;

    public MoveWrist(Wrist wrist, double speed) {
        super(.1);
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

      // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_wrist.stop();
    }
}
