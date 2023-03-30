package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;


public class ClawSub extends SubsystemBase {
    

    public static DoubleSolenoid grabSolenoid;
    


    public ClawSub() {

    grabSolenoid = new DoubleSolenoid(Constants.PCMCan,PneumaticsModuleType.CTREPCM, Constants.grabSol1, Constants.grabSOl2);
    addChild("GrabSolenoid", grabSolenoid);
 


    }

    @Override
    public void periodic() {
        
    }

    @Override
    public void simulationPeriodic() {
       
    }

    
}

