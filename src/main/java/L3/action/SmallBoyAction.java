package L3.action;

import L3.data.ReactionsData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class SmallBoyAction implements HumanAction {

    @Override
    public ReactionsData doAction(int levelOfEmotionality) {
        NoiseReaction noiseReaction;
        FaceReaction faceReaction;

        if (levelOfEmotionality > 1) {
            faceReaction = FaceReaction.SMILE;
        } else {
            faceReaction = FaceReaction.CALMFACE;
        }

        if (levelOfEmotionality > 2) {
            noiseReaction = NoiseReaction.LAUGHTER;
        } else {
            noiseReaction = NoiseReaction.SILENCE;
        }

        return new ReactionsData(noiseReaction, faceReaction);
    }

    @Override
    public String toString() {
        return "Это объект smallBoyAction, Который в зависимости от уровня эмоциональности smallBoy порождает" +
                " действия, которые изменяют окружающую среду. Имеет хэш: " + hashCode();
    }
}
