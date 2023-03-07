package L3.data;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

public class ReactionsData {
    @NotNull
    private NoiseReaction noiseReaction /*= Noise.SILENCE*/;
    @NotNull
    private FaceReaction faceReaction /*= FaceReaction.CALMFACE*/;

    public ReactionsData(@NotNull NoiseReaction noiseReaction, @NotNull FaceReaction faceReaction) {
        this.noiseReaction = noiseReaction;
        this.faceReaction = faceReaction;
    }

    public @NotNull NoiseReaction getNoiseReaction() {
        return noiseReaction;
    }

    public @NotNull FaceReaction getFaceReaction() {
        return faceReaction;
    }
}
