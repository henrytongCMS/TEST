package com.physicssimulation;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Ball extends JPanel {

    final double g = 9.834;

    private double r;
    private double x;
    private double y;
    private double dx;
    private double dy;
    private double dt;

    /**
     * Class constructor
     * 
     * @param r radius
     * @param x position x
     * @param y position y
     * @param dx velocity x
     * @param dy velocity y
     * @param dt time-step
     */
    public Ball (double r, double x, double y, double dx, double dy, double dt) {
        
        this.r = r;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.dt = dt;

    }

    public void bounch(double decay) throws InterruptedException {

        do {
                
            x += dx * dt;
            y += dy * dt + 0.5 * g * dt * dt;

            dx -= decay * dx;
            dy += g * dt;
            dy -= decay * dy;

            if ( x+r >= 350 || x-r <= 0 )
                dx = -dx;

            if ( y+r >= 350 )
                dy = -dy;

            repaint();
            System.out.printf("(x=%.2f, y=%.2f, dx=%.2f, dy=%.2f)%n", x, y, dx, dy);
            Thread.sleep(10);

        } while( Math.abs(dx) > 0.0 || Math.abs(dy) > 0.0 );

    }

    @Override
    public void paint(Graphics g) {
    	
        super.paint(g);
        g.fillOval((int)x, (int)y, (int)r, (int)r);
        
    }

}