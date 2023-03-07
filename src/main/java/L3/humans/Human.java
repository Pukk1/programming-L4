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

    public @NotNull String getName() {
        return name;
    }
}
