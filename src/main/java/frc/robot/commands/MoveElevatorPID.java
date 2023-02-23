package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Constants;

/** A command that will turn the robot to the specified angle. */
public class MoveElevatorPID extends PIDCommand {
    /**
     * Turns to robot to the specified angle.
     *
     * @param armA     The angle to turn to
     * @param setpoint The drive subsystem to use
     */
    public MoveElevatorPID(Elevator elevator, double setPoint) {
        super(
                // Close loop on heading
                new PIDController(Constants.kElevatorP, Constants.kElevatorI, Constants.kElevatorD),
                elevator::getPosition,
                // Set reference to target
                elevator.getPosition() + setPoint,
                // Pipe output to turn robot
                (output) -> elevator.set(output),
                elevator);

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

// import frc.robot.subsystems.Elevator;
// import frc.robot.subsystems.Wrist;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// /**
//  * Move the elevator to a given location. This command finishes when it is within the tolerance, but
//  * leaves the PID loop running to maintain the position. Other commands using the elevator should
//  * make sure they disable PID!
//  */
// public class MoveElevator extends CommandBase {
//   private final Wrist m_elevator;
//   private final double m_setpoint;

//   /**
//    * Create a new SetElevatorSetpoint command.
//    *
//    * @param setpoint The setpoint to set the elevator to
//    * @param elevator The elevator to use
//    */
//   public MoveElevator(Wrist elevator, double setPoint) {
//     m_elevator = elevator;
//     m_setpoint = setPoint;
//     addRequirements(m_elevator);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   public void initialize() {
//     m_elevator.setSetpoint(m_setpoint);
//     m_elevator.enable();
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   public boolean isFinished() {
//     return m_elevator.getController().atSetpoint();
//   }
// }
