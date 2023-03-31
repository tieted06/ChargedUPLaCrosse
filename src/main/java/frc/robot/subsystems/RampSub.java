package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RampSub extends SubsystemBase {

  private static DoubleSolenoid rampSolenoid;

  public RampSub() {
    rampSolenoid = new DoubleSolenoid(Constants.PCMCan, PneumaticsModuleType.CTREPCM, Constants.rampSol1, Constants.rampSol2);

  }

  @Override
  public void periodic() {
    
  }

public void my_set(Value direction) {
  rampSolenoid.set(direction);
}
}
