package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ReachTopCubeNode extends ReachOut {
    public ReachTopCubeNode(Elevator elevator, Arm arm) {
        super(elevator, arm, 12, 29);
    }
}