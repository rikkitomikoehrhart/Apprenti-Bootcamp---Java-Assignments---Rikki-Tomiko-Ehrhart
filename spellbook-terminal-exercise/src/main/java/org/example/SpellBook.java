package org.example;
import org.example.spells.*;
import java.util.ArrayList;

public class SpellBook {
    ArrayList<Spell> spells = new ArrayList<>();

    public SpellBook() {
        this.spells.add(new ConjurationSpell());
        this.spells.add(new EvocationSpell());
        this.spells.add(new TransmutationSpell());
        this.spells.add(new IllusionSpell());
        this.spells.add(new ExitSpell());
    }

    public void tryIncantation(String incantation) {
        if (incantation.equalsIgnoreCase("help")) {
            help();
        } else {
            for (Spell spell : spells) {
                if (spell.getIncantation().equalsIgnoreCase(incantation)) {
                    spell.cast();
                    return;
                }
            }
            System.out.println("The spell fizzled out! Try again.");
        }
    }

    public void help() {
        System.out.println("Spell\t\t\t\tIncantation\t\t\t\tDescription");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");

        for (Spell spell : spells) {
            System.out.println(spell.getHelp());
        }
    }
}
