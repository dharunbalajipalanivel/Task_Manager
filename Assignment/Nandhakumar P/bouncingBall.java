import java.applet.Applet;
import java.awt.*;
import java.util.Random;

/*
 * <Applet code=bouncingBall width=400 height=400>
 * </Applet>
 * 
 * 
 */

public class bouncingBall extends Applet implements Runnable {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int BALL_SIZE = 50;
    private static final int SPEED = 5;

    private int ballX, ballY;
    private int velocityX, velocityY;
    private Thread animationThread;

    public void init() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Initialize the ball's position and velocity
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        Random random = new Random();
        velocityX = random.nextInt(2) == 0 ? SPEED : -SPEED;
        velocityY = random.nextInt(2) == 0 ? SPEED : -SPEED;
    }

    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    public void stop() {
        if (animationThread != null) {
            animationThread.interrupt();
            animationThread = null;
        }
    }

    public void run() {
        while (true) {
            moveBall();
            repaint();
            try {
                Thread.sleep(16); // Delay for smooth animation (approximately 60 frames per second)
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void moveBall() {
        // Update the ball's position based on its velocity
        ballX += velocityX;
        ballY += velocityY;

        // Reverse the ball's direction if it reaches the edges of the applet window
        if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
            velocityX = -velocityX;
        }
        if (ballY <= 0 || ballY >= HEIGHT - BALL_SIZE) {
            velocityY = -velocityY;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Draw the ball
        g.setColor(Color.red);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
    }
}