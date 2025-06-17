package org.example.spells;
import org.example.Spell;

public class ConjurationSpell implements Spell {
    String incantation = "invocatum luxor";
    String name = "Illuminate";
    String description = "Creates a floating lantern of starlight to light your path.";

    @Override
    public void cast() {
        System.out.println("You summon a floating lantern made of starlight that follows you and lights the path ahead.");
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
        return String.format("%-20s %-20s %s", this.getName(), this.getIncantation(), this.getDescription());
    }
}
