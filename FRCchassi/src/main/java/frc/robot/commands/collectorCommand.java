package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CollectorSubsystem;

public class collectorCommand extends Command{

  public final CollectorSubsystem m_collector;

  public collectorCommand(CollectorSubsystem m_collector) {
  this.m_collector = m_collector;
  addRequirements(m_collector);
  }

  @Override
  public void initialize() {
    RobotContainer.coletor.stop();
  }

  @Override
  public void execute() {
    m_collector.playWithJoystick(RobotContainer.m_secundPilotController, 1);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}
