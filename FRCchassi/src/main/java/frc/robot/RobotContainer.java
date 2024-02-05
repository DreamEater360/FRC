package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveDefaut;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static final DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
  public static final DriveDefaut DRIVE_DEFAUT = new DriveDefaut(driveTrain);

  public static final XboxController m_driverController =
      new XboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    DRIVE_DEFAUT.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(DRIVE_DEFAUT);

    configureBindings();
  }

  private void configureBindings() {

    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

  }

  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
