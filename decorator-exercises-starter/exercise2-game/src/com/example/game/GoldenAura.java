package com.example.game;

/**
 * Concrete decorator that adds golden aura effect to a character.
 * Changes sprite and provides small buffs to both speed and damage.
 */
public class GoldenAura extends CharacterDecorator {
    private final int auraSpeedBonus = 2;
    private final int auraDamageBonus = 5;
    
    public GoldenAura(Character character) {
        super(character);
    }
    
    @Override
    public void move() {
        System.out.println("Moving with GOLDEN AURA [SHINE] at speed " + getSpeed() + " with sprite " + getSprite());
    }
    
    @Override
    public void attack() {
        System.out.println("Attacking with GOLDEN AURA [SHINE] for " + getDamage() + " damage using sprite " + getSprite());
    }
    
    @Override
    public int getSpeed() {
        return character.getSpeed() + auraSpeedBonus;
    }
    
    @Override
    public int getDamage() {
        return character.getDamage() + auraDamageBonus;
    }
    
    @Override
    public String getSprite() {
        return "golden_" + character.getSprite();
    }
}
