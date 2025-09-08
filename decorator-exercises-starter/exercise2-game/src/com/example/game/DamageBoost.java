package com.example.game;

/**
 * Concrete decorator that adds damage boost to a character.
 */
public class DamageBoost extends CharacterDecorator {
    private final int damageIncrease;
    
    public DamageBoost(Character character, int damageIncrease) {
        super(character);
        this.damageIncrease = damageIncrease;
    }
    
    @Override
    public void attack() {
        System.out.println("Attacking with DAMAGE BOOST for " + getDamage() + " damage using sprite " + getSprite());
    }
    
    @Override
    public int getDamage() {
        return character.getDamage() + damageIncrease;
    }
}
