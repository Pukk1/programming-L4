package L3;

import L3.Humans.MissBock;
import L3.Humans.SmallBoy;
import java.util.Random;

public class Room {

//    создадим класс "обстановка в комнате"
    private ConditionInRoom conditionInRoom = new ConditionInRoom();
//    private Room.ConditionInRoom conditionInRoom = new Room.ConditionInRoom();


    public Room(MissBock missBock, SmallBoy smallBoy, int startNumberOfCakesInRoom) {
        conditionInRoom.addPersons(missBock, smallBoy);
        conditionInRoom.numberOfCakes = startNumberOfCakesInRoom;
    }

    public void startActionInRoom() {



        while (conditionInRoom.numberOfCakes != 0){

//            карлсон решает, взять ли пирожок
            if(conditionInRoom.isCarlsonGiveCake()){
                conditionInRoom.carlsonGiveCake();
                System.out.println("Карлсон взял пирожок");
            }
            else {
                System.out.println("Карлсон не взял пирожок");
            }
//            вызывается Малыш, которому передаются данные о комнате,
//            после возвращаемое малышом значение (Changes) передаётся в
//            метод, устанавливающий изменения в комнате
            conditionInRoom.setChanges(conditionInRoom.smallBoy.looksListensReacts(conditionInRoom.getDataFromRoom()));

//            аналогично предыдущему пункту
            conditionInRoom.setChanges(conditionInRoom.missBock.looksListensReacts(conditionInRoom.getDataFromRoom()));

            System.out.println("");

            if(conditionInRoom.missBock.isMissBockTurn()){
                System.out.println(conditionInRoom.missBock.getHumanName() + " резко поворачивается. Карлсон был спален!!!");
                conditionInRoom.carlsonSpalen();
            }

        }
        if(conditionInRoom.isCarlsonGoOut()){
            System.out.println("Карлсон ушёл с пирожками");
        }
    }

//=============================================================
//    Вложенный non-static класс
//    обстановка в комнате
    private class ConditionInRoom{

//        все данные о комнате
        private int numberOfCakes = 7;
        private final int startNumberOfCakes = numberOfCakes;
        private Noise noiseInRoom = Noise.SILENCE;
        private FaceReaction faceInRoom = FaceReaction.CALMFACE;
        private boolean carlsonInRoom = true;
        private boolean isCarlsonSpalen = false;
        private SmallBoy smallBoy;
        private MissBock missBock;


//    метод предназначен для сбора всех данных о комнате в объект класса Data,
//    котрорый потом передаётся в оюъект одного из наследников класса Human
        public DataFromRoom getDataFromRoom(){
            DataFromRoom dataFromRoom = new DataFromRoom();
            dataFromRoom.faceReaction = faceInRoom;
            dataFromRoom.noise = noiseInRoom;
            dataFromRoom.number_of_cakes = numberOfCakes;
            dataFromRoom.start_number_of_cakes = startNumberOfCakes;
            return dataFromRoom;
        }

//    метод устанавливает изменения в комнате, которые произошли из-за действий людей в ней
        public void setChanges(ChangesMadeByPeople changes){
            faceInRoom = changes.faceReaction;
            noiseInRoom = changes.noise;
        }

        public void addPersons(MissBock missBock, SmallBoy smallBoy){
            this.missBock = missBock;
            this.smallBoy = smallBoy;
        }

        public void carlsonGiveCake(){
            numberOfCakes--;
        }

        public boolean isCarlsonGiveCake(){
            return new Random().nextBoolean();
        }

        public void carlsonSpalen(){
            isCarlsonSpalen = true;
            numberOfCakes = 0;
        }

        public boolean isCarlsonGoOut(){
            if(isCarlsonSpalen == false & numberOfCakes == 0){
                return true;
            }
            else {
                return false;
            }
        }
    }
}
