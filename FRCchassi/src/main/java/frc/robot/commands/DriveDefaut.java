package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
//import frc.robot.subsystems.ExampleSubsystem;
//import edu.wpi.first.networktables.NetworkTable.SubTableListener;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Subsystem;

/** An example command that uses an example subsystem. */
public class DriveDefaut extends Command {
    private final DriveTrainSubsystem m_drive;

  public DriveDefaut(DriveTrainSubsystem m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveTrain.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.driveWithJoystick(RobotContainer.m_driverController, DriveTrainSubsystem.calc(RobotContainer.m_driverController, 0.7, RobotContainer.m_driverController.getLeftTriggerAxis(), 
    RobotContainer.m_driverController.getRightTriggerAxis()));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
