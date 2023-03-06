package L3.data;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RoomStateData {
    private int numberOfCakes;
    private int startNumberOfCakes;
    @NotNull
    private NoiseReaction noiseReaction /*= Noise.SILENCE*/;
    @NotNull
    private FaceReaction faceReaction /*= FaceReaction.CALMFACE*/;

    public RoomStateData(int numberOfCakes, int startNumberOfCakes, @NotNull NoiseReaction noiseReaction, @NotNull FaceReaction faceReaction) {
        this.numberOfCakes = numberOfCakes;
        this.startNumberOfCakes = startNumberOfCakes;
        this.noiseReaction = noiseReaction;
        this.faceReaction = faceReaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomStateData that = (RoomStateData) o;
        return numberOfCakes == that.numberOfCakes && startNumberOfCakes == that.startNumberOfCakes && noiseReaction == that.noiseReaction && faceReaction == that.faceReaction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCakes, startNumberOfCakes, noiseReaction, faceReaction);
    }

    public int getNumberOfCakes() {
        return numberOfCakes;
    }

    public void setNumberOfCakes(int numberOfCakes) {
        this.numberOfCakes = numberOfCakes;
    }

    public int getStartNumberOfCakes() {
        return startNumberOfCakes;
    }

    public void setStartNumberOfCakes(int startNumberOfCakes) {
        this.startNumberOfCakes = startNumberOfCakes;
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
