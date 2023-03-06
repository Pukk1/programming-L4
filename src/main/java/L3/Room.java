package L3;

import L3.data.DataFromRoom;
import L3.data.Reactions;
import L3.humans.MissBock;
import L3.humans.SmallBoy;
import L3.reaction.enums.FaceReaction;
import L3.reaction.enums.NoiseReaction;

import java.util.Random;

public class Room {

    //    создадим класс "обстановка в комнате"
    private ConditionInRoom condition = new ConditionInRoom();
//    private Room.ConditionInRoom conditionInRoom = new Room.ConditionInRoom();


    public Room(MissBock missBock, SmallBoy smallBoy, int startNumberOfCakesInRoom) {
        condition.addPersons(missBock, smallBoy);
        condition.numberOfCakes = startNumberOfCakesInRoom;
    }

    public void startHistory() {
        while (condition.numberOfCakes != 0) {

//            карлсон решает, взять ли пирожок
            if (condition.isCarlsonGiveCake()) {
                condition.carlsonGiveCake();
                System.out.println("Карлсон взял пирожок");
            } else {
                System.out.println("Карлсон не взял пирожок");
            }
//            вызывается Малыш, которому передаются данные о комнате,
//            после возвращаемое малышом значение (Changes) передаётся в
//            метод, устанавливающий изменения в комнате
            condition.setChanges(condition.smallBoy.reactToRoomState(condition.getDataFromRoom()));
            condition.smallBoy.printFaceReaction(condition.faceReactionInRoom);
            condition.smallBoy.printNoiseReaction(condition.noiseReactionInRoom);

//            аналогично предыдущему пункту
            condition.setChanges(condition.missBock.reactToRoomState(condition.getDataFromRoom()));
            condition.missBock.printFaceReaction(condition.faceReactionInRoom);
            condition.missBock.printNoiseReaction(condition.noiseReactionInRoom);

            System.out.println();
            if (condition.missBock.isMissBockTurn()) {
                condition.missBock.printTurn();
                condition.carlsonSpalen();
            }

        }
        if (condition.isCarlsonGoOut()) {
            System.out.println("Карлсон ушёл с пирожками");
        }
    }

    //    Вложенный non-static класс
//    обстановка в комнате
    private class ConditionInRoom {

        //        все данные о комнате
        private int numberOfCakes = 7;
        private final int startNumberOfCakes = numberOfCakes;
        private NoiseReaction noiseReactionInRoom = NoiseReaction.SILENCE;
        private FaceReaction faceReactionInRoom = FaceReaction.CALMFACE;
        private final boolean carlsonInRoom = true;
        private boolean isCarlsonSpalen = false;
        private SmallBoy smallBoy;
        private MissBock missBock;


        //        метод предназначен для сбора всех данных о комнате в объект класса Data,
//        котрорый потом передаётся в оюъект одного из наследников класса Human
        public DataFromRoom getDataFromRoom() {
            return new DataFromRoom(
                    numberOfCakes,
                    startNumberOfCakes,
                    noiseReactionInRoom,
                    faceReactionInRoom
            );
        }

        //        метод устанавливает изменения в комнате, которые произошли из-за действий людей в ней
        public void setChanges(Reactions changes) {
            faceReactionInRoom = changes.getFaceReaction();
            noiseReactionInRoom = changes.getNoiseReaction();
        }

        public void addPersons(MissBock missBock, SmallBoy smallBoy) {
            this.missBock = missBock;
            this.smallBoy = smallBoy;
        }

        public void carlsonGiveCake() {
            numberOfCakes--;
        }

        public boolean isCarlsonGiveCake() {
            return new Random().nextBoolean();
        }

        public void carlsonSpalen() {
            isCarlsonSpalen = true;
            numberOfCakes = 0;
        }

        public boolean isCarlsonGoOut() {
            return !isCarlsonSpalen & numberOfCakes == 0;
        }
    }
}
