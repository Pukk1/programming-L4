package L3;

import L3.humans.Human;
import L3.humans.MissBock;
import L3.humans.SmallBoy;

public enum StoryCharacter {
    SMALL_BOY(SmallBoy.class),
    MISS_BOCK(MissBock.class);

    private final Class<? extends Human> humanClassMap;

    private StoryCharacter(Class<? extends Human> human) {
        this.humanClassMap = human;
    }

    public Class<? extends Human> getHumanClassMap() {
        return humanClassMap;
    }
}
