// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * Pickup a soda can (if one is between the open claws) and get it in a safe state to drive around.
 */
public class ReachOut extends SequentialCommandGroup {
  /**
   @param elevator 
   @param armA
   @param armB
   @param elevatorSetPoint
   @param armASetPoint
   @param armBSetPoint
   */
  public ReachOut(Elevator elevator, Arm armA, Arm armB, double elevatorSetPoint, double armASetPoint, double armBSetPoint) {
    addCommands(
        new ParallelCommandGroup(new MoveElevator(elevator, elevatorSetPoint),
                    new MoveArm(armA, armASetPoint),
                    new MoveArm(armB, armBSetPoint)));
        
  }
}
