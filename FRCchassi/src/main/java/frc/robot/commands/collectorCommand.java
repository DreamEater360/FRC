package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.CollectorSubsystem;

public class collectorCommand extends Command{

    public final collector m_collector;

    public collectorCommand(collector m_collector) {
    this.m_collector = m_collector;
    addRequirements(m_collector);
  }

  @Override
  public void initialize() {
    RobotContainer.coletor.stop();
  }

  @Override
  public void execute() {
    m_collector.playWithJoystick(XboxController m_secundPilotController, 0.5);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}
