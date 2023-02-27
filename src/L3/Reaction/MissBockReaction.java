package L3.Reaction;

import L3.DataFromRoom;
import L3.FaceReaction;
import L3.Noise;

public class MissBockReaction implements HumanReaction{

    private FaceReaction faceReaction;
    private Noise noise;

    @Override
    public int start(DataFromRoom dateFromRoom){
        noise = dateFromRoom.noise;
        faceReaction = dateFromRoom.faceReaction;
        return(excite()+settleDown());
    }


    private int settleDown(){
        int change_level_of_emotionality = 0;

        if (faceReaction == FaceReaction.CALMFACE) {
            change_level_of_emotionality--;
        }
        if (noise == Noise.SILENCE) {
            change_level_of_emotionality--;
        }

        return change_level_of_emotionality;
    }


    private int excite(){
        int change_level_of_emotionality = 0;

        if (faceReaction == FaceReaction.SMILE) {
            change_level_of_emotionality += 2;
        }
        if (noise == Noise.LAUGHTER){
            change_level_of_emotionality += 2;
        }
        if (noise == Noise.GROAN) {
            change_level_of_emotionality += 10;
        }
        return change_level_of_emotionality;
    }

    @Override
    public int hashCode(){
        return(21);
    }

    @Override
    public String toString(){
        return("Это объект missBockReaction, который реагирует на происходящее и возвращает уровень эмоциональности. Имеет хэш: " + hashCode());
    }
    @Override
    public boolean equals(Object obj){
        if(hashCode()/10 == obj.hashCode()/10){
            System.out.println("Объекты являются наследниками одного класса");
        }
        else {
            System.out.println("Объекты не являются наследниками одного класса");
        }
        if(hashCode()%10 == obj.hashCode()%10){
            System.out.println("Объекты принадлежат одному и тому же человеку");
        }
        else {
            System.out.println("Объекты не принадлежат одному и тому же человеку");
        }
        if(hashCode() == obj.hashCode()){
            return(true);
        }
        else{
            return(false);
        }
    }
}
