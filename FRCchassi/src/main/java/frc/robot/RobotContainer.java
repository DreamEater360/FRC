package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveDefaut;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class RobotContainer {

  public static final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  public static final DriveDefaut DRIVE_DEFAUT = new DriveDefaut(driveTrain);

  public static final XboxController m_driverController =
      new XboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    DRIVE_DEFAUT.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(DRIVE_DEFAUT);

  }
}
