package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ReachMidConeNode extends ReachOut {
    public ReachMidConeNode(Elevator elevator, Arm armA, Arm armB) {
        super(elevator, armA, armB, 12, 17, 17);
    }
}