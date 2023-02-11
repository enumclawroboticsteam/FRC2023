package frc.robot.commands;

import frc.robot.subsystems.Wrist;

public class SafeMoveWrist extends MoveWrist {
    public SafeMoveWrist(Wrist wrist) {
        super(wrist, 90);
    }
}