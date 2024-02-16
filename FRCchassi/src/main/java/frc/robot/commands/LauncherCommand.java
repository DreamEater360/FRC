package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LauncherSubsystem;

public class LauncherCommand extends Command{
    public final LauncherSubsystem m_launcher;

  public LauncherCommand(LauncherSubsystem m_launcher) {
  this.m_launcher = m_launcher;
  addRequirements(m_launcher);
  }

  @Override
  public void initialize() {
    RobotContainer.coletor.stop();
  }

  @Override
  public void execute() {
    m_launcher.launcherWithJoystick(RobotContainer.m_secundPilotController, 1);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}

