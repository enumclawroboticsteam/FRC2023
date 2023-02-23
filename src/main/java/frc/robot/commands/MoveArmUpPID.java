package frc.robot.commands;

import frc.robot.subsystems.Arm;

public class MoveArmUpPID extends MoveArmPID {
    public MoveArmUpPID(Arm arm) {
        super(arm, arm.getPosition() + 1);   //
    }
}