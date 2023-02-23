package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Constants;
import frc.robot.subsystems.Wrist;

/** A command that will turn the robot to the specified angle. */
public class MoveWristPID extends PIDCommand {
    /**
     * Turns to robot to the specified angle.
     *
     * @param wrist     The angle to turn to
     * @param setpoint The drive subsystem to use
     */
    public MoveWristPID(Wrist wrist, double wristSetPoint) {
        super(
                // Close loop on heading
                new PIDController(Constants.kElevatorP, Constants.kElevatorI, Constants.kElevatorD),
                wrist::getPosition,
                // Set reference to target
                wristSetPoint,
                // Pipe output to turn robot
                (output) -> wrist.set(output),
                wrist);

        // Set the controller tolerance - the delta tolerance ensures the robot is
        // stationary at the
        // setpoint before it is considered as having reached the reference
        getController().setTolerance(Constants.kElevatorToleranceInch, Constants.kElevatorRateToleranceInchPerS);
    }

    @Override
    public boolean isFinished() {
        // End when the controller is at the reference.
        return getController().atSetpoint();
    }
}

// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import frc.robot.subsystems.Wrist;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// /**
//  * Move the wrist to a given angle. This command finishes when it is within the tolerance, but
//  * leaves the PID loop running to maintain the position. Other commands using the wrist should make
//  * sure they disable PID!
//  */
// public class MoveWrist extends CommandBase {
//   private final Wrist m_wrist;
//   private final double m_setpoint;

//   /**
//    * Create a new SetWristSetpoint command.
//    *
//    * @param setpoint The setpoint to set the wrist to
//    * @param wrist The wrist to use
//    */
//   public MoveWrist(Wrist wrist, double setpoint) {
//     m_wrist = wrist;
//     m_setpoint = setpoint;
//     addRequirements(m_wrist);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   public void initialize() {
//     m_wrist.enable();
//     m_wrist.setSetpoint(m_setpoint);
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   public boolean isFinished() {
//     return m_wrist.getController().atSetpoint();
//   }
// }
