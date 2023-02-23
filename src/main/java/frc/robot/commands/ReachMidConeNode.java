package frc.robot.commands;


import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class ReachMidConeNode extends ReachOut {
    public ReachMidConeNode(Elevator elevator, Arm arm) {
        super(elevator, arm, 12, 17);
    }
}