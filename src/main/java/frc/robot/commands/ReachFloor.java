package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ReachFloor extends ReachOut {
    public ReachFloor(Elevator elevator, Arm armA, Arm armB) {
        super(elevator, armA, armB, 0, 0, 0);
    }
}