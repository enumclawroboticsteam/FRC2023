package frc.robot.commands;

import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;

public class MoveArmDown extends MoveArm {
    public MoveArmDown(Elevator elevator, Arm armA, Arm armB) {
        super(elevator, armA, armB, 18, 0, 0);
    }
}