package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ReachMidCubeNode extends ReachOut {
    public ReachMidCubeNode(Elevator elevator, Arm armA, Arm armB) {
        super(elevator, armA, armB, 12, 23, 23);
    }
}