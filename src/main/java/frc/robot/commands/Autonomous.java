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

/** The main autonomous command to pickup and deliver the soda to the box. */
public class Autonomous extends SequentialCommandGroup {
  /** Create a new autonomous command. */
  public Autonomous(Drivetrain drive, Grabber grabber, Wrist wrist, Elevator elevator, Arm armA, Arm armB) {
    addCommands(
        // TODO: Find Out What we want to do during auto
        new PlaceMidCone(drive, grabber, wrist, elevator, armA, armB),
        parallel(new ReachCruising(elevator, armA, armB), 
                new SafeMoveWrist(wrist)),
        new StraightDrive(drive, -212),
        new TurnDrive(drive, 135),
        parallel(new ReachFloor(elevator, armA, armB),
                new FloorMoveWrist(wrist)),
        parallel(new GrabPiece(grabber, wrist, elevator), 
                new StraightDrive(drive, 12)),
        parallel(new SafeMoveWrist(wrist),
                new ReachCruising(elevator, armA, armB)),
        new TurnDrive(drive, -135),
        new StraightDrive(drive, 212),
        new PlaceMidCone(drive, grabber, wrist, elevator, armA, armB)
        );
  }
}
