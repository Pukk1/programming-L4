package L3.humans;

import L3.action.MissBockAction;
import L3.data.Reactions;
import L3.data.DataFromRoom;
import L3.reaction.MissBockReaction;
import L3.reaction.PrintReaction;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class MissBock extends Human implements PrintReaction {


    //    поле уровня эмоциональности
    private int level_of_emotionality = 0;

    public MissBock(String name) {
        super(name);
    }

    @Override
    public Reactions reactToRoomState(DataFromRoom dataFromRoom) {
        MissBockReaction missBockReaction = new MissBockReaction(dataFromRoom);
        MissBockAction missBockAction = new MissBockAction();

//        запускаем реакцию Фрекен Бок, что получить изменение уровня эмоциональности
        level_of_emotionality = level_of_emotionality + missBockReaction.react();

//        запускаем действия, производимые Фрекен Бок, которые возвращают изменения в состоянии комнаты
//        возвращает изменения
        return missBockAction.doAction(level_of_emotionality);
    }

    //    метод вызываемый из room для проверки повернулась ли Мисс Бок
    public boolean isMissBockTurn() {
        return level_of_emotionality > 5;
    }

    public void printTurn() {
        System.out.println(getName() + " резко поворачивается. Карлсон был спален!!!");
    }

    @Override
    public void printFaceReaction(FaceReaction faceReaction) {
        if (faceReaction == FaceReaction.BLUSH) {
            System.out.println(getName() + " краснеет");
        } else {
            System.out.println(getName() + " спокойна и пьёт кофе");
        }
    }

    ;

    @Override
    public void printNoiseReaction(NoiseReaction noiseReaction) {
        if (noiseReaction == NoiseReaction.GROAN) {
            System.out.println(getName() + " охает");
        } else {
            System.out.println("Наступает тишина");
        }
    }

    @Override
    public int hashCode() {
        return (11); //1 - Human, 1 - MissBock
    }

    @Override
    public String toString() {
        return ("Это объект missBock, который реагирует на происходящее и в зависимости от этого принимает какие-то " +
                "действия и сам изменяет среду. Может повернуться и спалить Карлсона. Имеет хэш: " + hashCode());
    }
}
