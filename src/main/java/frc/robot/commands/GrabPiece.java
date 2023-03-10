// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import frc.robot.subsystems.Elevator;
// import frc.robot.subsystems.Grabber;
// import frc.robot.subsystems.Wrist;
// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// /**
//  * Pickup a soda can (if one is between the open claws) and get it in a safe state to drive around.
//  */
// public class GrabPiece extends SequentialCommandGroup {
//   /**
//    * Create a new pickup command.
//    *
//    * @param grabber The claw subsystem to use
//    * @param wrist The wrist subsystem to use
//    * @param elevator The elevator subsystem to use
//    */
//   public GrabPiece(Grabber grabber, Elevator elevator, Wrist wrist) {
//     addCommands(
//         new DetectPiece(grabber),
//         new CloseGrabberCube(grabber));
//   }
// }
