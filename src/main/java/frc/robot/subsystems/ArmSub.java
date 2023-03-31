package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ArmSub extends SubsystemBase {

private static WPI_TalonFX armMotor;
    
    public ArmSub() {

        armMotor = new WPI_TalonFX(Constants.ArmCan);
        
    }

    @Override
    public void periodic() {
      
    }

    @Override
    public void simulationPeriodic() {
       
    }

    public void my_set(double speed) {
        armMotor.set(speed);
    }


}

