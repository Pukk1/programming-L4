package L3.humans;

import L3.data.Reactions;
import L3.data.DataFromRoom;

public abstract class Human {

    public abstract Reactions reactToRoomState(DataFromRoom dataFromRoom);
    private final String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (hashCode() / 10 == obj.hashCode() / 10) {
            System.out.println("Объекты являются наследниками одного класса");
        } else {
            System.out.println("Объекты не являются наследниками одного класса");
        }
        if (hashCode() % 10 == obj.hashCode() % 10) {
            System.out.println("Объекты принадлежат одному и тому же человеку");
        } else {
            System.out.println("Объекты не принадлежат одному и тому же человеку");
        }
        return hashCode() == obj.hashCode();
    }

    public String getName() {
        return name;
    }
}
