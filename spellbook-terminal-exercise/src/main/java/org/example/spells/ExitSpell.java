package org.example.spells;
import org.example.Spell;

public class ExitSpell implements Spell {
    String name = "Quit";
    String description = "Opens a portal to another dimension beneath your feet!";

    @Override
    public void cast() {
        System.out.println("A portal opens beneath your feet. Goodbye, wizard!");
        System.exit(0);
    }

    @Override
    public String getIncantation() {
        return "quit";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getHelp() {
        return String.format("%s\t\t\t\t%s\t\t\t\t\t%s", this.getName(), this.getIncantation(), this.getDescription());
    }
}
