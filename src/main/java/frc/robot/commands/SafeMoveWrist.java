package frc.robot.commands;

import frc.robot.subsystems.Wrist;

public class SafeMoveWrist extends MoveWristPID {
    public SafeMoveWrist(Wrist wrist) {
        super(wrist, 90);
    }
}