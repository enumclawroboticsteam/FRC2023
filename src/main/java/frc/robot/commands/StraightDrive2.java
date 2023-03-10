// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import frc.robot.subsystems.Drivetrain;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// /** Closes the claw until the limit switch is tripped. */
// public class StraightDrive2 extends CommandBase {
//     private final Drivetrain m_drivetrain;
//     private double m_distance; 
//     private double m_speed = 0;
//     private double m_startPosition = 0;
//     private double m_targetPosition = 0; 

//     public StraightDrive2(Drivetrain drivetrain, double distance, double speed) {
//         super();
//         m_drivetrain = drivetrain;
//         m_distance = distance;
//         m_speed = Math.signum(distance) * Math.abs(speed);          // force speed to align with distance
//         addRequirements(m_drivetrain);
//     }

//     // Called just before this Command runs the first time
//     @Override
//     public void initialize() {
//         super.initialize();

//         m_startPosition = m_drivetrain.getPosition();
//         m_targetPosition = m_startPosition + m_distance;

//         m_drivetrain.TankDrive(m_speed, m_speed); 
//     }

//     // Make this return true when this Command no longer needs to run execute()
//     @Override
//     public boolean isFinished() {
//         boolean isAtPosition = true; 

//         // reversing and moved enough 
//         if (Math.signum(m_distance) == -1 && m_drivetrain.getPosition() <= m_targetPosition) {
//             isAtPosition = true;
//         } 
//         // forward and moved enough 
//         else if (Math.signum(m_distance) == 1 && m_drivetrain.getPosition() >= m_targetPosition) {
//             isAtPosition = true;
//         } else if (Math.abs(m_drivetrain.getPosition() - m_targetPosition) < 5) {
//             isAtPosition = true;
//         }

//         return isAtPosition; 
//     }

//     // Called once after isFinished returns true
//     @Override
//     public void end(boolean interrupted) {
//         m_drivetrain.ArcadeDrive(0,0);
//     }
// }
