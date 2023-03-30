/*package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmMoveSub;




public class ArmIntake extends CommandBase {
    
  private final ArmMoveSub m_armMoveSub;
    public ArmIntake(ArmMoveSub subsystem) {
   
      m_armMoveSub = subsystem;
      addRequirements(m_armMoveSub);

    }

    @Override
    public void initialize() {
        // Reset the encoder to zero
        
    }
    @Override
    public void execute() {
        ArmMoveSub.setPosition(Constants.ConeIntakeRotation);
        

        // Set the motor speed
        
    }

    @Override
    public boolean isFinished() {
      return false;
        // Return true if the motor has reached the target position
        
    }

    @Override
    public void end(boolean interrupted) {
        // Stop the motor
        ArmMoveSub.setPosition(0);
        
    }
}
 */