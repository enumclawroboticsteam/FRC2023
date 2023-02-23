package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ReachTopConeNode extends ReachOut {
    public ReachTopConeNode(Elevator elevator, Arm arm) {
        super(elevator, arm, 12, 23);
    }
}