package L3;

import L3.data.ReactionsData;
import L3.data.RoomStateData;
import L3.humans.MissBock;
import L3.humans.SmallBoy;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Room {

    @NotNull
    private final ConditionInRoom condition;


    public Room(MissBock missBock, SmallBoy smallBoy, int startNumberOfCakesInRoom) {
        this.condition = new ConditionInRoom(startNumberOfCakesInRoom, smallBoy, missBock);
    }

    public void startHistory() {
        SmallBoy smallBoy = condition.smallBoy;
        MissBock missBock = condition.missBock;

        while (condition.numberOfCakes != 0) {

            if (condition.isCarlsonGiveCake()) {
                condition.carlsonGiveCake();
                System.out.println("Карлсон взял пирожок");
            } else {
                System.out.println("Карлсон не взял пирожок");
            }

            ReactionsData boyReaction = smallBoy.reactToRoomState(condition.getDataFromRoom());
            condition.setChanges(boyReaction);
            smallBoy.printFaceReaction(condition.faceReactionInRoom);
            smallBoy.printNoiseReaction(condition.noiseReactionInRoom);

            ReactionsData missReaction = missBock.reactToRoomState(condition.getDataFromRoom());
            condition.setChanges(missReaction);
            missBock.printFaceReaction(condition.faceReactionInRoom);
            missBock.printNoiseReaction(condition.noiseReactionInRoom);

            System.out.println();
            if (condition.missBock.isMissBockTurn()) {
                condition.missBock.printTurn();
                condition.carlsonSpalen();
            }

        }
        if (condition.isCarlsonGoOut()) {
            System.out.println("Карлсон ушёл с пирожками");
        }
    }

    public @NotNull ConditionInRoom getCondition() {
        return condition;
    }

    public class ConditionInRoom {
        @NotNull
        private final SmallBoy smallBoy;
        @NotNull
        private final MissBock missBock;
        private final int startNumberOfCakes;
        @NotNull
        private NoiseReaction noiseReactionInRoom = NoiseReaction.SILENCE;
        @NotNull
        private FaceReaction faceReactionInRoom = FaceReaction.CALMFACE;
        private int numberOfCakes;
        private boolean isCarlsonSpalen = false;

        private ConditionInRoom(int startNumberOfCakes, @NotNull SmallBoy smallBoy, @NotNull MissBock missBock) {
            this.startNumberOfCakes = startNumberOfCakes;
            this.numberOfCakes = startNumberOfCakes;
            this.smallBoy = smallBoy;
            this.missBock = missBock;
        }

        public RoomStateData getDataFromRoom() {
            return new RoomStateData(
                    numberOfCakes,
                    startNumberOfCakes,
                    noiseReactionInRoom,
                    faceReactionInRoom
            );
        }

        public void setChanges(ReactionsData changes) {
            faceReactionInRoom = changes.getFaceReaction();
            noiseReactionInRoom = changes.getNoiseReaction();
        }

        public void carlsonGiveCake() {
            numberOfCakes--;
        }

        public boolean isCarlsonGiveCake() {
            return new Random().nextBoolean();
        }

        public void carlsonSpalen() {
            isCarlsonSpalen = true;
            numberOfCakes = 0;
        }

        public boolean isCarlsonGoOut() {
            return !isCarlsonSpalen & numberOfCakes == 0;
        }

        public @NotNull SmallBoy getSmallBoy() {
            return smallBoy;
        }

        public @NotNull MissBock getMissBock() {
            return missBock;
        }

        public int getStartNumberOfCakes() {
            return startNumberOfCakes;
        }

        public @NotNull NoiseReaction getNoiseReactionInRoom() {
            return noiseReactionInRoom;
        }

        public void setNoiseReactionInRoom(@NotNull NoiseReaction noiseReactionInRoom) {
            this.noiseReactionInRoom = noiseReactionInRoom;
        }

        public @NotNull FaceReaction getFaceReactionInRoom() {
            return faceReactionInRoom;
        }

        public void setFaceReactionInRoom(@NotNull FaceReaction faceReactionInRoom) {
            this.faceReactionInRoom = faceReactionInRoom;
        }

        public int getNumberOfCakes() {
            return numberOfCakes;
        }

        public void setNumberOfCakes(int numberOfCakes) {
            this.numberOfCakes = numberOfCakes;
        }

        public boolean isCarlsonSpalen() {
            return isCarlsonSpalen;
        }

        public void setCarlsonSpalen(boolean carlsonSpalen) {
            isCarlsonSpalen = carlsonSpalen;
        }
    }
}
