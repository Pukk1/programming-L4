package L3;

public class DataFromRoom{
    public int number_of_cakes;
    public int start_number_of_cakes;
    public Noise noise = Noise.SILENCE;
    public FaceReaction faceReaction = FaceReaction.CALMFACE;

    public DataFromRoom(int number_of_cakes, int start_number_of_cakes, Noise noise, FaceReaction faceReaction) {
        this.number_of_cakes = number_of_cakes;
        this.start_number_of_cakes = start_number_of_cakes;
        this.noise = noise;
        this.faceReaction = faceReaction;
    }

    public DataFromRoom() {
    }
}
