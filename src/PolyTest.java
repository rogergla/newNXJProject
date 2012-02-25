



import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Test the PolyTracer   
 * @author Roger
 * @version 1.0
 */
public class PolyTest 
{ 
/**
   * Constructs a the robot and drives it through the project specifications
   * @param aArg 
   */
    public static void main(String[] aArg) 
    {
      DifferentialPilot pilot = new DifferentialPilot(5.35f, 11.7f, Motor.A, Motor.C);
      PolyTracer robot = new PolyTracer(pilot);   
      robot.polygon(24*2.54f, 3,1);
      robot.polygon(24*2.54f, 5, -1);
      robot.arc(36*2.54f,180,1);
      robot.arc(12*2.54f,90,-1);
    }  
}