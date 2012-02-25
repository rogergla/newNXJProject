
import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * What this class does:
 * @authors Logan Esenther, James Yein, Valerie Wang
 */
// use Refactor to rename this class to work with NXJMain as you revised it
public class PolyTracer
{
public PolyTracer(DifferentialPilot pilot)
  {
    this.pilot = pilot;
    Motor.A.setAcceleration(3000);
    Motor.C.setAcceleration(100);
    pilot.setTravelSpeed(25);
    pilot.setRotateSpeed(180);
  }

  public void arc(float radius,  float  angle, int turnDirection)
  {
    LCD.drawString("Arc ", 0, 0);
    Button.waitForAnyPress();
    pilot.arc(radius, turnDirection * angle); 
  }

  /* Travel forward a distance in ft at a speed in degrees per second.
   */
  public void polygon(float length, int sides, int turnDirection)
  {
    LCD.drawString("Polygon", 0, 0);
    Button.waitForAnyPress();

    for (int i = 1; i <= sides; i++)
    {
      pilot.travel(length);
      pilot.rotate(turnDirection * 360 / sides);
    }
  }
 DifferentialPilot pilot;
}