package L3.data;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class DataFromRoom {
    private int numberOfCakes;
    private int startNumberOfCakes;
    private NoiseReaction noiseReaction /*= Noise.SILENCE*/;
    private FaceReaction faceReaction /*= FaceReaction.CALMFACE*/;

    public DataFromRoom(int numberOfCakes, int startNumberOfCakes, NoiseReaction noiseReaction, FaceReaction faceReaction) {
        this.numberOfCakes = numberOfCakes;
        this.startNumberOfCakes = startNumberOfCakes;
        this.noiseReaction = noiseReaction;
        this.faceReaction = faceReaction;
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

    public NoiseReaction getNoiseReaction() {
        return noiseReaction;
    }

    public void setNoiseReaction(NoiseReaction noiseReaction) {
        this.noiseReaction = noiseReaction;
    }

    public FaceReaction getFaceReaction() {
        return faceReaction;
    }

    public void setFaceReaction(FaceReaction faceReaction) {
        this.faceReaction = faceReaction;
    }
}
