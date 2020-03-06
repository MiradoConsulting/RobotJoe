import robocode.*;
import java.awt.Color;


public class RobotJoe extends AdvancedRobot {
    
    public void run() {
        setColors(Color.pink, Color.orange, Color.green); // body,gun,radar
        while (true) {
            turnRadarRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        double absBearing = e.getBearingRadians() + getHeadingRadians();
        double latVel = e.getVelocity() * Math.sin(e.getHeadingRadians() - absBearing);
        double gunTurnAmt;
        setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
        if (Math.random() > .9) {
            setMaxVelocity((12 * Math.random()) + 12);
        }
        if (e.getDistance() > 150) {
            gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing - getGunHeadingRadians() + latVel / 22);
            setTurnGunRightRadians(gunTurnAmt);
            setTurnRightRadians(
                    robocode.util.Utils.normalRelativeAngle(absBearing - getHeadingRadians() + latVel / getVelocity()));
            setAhead((e.getDistance() - 140) * getHeadingRadians());
            setFire(3);
        } else {// if we are close enough...
            gunTurnAmt = robocode.util.Utils.normalRelativeAngle(absBearing - getGunHeadingRadians() + latVel / 15);
            setTurnGunRightRadians(gunTurnAmt);// turn our gun
            setTurnLeft(-90 - e.getBearing()); // turn perpendicular to the enemy
            setAhead((e.getDistance() - 140) * getHeadingRadians());// move forward
            setFire(3);
        }
    }

    public void onHitWall(HitWallEvent e) {
        setAhead(-getHeadingRadians()); 
    }
}
