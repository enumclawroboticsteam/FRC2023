package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;


public class ReachCruising extends ReachOut {
    public ReachCruising(Elevator elevator, Arm arm) {
        super(elevator, arm, 18, 0);
    }
}