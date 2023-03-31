package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RampSub;

public class Ramp extends CommandBase {

  private final RampSub m_rampSub;


  public Ramp(RampSub subsystem) {

    m_rampSub = subsystem;
    addRequirements(m_rampSub);
  
  }

  @Override
  public void initialize() {
    m_rampSub.my_set(DoubleSolenoid.Value.kForward);

  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) { 
    
    m_rampSub.my_set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
