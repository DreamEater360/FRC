package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

//Declara a classe principal que executa todos os metodos; "Central de controle"; Main
public class DriveDefaut extends Command {
    private final DriveTrainSubsystem m_drive;

  //Requisitando os dados do DriveTrainSubsystem 
  public DriveDefaut(DriveTrainSubsystem m_drive) {
    this.m_drive = m_drive;
    addRequirements(m_drive);
  }

  //Manda os motores robô parararem quando liga
  @Override
  public void initialize() {
    RobotContainer.driveTrain.stop();
  }

  //
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
