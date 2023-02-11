// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** Place Cone on top node, assumes that it's been grabed, in safe mode, and in correct location*/
public class PlaceTopCone extends SequentialCommandGroup {
  /** Create a new autonomous command. */
  public PlaceTopCone(Drivetrain drive, Grabber grabber, Wrist wrist, Elevator elevator, Arm armA, Arm armB) {
    addCommands(
        new ReachTopConeNode(elevator, armA, armB),
        new NonFloorMoveWrist(wrist),
        new OpenGrabber(grabber));
  }
}