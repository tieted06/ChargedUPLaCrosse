package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSub;


public class Arm extends CommandBase {

       private final ArmSub m_armSub;
 
   

    public Arm(ArmSub subsystem) {


        m_armSub = subsystem;
        addRequirements(m_armSub);
    }
    @Override
    public void initialize() {
       
    }

    @Override
    public void execute() {
        ArmSub.armMotor.set(
            RobotContainer.getInstance().getArmClawStick().getRawAxis(Constants.armClawstickYaxis)
                       * ((1 + RobotContainer.getInstance().getArmClawStick().getRawAxis(Constants.armSpeed))
                              / Constants.potvalueMOD));
       //ArmSub.armMotor.set(.2);
    }

    @Override
    public void end(boolean interrupted) {
        ArmSub.armMotor.set(0);
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