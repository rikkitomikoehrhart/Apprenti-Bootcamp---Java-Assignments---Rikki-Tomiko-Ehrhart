package org.example.spells;
import org.example.Spell;

public class IllusionSpell implements Spell {
    String incantation = "phantasma veil";
    String name = "Shadowself";
    String description = "Makes you appear as through you are a shadow.";

    @Override
    public void cast() {
        System.out.println("The air ripples as a perfect illusion cloaks your form, making you appear like a shadow of yourself.");
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
