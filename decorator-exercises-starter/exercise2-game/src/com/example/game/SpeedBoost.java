package com.example.game;

/**
 * Concrete decorator that adds speed boost to a character.
 */
public class SpeedBoost extends CharacterDecorator {
    private final int speedIncrease;
    
    public SpeedBoost(Character character, int speedIncrease) {
        super(character);
        this.speedIncrease = speedIncrease;
    }
    
    @Override
    public void move() {
        System.out.println("Moving with SPEED BOOST at speed " + getSpeed() + " with sprite " + getSprite());
    }
    
    @Override
    public int getSpeed() {
        return character.getSpeed() + speedIncrease;
    }
}
