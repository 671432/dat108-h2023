package animatedballs;

public class BallTraad extends Thread {

    Ball ball;

    BallTraad(Ball ball){
        this.ball = ball;
    }
    @Override
    public void run() {
        ball.animate();
    }
}
