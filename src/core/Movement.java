package core;

import entity.Entity;
import input.InputHandler;

public class Movement {

    private Entity entity;

    public Movement(Entity entity) {
        this.entity = entity;
    }

    public void movePlayer(InputHandler inputHandler) {
        int dx = 0;
        int dy = 0;

        if(inputHandler.upPressed) {
            dy -= 1;
            entity.setAnimation("walkUp");
        }
        if(inputHandler.downPressed) {
            dy += 1;
            entity.setAnimation("walkDown");
        }
        if(inputHandler.leftPressed) {
            dx -= 1;
            entity.setAnimation("walkLeft");
        }
        if(inputHandler.rightPressed) {
            dx += 1;
            entity.setAnimation("walkRight");
        }

        //normalizeVector(dx, dy);
        entity.setX(entity.getX() + (dx * entity.getSpeed()));
        entity.setY(entity.getY() + (dy * entity.getSpeed()));

        if(entity.getCurrentAnimation() != null) entity.getCurrentAnimation().update();
    }

    //no cambia para nada el movimiento del player, necesita fix? esta funcion deberia devolver los dx y dy modificados btw
    private void normalizeVector(int dx, int dy) {
        if (dx != 0 || dy != 0) {
            double length = Math.sqrt(dx * dx + dy * dy);
            dx /= (int) length;
            dy /= (int) length;
        }
    }

}
