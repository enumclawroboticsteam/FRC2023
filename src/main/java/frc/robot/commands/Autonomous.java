// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** The main autonomous command to pickup and deliver the soda to the box. */
public class Autonomous extends SequentialCommandGroup {
  /** Create a new autonomous command. */
  public Autonomous(Drivetrain drive, Grabber grabber, Wrist wrist, Elevator elevator, Arm armA, Arm armB) {
    addCommands(
        // TODO: Find Out What we want to do during auto
        new PlaceMidCone(drive, grabber, wrist, elevator, armA, armB),
        new ParallelCommandGroup(new MoveArmUp(elevator, armA, armB), 
                new SafeMoveWrist(wrist)),
        new StraightDrive(drive, -212),
        new TurnDrive(drive, 135),
        new ParallelCommandGroup(new ReachFloor(elevator, armA, armB),
                new FloorMoveWrist(wrist)),
        new ParallelCommandGroup(new GrabPiece(grabber, wrist, elevator), 
                new StraightDrive(drive, 12)),
        new ParallelCommandGroup(new SafeMoveWrist(wrist),
                new MoveArmUp(elevator, armA, armB)),
        new TurnDrive(drive, -135),
        new StraightDrive(drive, 212),
        new PlaceMidCone(drive, grabber, wrist, elevator, armA, armB)
        );
  }
}
