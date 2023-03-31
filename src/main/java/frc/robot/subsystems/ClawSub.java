package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;


public class ClawSub extends SubsystemBase {
    

    private static DoubleSolenoid grabSolenoid;
    


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

    public void my_set(Value direction) {
        grabSolenoid.set(direction);
    }

    public void my_Claw_Close() {
        grabSolenoid.set(Value.kReverse);
    }
    public void my_Claw_Open() {
        grabSolenoid.set(Value.kForward);
    }

    
}

