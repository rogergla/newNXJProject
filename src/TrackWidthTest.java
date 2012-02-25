
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

/**
 *
 * @author glassey
 */
public class TrackWidthTest
{

  /**
   *test track width. 
   * Adjust track width to get accurate 90 degree rotations
   */
  public static void main(String[] args)
  {
    DifferentialPilot pilot = new DifferentialPilot(5.35f, 11.7f, Motor.A, Motor.C);
    pilot.setRotateSpeed(180);
    pilot.setAcceleration(100);
    Delay.msDelay(200);
    for (int i = 0; i < 4; i++)
    {
      pilot.rotate(90);
    }
    Button.waitForAnyPress();
       Delay.msDelay(200);
    for (int i = 0; i < 4; i++)
    {
      pilot.rotate(-90);
    }
  }
}
