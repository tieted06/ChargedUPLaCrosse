package frc.robot.commands;
import edu.wpi.first.math.MathUtil;
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
        m_armSub.my_set(
            deadband(RobotContainer.getInstance().getArmClawStick().getRawAxis(Constants.armClawstickYaxis)
                       * ((1 + RobotContainer.getInstance().getArmClawStick().getRawAxis(Constants.armSpeed))
                              / Constants.potvalueMOD)));
    }

    private double deadband(double speed){
        return MathUtil.applyDeadband(speed, .1);
    }

    @Override
    public void end(boolean interrupted) {
        m_armSub.my_set(0);
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
