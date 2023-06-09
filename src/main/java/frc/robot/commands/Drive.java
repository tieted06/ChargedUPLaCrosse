package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSub;

public class Drive extends CommandBase {
    
    private final DriveSub m_driveSub;
 
    public Drive(DriveSub subsystem) {

        m_driveSub = subsystem;
        addRequirements(m_driveSub);
 
    }

    @Override
    public void initialize() {
    }

    
    @Override
    public void execute() {
        double speed = RobotContainer.getInstance().getDriveStick().getRawAxis(Constants.DrivestickYaxis)
        * ((1 + RobotContainer.getInstance().getArmClawStick().getRawAxis(Constants.driveSpeed))
                / Constants.potvalueMOD);

        double turn = RobotContainer.getInstance().getDriveStick().getRawAxis(Constants.DrivestickXaxis)
        * -1* ((1 + RobotContainer.getInstance().getArmClawStick().getRawAxis(Constants.driveSpeed))
                / Constants.turnSpeedMod);
        m_driveSub.my_Arcade(speed,turn,false);
    }

    
    @Override
    public void end(boolean interrupted) {
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
