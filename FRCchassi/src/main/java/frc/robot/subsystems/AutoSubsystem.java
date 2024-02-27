package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort.Port;;

public class AutoSubsystem extends SubsystemBase{
    //declara o encoder do NEO
    private final RelativeEncoder neoEncoder;

    //declara o IMU

    AHRS navX = new AHRS(Port.kMXP);

    //declara os objetos subsistemas
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final CollectorSubsystem collectorSubsystem;
    private final LauncherSubsystem launcherSubsystem;

    //inicializa os objetos
    public AutoSubsystem(DriveTrainSubsystem driveTrainSubsystem, CollectorSubsystem collectorSubsystem, 
    LauncherSubsystem launcherSubsystem, RelativeEncoder neoEncoder) {
        this.driveTrainSubsystem = driveTrainSubsystem;
        this.collectorSubsystem = collectorSubsystem;
        this.launcherSubsystem = launcherSubsystem;
        this.neoEncoder = collectorSubsystem.colMotorReverse.getEncoder();
    }
    
    public void driveWithEncoder(double autoDirection, double autoSpeed, double autoDistance, double ke){
        neoEncoder.setPosition(0);
        double autoSaida = autoSpeed * autoDirection;
        double distPerc = neoEncoder.getPosition()*ke; 
        while (distPerc<autoDistance) {
            //anda para frente por padrão
            driveTrainSubsystem.frontLeft.set(-autoSaida);//para frente
            driveTrainSubsystem.frontRight.set(autoSaida);//para frente
        }
    }

    public void spinWithIMU(double autoDirection, double autoSpeed, double autoAngle){

    }

    public void launchNoteAutomatic(){

    }
}


// private final double autoDirection;