package verbs;

import java.util.Arrays;

import core.*;

public class Open extends Verb {

    public Open() {
        super("open",
                Arrays.asList("unseal"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        final Item noun = command.getNoun();

        construct.getPlayer();
        construct.getWorld();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                if (noun.usage().open() == Item.CLOSED) {
                    if (noun.usage().lock() != Item.LOCKED) {
                        noun.usage().open(Item.OPEN);
                        System.out.println("You opened the " + noun.name());
                    } else {
                        System.out.println(noun.name() + " is locked");
                    }
                } else if (noun.usage().open() == Item.OPEN) {
                    System.out.println(noun.name() + " is already open");
                } else {
                    System.out.println("I don't see how you expect to do that");
                }
            } else {
                System.out.println("Ya need a noun, ya dingus");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }
    }
}
