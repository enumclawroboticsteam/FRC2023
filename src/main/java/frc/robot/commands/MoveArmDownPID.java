package frc.robot.commands;

import frc.robot.subsystems.Arm;

public class MoveArmDownPID extends MoveArmPID {
    public MoveArmDownPID(Arm armA) {
        super(armA, armA.getPosition() - 1);
    }
}