package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        System.out.println("\n=== Character Power-ups and Decorators ===\n");
        
        // a) Base + SpeedBoost + DamageBoost
        System.out.println("1. Adding Speed and Damage Boosts:");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        System.out.println("Stats: Speed=" + buffed.getSpeed() + ", Damage=" + buffed.getDamage() + ", Sprite=" + buffed.getSprite());
        buffed.move();
        buffed.attack();
        
        // b) Add GoldenAura (sprite change + buffs)
        System.out.println("\n2. Adding Golden Aura:");
        Character shiny = new GoldenAura(buffed);
        System.out.println("Stats: Speed=" + shiny.getSpeed() + ", Damage=" + shiny.getDamage() + ", Sprite=" + shiny.getSprite());
        shiny.move();
        shiny.attack();
        
        // c) Remove GoldenAura by recomposing (rebuild chain without it)
        System.out.println("\n3. Removing Golden Aura (recomposition):");
        Character withoutAura = buffed; // removal by recomposition
        System.out.println("Stats: Speed=" + withoutAura.getSpeed() + ", Damage=" + withoutAura.getDamage() + ", Sprite=" + withoutAura.getSprite());
        withoutAura.move();
        withoutAura.attack();
        
        // Additional demonstration: Multiple layers
        System.out.println("\n4. Multiple Speed Boosts:");
        Character speedDemon = new SpeedBoost(new SpeedBoost(new SpeedBoost(base, 2), 3), 5);
        System.out.println("Stats: Speed=" + speedDemon.getSpeed() + ", Damage=" + speedDemon.getDamage() + ", Sprite=" + speedDemon.getSprite());
        speedDemon.move();
        speedDemon.attack();
        
        // Mix and match
        System.out.println("\n5. Ultimate Character (All Buffs):");
        Character ultimate = new GoldenAura(
            new DamageBoost(
                new SpeedBoost(base, 10), 
                25
            )
        );
        System.out.println("Stats: Speed=" + ultimate.getSpeed() + ", Damage=" + ultimate.getDamage() + ", Sprite=" + ultimate.getSprite());
        ultimate.move();
        ultimate.attack();
    }
}
