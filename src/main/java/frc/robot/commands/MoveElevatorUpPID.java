package frc.robot.commands;

import frc.robot.subsystems.Elevator;

public class MoveElevatorUpPID extends MoveElevatorPID {
    public MoveElevatorUpPID(Elevator elevator) {
        super(elevator, elevator.getPosition() + 1);
    }
}