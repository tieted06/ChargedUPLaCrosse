package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSub;

public class Claw extends CommandBase {

    private final ClawSub m_clawSub;
 
    public Claw(ClawSub subsystem) {

        m_clawSub = subsystem;
        addRequirements(m_clawSub);

    }
  
    @Override
    public void initialize() {
        m_clawSub.my_set(DoubleSolenoid.Value.kForward);
    }
    
    
    @Override
    public void execute() {

        }
    
    @Override
    public void end(boolean interrupted) {
        m_clawSub.my_set(DoubleSolenoid.Value.kReverse);
       }
   
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        
        return false;

        
    }
}
