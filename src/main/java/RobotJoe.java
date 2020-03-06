import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * RobotJoe - a robot by Georgios
 */
public class RobotJoe extends Robot {
    /**
     * run: RobotJoe's default behavior
     */
    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:

        setColors(Color.pink, Color.orange, Color.green); // body,gun,radar

        // Robot main loop
        while (true) {
            cantTouchThis();
        }
    }

    private void cantTouchThis() {
        int rand = (int) (Math.random() * ((4 - 1) + 1)) + 1;
        if (rand == 1) {
            ahead(Math.random());
        } else if (rand == 2) {
            back(Math.random());
        } else if (rand == 3) {
            turnLeft(Math.random());
        } else {
            turnRight(Math.random());
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        double scanned = e.getHeading();
        double myHeading = getHeading();
        turnGunRight(e.getBearingRadians());
        if (scanned - myHeading > 0) {
            turnLeft(scanned - myHeading);
        } else {
            turnRight(scanned - myHeading);
        }
        fire(Rules.MAX_BULLET_POWER);
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(10);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        double heading = getHeading();

    }
}
