package L3.reaction;

import L3.data.RoomStateData;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

public class MissBockReaction implements HumanReaction {

    @NotNull
    private final FaceReaction faceReaction;
    @NotNull
    private final NoiseReaction noiseReaction;

    public MissBockReaction(@NotNull FaceReaction faceReaction, @NotNull NoiseReaction noiseReaction) {
        this.faceReaction = faceReaction;
        this.noiseReaction = noiseReaction;
    }

    public MissBockReaction(RoomStateData roomStateData) {
        this(roomStateData.getFaceReaction(), roomStateData.getNoiseReaction());
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

        return changeLevelOfEmotionality;
    }


    private int excite() {
        int changeLevelOfEmotionality = 0;

        if (faceReaction == FaceReaction.SMILE) {
            changeLevelOfEmotionality += 2;
        }
        if (noiseReaction == NoiseReaction.LAUGHTER) {
            changeLevelOfEmotionality += 2;
        }
        if (noiseReaction == NoiseReaction.GROAN) {
            changeLevelOfEmotionality += 10;
        }
        return changeLevelOfEmotionality;
    }

    @Override
    public String toString() {
        return ("Это объект missBockReaction, который реагирует на происходящее и возвращает уровень эмоциональности. Имеет хэш: " + hashCode());
    }
}
