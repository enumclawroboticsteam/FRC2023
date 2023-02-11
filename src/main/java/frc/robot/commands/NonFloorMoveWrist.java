package frc.robot.commands;

import frc.robot.subsystems.Wrist;

public class NonFloorMoveWrist extends MoveWrist {
    public NonFloorMoveWrist(Wrist wrist) {
        super(wrist, 90);
    }
}