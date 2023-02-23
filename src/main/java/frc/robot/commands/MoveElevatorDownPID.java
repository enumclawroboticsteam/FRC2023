package frc.robot.commands;

import frc.robot.subsystems.Elevator;

public class MoveElevatorDownPID extends MoveElevatorPID {
    public MoveElevatorDownPID(Elevator elevator) {
        super(elevator, elevator.getPosition() - 1);
    }
}