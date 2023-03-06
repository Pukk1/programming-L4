package L3.humans;

import L3.action.SmallBoyAction;
import L3.data.DataFromRoom;
import L3.data.Reactions;
import L3.reaction.PrintReaction;
import L3.reaction.SmallBoyReaction;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

public class SmallBoy extends Human implements PrintReaction {
    //    поле уровня эмоциональности
    private int level_of_emotionality = 0;

    public SmallBoy(String name) {
        super(name);
    }

    @Override
    public Reactions reactToRoomState(DataFromRoom dataFromRoom) {
        SmallBoyReaction smallBoyReaction = new SmallBoyReaction(dataFromRoom);

//        запускаем реакцию малыша, чтобы получить изменение уровня его эмоциональности
        level_of_emotionality = level_of_emotionality + smallBoyReaction.react();

//        запускаем действие малыша, чтобы получить их результатом изменения в комнате
//        возвращаем измененния в состоянии комнаты
        return new SmallBoyAction().doAction(level_of_emotionality);
    }

    @Override
    public void printFaceReaction(FaceReaction face) {
        if (face == FaceReaction.SMILE) {
            System.out.println(getName() + " улыбается");
        } else {
            System.out.println(getName() + " спокоен");
        }
    }

    @Override
    public void printNoiseReaction(NoiseReaction noiseReaction) {
        if (noiseReaction == NoiseReaction.LAUGHTER) {
            System.out.println(getName() + " смеётся");
        } else {
            System.out.println("Наступает тишина");
        }
    }

    @Override
    public int hashCode() {
        return (10);
    }

    @Override
    public String toString() {
        return ("Это объект smallBoy, который реагирует на происходящее и в зависимости от этого принимает какие-то действия и сам изменяет среду. Имеет хэш: " + hashCode());
    }
}
