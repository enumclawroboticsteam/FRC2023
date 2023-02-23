package frc.robot.commands;

import frc.robot.subsystems.Wrist;

public class FloorMoveWrist extends MoveWristPID {
    public FloorMoveWrist(Wrist wrist) {
        super(wrist, 0);
    }
}