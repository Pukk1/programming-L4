package L3.data;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class Reactions {
    private NoiseReaction noiseReaction /*= Noise.SILENCE*/;
    private FaceReaction faceReaction /*= FaceReaction.CALMFACE*/;

    public Reactions(NoiseReaction noiseReaction, FaceReaction faceReaction) {
        this.noiseReaction = noiseReaction;
        this.faceReaction = faceReaction;
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
