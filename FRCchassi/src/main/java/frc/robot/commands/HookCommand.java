package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.HookSubsystem;

public class HookCommand extends Command{
  public final HookSubsystem m_hook;

  public HookCommand(HookSubsystem m_hook) {
  this.m_hook = m_hook;
  addRequirements(m_hook);
  }

  @Override
  public void initialize() {
    RobotContainer.coletor.stop();
  }

  @Override
  public void execute() {
    m_hook.hookWithJoystick(RobotContainer.m_secundPilotController, 0.5);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}


