package L3.Action;

import L3.ChangesMadeByPeople;
import L3.FaceReaction;
import L3.Noise;

public class MissBockAction implements HumanAction {
    private ChangesMadeByPeople changes = new ChangesMadeByPeople();
    private String name;

    @Override
    public ChangesMadeByPeople start(int level_of_emotionality, String name) {

        this.name = name;

        if (level_of_emotionality > 1) {
            setFace(FaceReaction.BLUSH);
        } else {
            setFace(FaceReaction.CALMFACE);
        }
        if (level_of_emotionality > 2) {
            setNoise(Noise.GROAN);
        } else {
            setNoise(Noise.SILENCE);
        }
        return changes;
    }

    private void setFace(FaceReaction face) {

        changes.faceReaction = face;
        if (face == FaceReaction.BLUSH) {
            System.out.println(name + " краснеет");
        } else {
            System.out.println(name + " спокойна и пьёт кофе");
        }
    }

    ;

    private void setNoise(Noise noise) {

        changes.noise = noise;
        if (noise == Noise.GROAN) {
            System.out.println(name + " охает");
        } else {
            System.out.println("Наступает тишина");
        }
    }

    @Override
    public int hashCode() {
        return (31);
    } //3 - HumanAction, 1 - MissBock


    @Override
    public String toString() {
        return ("Это объект missBockAction, Который в зависимости от уровня эмоциональности missBock порождает действия, которые изменяют окружающую среду. Имеет хэш: " + hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (hashCode() / 10 == obj.hashCode() / 10) {
            System.out.println("Объекты являются наследниками одного класса");
        } else {
            System.out.println("Объекты не являются наследниками одного класса");
        }
        if (hashCode() % 10 == obj.hashCode() % 10) {
            System.out.println("Объекты принадлежат одному и тому же человеку");
        } else {
            System.out.println("Объекты не принадлежат одному и тому же человеку");
        }
        if (hashCode() == obj.hashCode()) {
            return (true);
        } else {
            return (false);
        }
    }
}
