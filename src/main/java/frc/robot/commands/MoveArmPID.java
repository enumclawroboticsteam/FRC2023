package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Constants;

/** A command that will turn the robot to the specified angle. */
public class MoveArmPID extends PIDCommand {
    /**
     * Turns to robot to the specified angle.
     *
     * @param armA     The angle to turn to
     * @param setpoint The drive subsystem to use
     */
    public MoveArmPID(Arm arm, double setPoint) {
        super(
                // Close loop on heading
                new PIDController(Constants.kArmP, Constants.kArmI, Constants.kArmD),
                arm::getPosition,
                // Set reference to target
                arm.getPosition() + setPoint,
                // Pipe output to turn robot
                (output) -> arm.set(output),
                arm);

        // Set the controller tolerance - the delta tolerance ensures the robot is
        // stationary at the
        // setpoint before it is considered as having reached the reference
        getController().setTolerance(Constants.kArmToleranceInch, Constants.kArmRateToleranceInchPerS);
    }

    @Override
    public boolean isFinished() {
        // End when the controller is at the reference.
        return getController().atSetpoint();
    }
}