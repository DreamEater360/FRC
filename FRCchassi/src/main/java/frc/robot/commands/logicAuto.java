package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.commands.AutoCommand;

public class logicAuto extends Command{

    private final DriveTrainSubsystem m_auto;

    public logicCommand(DriveTrainSubsystem m_auto) {
    this.m_auto = m_auto;
    addRequirements(m_auto);
  }

    @Override
    public void initialize() {
        RobotContainer.driveTrain.stop();
    } 

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
