package L3.humans;

import L3.data.ReactionsData;
import L3.data.RoomStateData;
import org.jetbrains.annotations.NotNull;

public abstract class Human {

    public abstract ReactionsData reactToRoomState(RoomStateData roomStateData);

    @NotNull
    private final String name;

    public Human(@NotNull String name) {
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

    public @NotNull String getName() {
        return name;
    }
}
