package L3.data;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ReactionsData {
    @NotNull
    private NoiseReaction noiseReaction /*= Noise.SILENCE*/;
    @NotNull
    private FaceReaction faceReaction /*= FaceReaction.CALMFACE*/;

    public ReactionsData(@NotNull NoiseReaction noiseReaction, @NotNull FaceReaction faceReaction) {
        this.noiseReaction = noiseReaction;
        this.faceReaction = faceReaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReactionsData reactionsData = (ReactionsData) o;
        return noiseReaction == reactionsData.noiseReaction && faceReaction == reactionsData.faceReaction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noiseReaction, faceReaction);
    }

    public @NotNull NoiseReaction getNoiseReaction() {
        return noiseReaction;
    }

    public void setNoiseReaction(@NotNull NoiseReaction noiseReaction) {
        this.noiseReaction = noiseReaction;
    }

    public @NotNull FaceReaction getFaceReaction() {
        return faceReaction;
    }

    public void setFaceReaction(@NotNull FaceReaction faceReaction) {
        this.faceReaction = faceReaction;
    }
}
