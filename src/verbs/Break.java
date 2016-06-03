package verbs;

import java.util.Arrays;

import core.*;

public class Break extends Verb {

    public Break() {
        super("break",
                Arrays.asList("shatter", "destroy"),
                Verb.usage().noun());
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Item noun = command.getNoun();
        construct.getPlayer();

        if (noun != null) {
            if (!noun.name().equals("noItem")) {
                if (noun.usage().breakable() == Item.UNBROKEN) {
                    // TODO: find a better way to destroy something
                    noun.usage().visible(Item.HIDDEN)
                        .breakable(Item.BROKEN);
                    System.out.println("You broke the " + noun.name());
                } else if (noun.usage().breakable() == Item.BROKEN) {
                    System.out.println("The " + noun.name()
                            + " is already broken.");
                } else {
                    System.out.println("You can't break the " + noun.name());
                }
            } else {
                System.out.println("Ya need a noun, ya dingus.");
            }
        } else {
            System.out.println("Where do you expect to find one of those?");
        }

    }
}
