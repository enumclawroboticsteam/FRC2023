package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;

public class ResetDrive extends WaitCommand {
    public ResetDrive(Drivetrain drivetrain) {
        super(1);
        drivetrain.reset();
    }
}
