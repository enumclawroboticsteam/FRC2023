// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import frc.robot.subsystems.Drivetrain;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import java.util.function.DoubleSupplier;

// /** Have the robot drive tank style. */
// public class CurvatureDrive extends CommandBase {
//   private final Drivetrain m_drivetrain;
//   private final DoubleSupplier m_speed;
//   private final DoubleSupplier m_rotation;

//   /**
//    * Creates a new TankDrive command.
//    *
//    * @param left The control input for the left side of the drive
//    * @param right The control input for the right sight of the drive
//    * @param drivetrain The drivetrain subsystem to drive
//    */
//   public CurvatureDrive(DoubleSupplier speed, DoubleSupplier rotation, Drivetrain drivetrain) {
//     m_drivetrain = drivetrain;
//     m_speed = speed;
//     m_rotation = rotation;
//     addRequirements(m_drivetrain);
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   public void execute() {
//     m_drivetrain.CurvatureDrive(m_speed.getAsDouble(), m_rotation.getAsDouble());
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   public boolean isFinished() {
//     return false; // Runs until interrupted
//   }

//   // Called once after isFinished returns true
//   @Override
//   public void end(boolean interrupted) {
//     m_drivetrain.CurvatureDrive(0, 0);
//   }
// }
