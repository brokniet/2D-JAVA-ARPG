package game;

public class GameLoop implements Runnable{

    private boolean running;
    private int FPS = 60;
    private double drawInterval = (double) 1000000000 / FPS;

    @Override
    public void run() {
        running = true;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1) {
                update();
                render();
                delta--;
            }
        }
    }

    public void update() {

    }

    public void render() {

    }
}
