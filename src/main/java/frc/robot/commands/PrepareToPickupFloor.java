// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

/** Make sure the robot is in a state to pickup soda cans. */
public class PrepareToPickupFloor extends SequentialCommandGroup {
  /**
   * Create a new prepare to pickup command.
   *
   * @param grabber The grabber subsystem to use
   * @param wrist The wrist subsystem to use
   * @param elevator The elevator subsystem to use
   */
  public PrepareToPickupFloor(Grabber grabber, Wrist wrist, Elevator elevator, Arm armA, Arm armB) {
    addCommands(
        new OpenGrabber(grabber),
        new MoveWrist(wrist, 0),
        new MoveArm(armA, 0),
        new MoveArm(armB, 0),
        new MoveElevator(elevator, 0));
  }
}
