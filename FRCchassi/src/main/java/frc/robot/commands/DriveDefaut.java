package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveDefaut extends Command {
    private final DriveTrainSubsystem m_drive;

  public DriveDefaut(DriveTrainSubsystem m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive);
  }

  @Override
  public void initialize() {
    RobotContainer.driveTrain.stop();
  }

  @Override
  public void execute() {
    m_drive.driveWithJoystick(RobotContainer.m_driverController, DriveTrainSubsystem.calc(RobotContainer.m_driverController, 0.7, RobotContainer.m_driverController.getLeftTriggerAxis(), 
    RobotContainer.m_driverController.getRightTriggerAxis()));
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
