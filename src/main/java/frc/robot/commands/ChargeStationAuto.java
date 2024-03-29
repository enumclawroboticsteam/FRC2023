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
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/** The main autonomous command to pickup and deliver the soda to the box. */
public class ChargeStationAuto extends SequentialCommandGroup {
    /** Create a new autonomous command. */
    public ChargeStationAuto(Drivetrain drive, Elevator elevator, Arm arm, Wrist wrist, Grabber grabber) {
        addCommands(
            // raceWith(new WaitCommand(1d), new MoveArm(arm, 1 * Constants.kArmPowerLimit)), 
            // raceWith(new WaitCommand(.25d), new MoveWrist(wrist, Constants.kDownWristPowerLimit)),
            // raceWith(new WaitCommand(.5), new OpenGrabber(grabber)),
            // raceWith(new WaitCommand(1d), new MoveArm(arm, -1 * Constants.kArmPowerLimit))

                //new ResetDrive(drive),
                // TODO: Find Out What we want to do during auto
                //new PlaceMidCone(drive, grabber, wrist, elevator, arm),
                //new ParallelCommandGroup(new MoveArmUpPID(arm),
                        //new SafeMoveWrist(wrist)),
                //new StraightDrive(drive, 60, .20)
               // new TurnDrive(drive, 135),
                //new ParallelCommandGroup(new ReachFloor(elevator, arm),
               //         new FloorMoveWrist(wrist)),
                //new ParallelCommandGroup(new GrabPiece(grabber, elevator, wrist),
                        //new StraightDrive(drive, 12)),
                //new ParallelCommandGroup(new SafeMoveWrist(wrist),
                        //new MoveArmUpPID(arm)),
                //new TurnDrive(drive, -135),
                //new StraightDrive(drive, 212),
                //new PlaceMidCone(drive, grabber, wrist, elevator, arm)
                );
    }
}
