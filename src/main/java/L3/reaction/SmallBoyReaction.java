package L3.reaction;

import L3.data.RoomStateData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

public class SmallBoyReaction implements HumanReaction {

    private final int numberOfCakes;
    private final int startNumberOfCakes;
    @NotNull
    private final FaceReaction faceReaction;
    @NotNull
    private final NoiseReaction noiseReaction;

    public SmallBoyReaction(int numberOfCakes, int startNumberOfCakes, @NotNull FaceReaction faceReaction, @NotNull NoiseReaction noiseReaction) {
        if (numberOfCakes < 0) {
            throw new IllegalArgumentException("numberOfCakes should be bigger than 0");
        }
        if (numberOfCakes > startNumberOfCakes) {
            throw new IllegalArgumentException("numberOfCakes can't be bigger then startNumberOfCakes");
        }

        this.numberOfCakes = numberOfCakes;
        this.startNumberOfCakes = startNumberOfCakes;
        this.faceReaction = faceReaction;
        this.noiseReaction = noiseReaction;
    }

    public SmallBoyReaction(RoomStateData roomStateData) {
        this(roomStateData.getNumberOfCakes(), roomStateData.getStartNumberOfCakes(), roomStateData.getFaceReaction(), roomStateData.getNoiseReaction());
    }

    @Override
    public int reactToRoomState() {
        return excite() + calming();
    }


    private int calming() {
        int changeLevelOfEmotionality = 0;

        if (faceReaction == FaceReaction.CALMFACE) {
            changeLevelOfEmotionality--;
        }
        if (noiseReaction == NoiseReaction.SILENCE) {
            changeLevelOfEmotionality--;
        }

        if (numberOfCakes == startNumberOfCakes) {
            changeLevelOfEmotionality--;
        }
        return changeLevelOfEmotionality;
    }


    private int excite() {
        int changeLevelOfEmotionality = 0;

        if (faceReaction == FaceReaction.BLUSH) {
            changeLevelOfEmotionality += 2;
        }
        if (noiseReaction == NoiseReaction.GROAN) {
            changeLevelOfEmotionality += 2;
        }
        if (noiseReaction == NoiseReaction.GRUNT) {
            changeLevelOfEmotionality += 10;
        }
        changeLevelOfEmotionality += startNumberOfCakes - numberOfCakes;
        return changeLevelOfEmotionality;
    }

    @Override
    public int hashCode() {
        return 20;
    }

    @Override
    public String toString() {
        return ("Это объект smallBoyReaction, который реагирует на происходящее и возвращает уровень эмоциональности. Имеет хэш: " + hashCode());
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
}