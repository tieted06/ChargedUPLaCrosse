package frc.robot;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;




public class Robot extends TimedRobot {

    private Command m_autonomousCommand;
    private AddressableLED m_ledramp;
    
    private AddressableLEDBuffer m_ledBuffer;
   
    private RobotContainer m_robotContainer;
    private int m_rainbowFirstPixelHue;


    //Timer autotime = new Timer();
    UsbCamera camera1;
    UsbCamera camera2;
    NetworkTableEntry cameraSelection;
    
   
    @Override
    public void robotInit() {
        m_ledramp = new AddressableLED(9);
        m_ledBuffer = new AddressableLEDBuffer(280);
        m_ledramp.setLength(m_ledBuffer.getLength());
        m_ledramp.setData(m_ledBuffer);
        m_ledramp.start();
        
        camera1 = CameraServer.startAutomaticCapture(0);
       // camera2 = CameraServer.startAutomaticCapture(1);
        cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");

        m_robotContainer = RobotContainer.getInstance();
        HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_RobotBuilder);
    }

    
   

    private void greenbow() {
        // For every pixel
        for (var i = 0; i < 245; i++) {
          // Calculate the hue - hue is easier for rainbows because the color
          // shape is a circle so only one value needs to precess
          final var hue = (m_rainbowFirstPixelHue +(i  * 180  / m_ledBuffer.getLength())) % 180;
          
          // Set the value
          m_ledBuffer.setHSV(i, 50 , 255, hue);
        }
        // Increase by to make the rainbow "move"
        m_rainbowFirstPixelHue += 6;
        // Check bounds
        m_rainbowFirstPixelHue %= 180;
    }
    private void gamepieceRequest(){
        if(RobotContainer.getInstance().getArmClawStick().getRawButton(Constants.ConeCubeRequestButton)){
        for (var j=245; j < m_ledBuffer.getLength(); j++){
            m_ledBuffer.setHSV(j,130,255,128);
            }
        }else{
            for (var j=245; j < m_ledBuffer.getLength(); j++){
            m_ledBuffer.setHSV(j,30,255,128);}
        }
    }
    private void disabled(){
        for (var j=245; j < m_ledBuffer.getLength(); j++){
            m_ledBuffer.setHSV(j,0,255,128);}
    }
    private void greenbowSlow(){
        for (var i = 0; i <245; i++) {
            // Calculate the hue - hue is easier for rainbows because the color
            // shape is a circle so only one value needs to precess
            final var hue = (m_rainbowFirstPixelHue +(i  * 180  / m_ledBuffer.getLength())) % 180;
    
            // Set the value
            m_ledBuffer.setHSV(i, 50 , 255, hue);
          }
          // Increase by to make the rainbow "move"
          m_rainbowFirstPixelHue += 1;
          // Check bounds
          m_rainbowFirstPixelHue %= 180;

    }
    private void greenAuto(){
        for (var i=0; i < m_ledBuffer.getLength(); i++){
            m_ledBuffer.setHSV(i,50,255,128);}
    }

    private void auto(){
        var k = 0;
        for (var j=245; j < m_ledBuffer.getLength(); j++){
            m_ledBuffer.setHSV(j,k,255,128);
        k = k + 15;}
    }
    @Override
    public void robotPeriodic() {
         CommandScheduler.getInstance().run();
        
         
    }

        @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        greenbowSlow();
        disabled();
        m_ledramp.setData(m_ledBuffer);
    }

    
    @Override
    public void autonomousInit() {
       
      // autotime.reset();
       //autotime.start();
       
       
         m_autonomousCommand = m_robotContainer.getAutonomousCommand();

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }  
    }

    /**
    * This function is called periodically during autonomous.
    */
    @Override
    public void autonomousPeriodic() {
        greenAuto();
        auto();
        m_ledramp.setData(m_ledBuffer);
       CommandScheduler.getInstance().run();

    }

    @Override
    public void teleopInit() {
       
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    
    @Override
    public void teleopPeriodic() {
        greenbow();
        gamepieceRequest();
        m_ledramp.setData(m_ledBuffer);
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    
    @Override
    public void testPeriodic() {
    }

}