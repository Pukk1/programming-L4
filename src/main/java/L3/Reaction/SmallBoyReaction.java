package L3.Reaction;

import L3.DataFromRoom;
import L3.FaceReaction;
import L3.Noise;

public class SmallBoyReaction implements HumanReaction {

    private int number_of_cakes;
    private int start_number_of_cakes;
    private FaceReaction faceReaction;
    private Noise noise;

    @Override
    public int start(DataFromRoom dataFromRoom) {
        number_of_cakes = dataFromRoom.number_of_cakes;
        start_number_of_cakes = dataFromRoom.start_number_of_cakes;
        faceReaction = dataFromRoom.faceReaction;
        noise = dataFromRoom.noise;
        return (excite() + settleDown());
    }


    private int settleDown() {
        int change_level_of_emotionality = 0;

        if (faceReaction == FaceReaction.CALMFACE) {
            change_level_of_emotionality--;
        }
        if (noise == Noise.SILENCE) {
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
        if (noise == Noise.GROAN) {
            change_level_of_emotionality += 2;
        }
        if (noise == Noise.GRUNT) {
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