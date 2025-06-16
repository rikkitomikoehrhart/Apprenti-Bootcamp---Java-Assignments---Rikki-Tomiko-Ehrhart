package org.example.spells;
import org.example.Spell;

public class EvocationSpell implements Spell {
    String incantation = "pyros erupta";
    String name = "Fireball";
    String description = "Hurls a ball of fire from your hand.";

    @Override
    public void cast() {
        System.out.println("A swirling orb of flame erupts from your hands and detonates with a thunderous boom!");
    }

    @Override
    public String getIncantation() {
        return incantation;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getHelp() {
        return String.format("%s\t\t\t%s\t\t\t%s", this.getName(), this.getIncantation(), this.getDescription());
    }
}
