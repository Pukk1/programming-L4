package L3.action;

import L3.data.Reactions;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class MissBockAction implements HumanAction {

    @Override
    public Reactions doAction(int level_of_emotionality) {
        FaceReaction faceReaction;
        NoiseReaction noiseReaction;

        if (level_of_emotionality > 1) {
            faceReaction = FaceReaction.BLUSH;
        } else {
            faceReaction = FaceReaction.CALMFACE;
        }

        if (level_of_emotionality > 2) {
            noiseReaction = NoiseReaction.GROAN;
        } else {
            noiseReaction = NoiseReaction.SILENCE;
        }

        return new Reactions(noiseReaction, faceReaction);
    }

    @Override
    public int hashCode() {
        //3 - HumanAction, 1 - MissBock
        return 31;
    }


    @Override
    public String toString() {
        return "Это объект missBockAction, Который в зависимости от уровня эмоциональности missBock порождает действия, которые изменяют окружающую среду. Имеет хэш: " + hashCode();
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
