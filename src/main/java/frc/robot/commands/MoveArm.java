// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class MoveArm extends WaitCommand {
    private final Arm m_arm;
    private final double m_speed;

    public MoveArm(Arm arm, double speed) {
        super(1);
        m_arm = arm;
        m_speed = speed;
        addRequirements(m_arm);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        m_arm.set(m_speed);
        super.initialize();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
//        m_arm.stop();
    }
}
