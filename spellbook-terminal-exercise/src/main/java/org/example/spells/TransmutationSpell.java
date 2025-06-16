package org.example.spells;
import org.example.Spell;

public class TransmutationSpell implements Spell {
    String incantation = "mutare forma";
    String name = "Transformation";
    String description = "Transforms an object of your choosing into a new object of your choosing.";


    @Override
    public void cast() {
        System.out.println("The object in your hand shimmers and reshapes itself into something entirely new!");
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
        return String.format("%s\t\t%s\t\t\t%s", this.getName(), this.getIncantation(), this.getDescription());
    }
}
