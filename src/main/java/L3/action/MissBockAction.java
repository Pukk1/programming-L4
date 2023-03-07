package L3.action;

import L3.data.ReactionsData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class MissBockAction implements HumanAction {

    @Override
    public ReactionsData doAction(int levelOfEmotionality) {
        FaceReaction faceReaction;
        NoiseReaction noiseReaction;

        if (levelOfEmotionality > 1) {
            faceReaction = FaceReaction.BLUSH;
        } else {
            faceReaction = FaceReaction.CALMFACE;
        }

        if (levelOfEmotionality > 2) {
            noiseReaction = NoiseReaction.GROAN;
        } else {
            noiseReaction = NoiseReaction.SILENCE;
        }

        return new ReactionsData(noiseReaction, faceReaction);
    }

    @Override
    public String toString() {
        return "Это объект missBockAction, Который в зависимости от уровня эмоциональности missBock порождает действия, которые изменяют окружающую среду. Имеет хэш: " + hashCode();
    }
}
