package L3.Action;

import L3.ChangesMadeByPeople;
import L3.FaceReaction;
import L3.Noise;

public class SmallBoyAction implements HumanAction {
    private ChangesMadeByPeople changes = new ChangesMadeByPeople();
    private String name;
    @Override
    public ChangesMadeByPeople start(int level_of_emotionality, String name){

        this.name = name;

        if(level_of_emotionality > 1){
            setFace(FaceReaction.SMILE);
        }
        else{
            setFace(FaceReaction.CALMFACE);
        }
        if(level_of_emotionality > 2){
            setNoise(Noise.LAUGHTER);
        }
        else{
            setNoise(Noise.SILENCE);
        }
        return changes;
    }

    private void setFace(FaceReaction face){
        changes.faceReaction = face;
        if(face == FaceReaction.SMILE) {
            System.out.println(name + " улыбается");
        }
        else{
            System.out.println(name + " спокоен");
        }
    };

    private void setNoise(Noise noise){
        changes.noise = noise;
        if(noise == Noise.LAUGHTER){
            System.out.println(name + " смеётся");
        }
        else {
            System.out.println("Наступает тишина");
        }
    }

    @Override
    public int hashCode(){
        return(30); //3 - HumanAction, 0 - SmallBoy
    }

    @Override
    public String toString(){
        return("Это объект smallBoyAction, Который в зависимости от уровня эмоциональности smallBoy порождает действия, которые изменяют окружающую среду. Имеет хэш: " + hashCode());
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
