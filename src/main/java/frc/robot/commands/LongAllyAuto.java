// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** The main autonomous command to pickup and deliver the soda to the box. */
public class LongAllyAuto extends SequentialCommandGroup {
    /** Create a new autonomous command. */
    public LongAllyAuto(Drivetrain drivetrain, Elevator elevator, Arm arm, Wrist wrist, Grabber grabber) {
        addCommands(
                new ResetDrive(drivetrain),
                // TODO: Find Out What we want to do during auto
                //new PlaceMidCone(drivetrain, grabber, wrist, elevator, arm),
                //new ParallelCommandGroup(new MoveArmUpPID(arm),
                        //new SafeMoveWrist(wrist)),
                new StraightDrive(drivetrain, 212, .25)   // inches
               // new TurnDrive(drivetrain, 135),
                //new ParallelCommandGroup(new ReachFloor(elevator, arm),
               //         new FloorMoveWrist(wrist)),
                //new ParallelCommandGroup(new GrabPiece(grabber, elevator, wrist),
                        //new StraightDrive(drivetrain, 12)),
                //new ParallelCommandGroup(new SafeMoveWrist(wrist),
                        //new MoveArmUpPID(arm)),
                //new TurnDrive(drivetrain, -135),
                //new StraightDrive(drivetrain, 212),
                //new PlaceMidCone(drivetrain, grabber, wrist, elevator, arm)
                );
    }
}
