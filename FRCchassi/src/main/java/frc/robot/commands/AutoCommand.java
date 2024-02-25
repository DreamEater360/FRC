package frc.robot.commands;

import frc.robot.subsystems.AutoSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;

//criação da classe do autônomo
public final class AutoCommand extends SequentialCommandGroup{
    // //declaração do objeto da base
    // private final AutoSubsystem autoSubsystem;

    // //inicialização do objeto base
    // public AutoCommand(AutoSubsystem autoSubsystem) {
    //     this.autoSubsystem = autoSubsystem;
    //     addRequirements(autoSubsystem);
    // }
    public AutoCommand(AutoSubsystem autoSubsystem){
        addCommands(
            
        );
    }
    

  
}
