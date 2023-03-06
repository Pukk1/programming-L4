package L3.reaction;

import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public interface PrintReaction {
    void printNoiseReaction(NoiseReaction noiseReaction);

    void printFaceReaction(FaceReaction faceReaction);
}
