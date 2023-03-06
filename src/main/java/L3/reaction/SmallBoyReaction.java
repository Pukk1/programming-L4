package L3.reaction;

import L3.data.DataFromRoom;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class SmallBoyReaction implements HumanReaction {

    private final int number_of_cakes;
    private final int start_number_of_cakes;
    private final FaceReaction faceReaction;
    private final NoiseReaction noiseReaction;

    public SmallBoyReaction(int number_of_cakes, int start_number_of_cakes, FaceReaction faceReaction, NoiseReaction noiseReaction) {
        this.number_of_cakes = number_of_cakes;
        this.start_number_of_cakes = start_number_of_cakes;
        this.faceReaction = faceReaction;
        this.noiseReaction = noiseReaction;
    }

    public SmallBoyReaction(DataFromRoom dataFromRoom) {
        this(dataFromRoom.getNumberOfCakes(), dataFromRoom.getStartNumberOfCakes(), dataFromRoom.getFaceReaction(), dataFromRoom.getNoiseReaction());
    }

    @Override
    public int react() {
        return excite() + settleDown();
    }


    private int settleDown() {
        int change_level_of_emotionality = 0;

        if (faceReaction == FaceReaction.CALMFACE) {
            change_level_of_emotionality--;
        }
        if (noiseReaction == NoiseReaction.SILENCE) {
            change_level_of_emotionality--;
        }

        if (number_of_cakes == start_number_of_cakes) {
            change_level_of_emotionality--;
        }
        return change_level_of_emotionality;
    }


    private int excite() {
        int change_level_of_emotionality = 0;

        if (faceReaction == FaceReaction.BLUSH) {
            change_level_of_emotionality += 2;
        }
        if (noiseReaction == NoiseReaction.GROAN) {
            change_level_of_emotionality += 2;
        }
        if (noiseReaction == NoiseReaction.GRUNT) {
            change_level_of_emotionality += 10;
        }
        change_level_of_emotionality += start_number_of_cakes - number_of_cakes;
        return change_level_of_emotionality;
    }

    @Override
    public int hashCode() {
        return (20);
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
        if (hashCode() == obj.hashCode()) {
            return (true);
        } else {
            return (false);
        }
    }
}