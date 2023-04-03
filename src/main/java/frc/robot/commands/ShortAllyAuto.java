// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/** The main autonomous command to pickup and deliver the soda to the box. */
public class ShortAllyAuto extends SequentialCommandGroup {
    /** Create a new autonomous command. */
    public ShortAllyAuto(Drivetrain drive, Elevator elevator, Arm arm, Wrist wrist, Grabber grabber) {
       this.addCommands(
            // new SequentialCommandGroup(
            // new CloseGrabber(grabber, Constants.kGrabberCubeSpeed),
            // new WaitCommand(.25d),
            // new MoveWrist(wrist, Constants.kDownWristPowerLimit),
            // new WaitCommand(.25d),
            // new StopWrist(wrist),
            // new WaitCommand(.25d),
            // new MoveArm(arm, 1 * Constants.kArmPowerLimit),
            // new WaitCommand(1d),
            // new MoveArm(arm, 0),
            // new WaitCommand(.5),
            // new OpenGrabber(grabber), 
            // new WaitCommand(.5),
            // new StopGrabber(grabber)
            //)
        );
    }
}
