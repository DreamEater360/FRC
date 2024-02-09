package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutoCommand extends Command {

  public static Command autonomo(){
    return Commands.sequence(Subsystem.autonomousCommand(), new logicAuto());
  }

}