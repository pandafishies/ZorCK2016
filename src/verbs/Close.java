package verbs;

import java.util.Arrays;

import core.*;

public class Close extends Verb {

    public Close() {
        super("close",
                Arrays.asList("shut"),
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
                if (noun.usage().open() == Item.OPEN) {
                    noun.usage().open(Item.CLOSED);
                    System.out.println("You closed the " + noun.name());
                } else if (noun.usage().open() == Item.CLOSED) {
                    System.out.println(noun.name() + " is already closed");
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
