package L3.humans;

import L3.action.MissBockAction;
import L3.data.ReactionsData;
import L3.data.RoomStateData;
import L3.reaction.MissBockReaction;
import L3.reaction.PrintReaction;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

public class MissBock extends Human implements PrintReaction {
    private int levelOfEmotionality = 0;

    public MissBock(@NotNull String name) {
        super(name);
    }

    @Override
    public ReactionsData reactToRoomState(RoomStateData roomStateData) {
        MissBockReaction missBockReaction = new MissBockReaction(roomStateData);
        levelOfEmotionality += missBockReaction.reactToRoomState();
        return new MissBockAction().doAction(levelOfEmotionality);
    }

    public boolean isMissBockTurn() {
        return levelOfEmotionality > 5;
    }

    public void printTurn() {
        System.out.println(getName() + " резко поворачивается. Карлсон был спален!!!");
    }

    @Override
    public void printFaceReaction(FaceReaction faceReaction) {
        if (faceReaction == FaceReaction.BLUSH) {
            System.out.println(getName() + " краснеет");
        } else {
            System.out.println(getName() + " спокойна и пьёт кофе");
        }
    }

    @Override
    public void printNoiseReaction(NoiseReaction noiseReaction) {
        if (noiseReaction == NoiseReaction.GROAN) {
            System.out.println(getName() + " охает");
        } else {
            System.out.println("Наступает тишина");
        }
    }

    @Override
    public int hashCode() {
        return (11); //1 - Human, 1 - MissBock
    }

    @Override
    public String toString() {
        return ("Это объект missBock, который реагирует на происходящее и в зависимости от этого принимает какие-то " +
                "действия и сам изменяет среду. Может повернуться и спалить Карлсона. Имеет хэш: " + hashCode());
    }

    public int getLevelOfEmotionality() {
        return levelOfEmotionality;
    }

    public void setLevelOfEmotionality(int levelOfEmotionality) {
        this.levelOfEmotionality = levelOfEmotionality;
    }
}
