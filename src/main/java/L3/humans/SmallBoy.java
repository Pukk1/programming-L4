package L3.humans;

import L3.action.SmallBoyAction;
import L3.data.RoomStateData;
import L3.data.ReactionsData;
import L3.reaction.PrintReaction;
import L3.reaction.SmallBoyReaction;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class SmallBoy extends Human implements PrintReaction {
    private int levelOfEmotionality = 0;

    public SmallBoy(String name) {
        super(name);
    }

    @Override
    public ReactionsData reactToRoomState(RoomStateData roomStateData) {
        SmallBoyReaction smallBoyReaction = new SmallBoyReaction(roomStateData);
        levelOfEmotionality = levelOfEmotionality + smallBoyReaction.reactToRoomState();
        return new SmallBoyAction().doAction(levelOfEmotionality);
    }

    @Override
    public void printFaceReaction(FaceReaction face) {
        if (face == FaceReaction.SMILE) {
            System.out.println(getName() + " улыбается");
        } else {
            System.out.println(getName() + " спокоен");
        }
    }

    @Override
    public void printNoiseReaction(NoiseReaction noiseReaction) {
        if (noiseReaction == NoiseReaction.LAUGHTER) {
            System.out.println(getName() + " смеётся");
        } else {
            System.out.println("Наступает тишина");
        }
    }

    @Override
    public String toString() {
        return ("Это объект smallBoy, который реагирует на происходящее и в зависимости от этого принимает какие-то действия и сам изменяет среду. Имеет хэш: " + hashCode());
    }
}
