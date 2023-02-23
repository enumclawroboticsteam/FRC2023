package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ReachFloor extends ReachOut {
    public ReachFloor(Elevator elevator, Arm arm) {
        super(elevator, arm, 1, 1);
        System.out.print("ReachFloor");
    }
}