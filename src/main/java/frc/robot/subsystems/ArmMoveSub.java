/*package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmMoveSub extends SubsystemBase {
    private static WPI_TalonFX armMotor;
    private static PIDController pidController;
    private final SimpleMotorFeedforward feedforward;
    
    private static final double kP = Constants.ArmPIDkP;
    private static final double kI = Constants.ArmPIDkI;
    private static final double kD = Constants.ArmPIDkD;
    private static final double kF = Constants.ArmPIDkF;
    private static final double kRotationsPerPulse = Constants.ArmRot_Per_Pulse;

    private static final double kMaxOutput = 0.5;
    private static final double kMinOutput = -0.5;

    public ArmMoveSub() {
        armMotor = new WPI_TalonFX(11);
        armMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.IntegratedSensor, 0, 0);

        pidController = new PIDController(kP, kI, kD);
        feedforward = new SimpleMotorFeedforward(kF, 0.0);
       // ShuffleboardTab tab = Shuffleboard.getTab("PID Controller");
        //tab.add("PID Controller", pidController);

    }

    public static void setPosition(double setpoint) {
        pidController.setSetpoint(setpoint);
    }

    public void setOutputRange(double minOutput, double maxOutput) {
        //pidController.setOutputRange(minOutput, maxOutput);  Not sure if what is below is the correct substitution
        pidController.setIntegratorRange(0.1, 0.5);
    }
    public static void resetEncoder() {
      // Reset the motor's integrated encoder to zero
      armMotor.setSelectedSensorPosition(0);
    
    }

    public static void stopmotors(){
      armMotor.set(0);
    }

      
  

    @Override
    public void periodic() {
        double position = armMotor.getSelectedSensorPosition() * kRotationsPerPulse;
        double velocity = armMotor.getSelectedSensorVelocity();

        double output = pidController.calculate(position);
        output += feedforward.calculate(pidController.getSetpoint(), velocity);

        output = Math.max(output, kMinOutput);
        output = Math.min(output, kMaxOutput);

        armMotor.set(output);

        SmartDashboard.putNumber("Position", position);
        SmartDashboard.putNumber("Output", output);
        
    }
}
*/