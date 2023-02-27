package L3.Humans;

import L3.Action.SmallBoyAction;
import L3.ChangesMadeByPeople;
import L3.DataFromRoom;
import L3.Reaction.SmallBoyReaction;

public class SmallBoy extends Human{
    //    поле уровня эмоциональности
    private int level_of_emotionality = 0;




    @Override
    public ChangesMadeByPeople looksListensReacts(DataFromRoom dataFromRoom) {
        SmallBoyReaction smallBoyReaction = new SmallBoyReaction();
        SmallBoyAction smallBoyAction = new SmallBoyAction();

//        запускаем реакцию малыша, чтобы получить изменение уровня его эмоциональности
        level_of_emotionality = level_of_emotionality + smallBoyReaction.start(dataFromRoom);

//        запускаем действие малыша, чтобы получить их результатом изменения в комнате
        ChangesMadeByPeople changesMadeByPeople = smallBoyAction.start(level_of_emotionality, getHumanName());

//        возвращаем измененния в состоянии комнаты
        return changesMadeByPeople;
    }
    @Override
    public int hashCode(){
        return(10);
    }

    @Override
    public String toString(){
        return("Это объект smallBoy, который реагирует на происходящее и в зависимости от этого принимает какие-то действия и сам изменяет среду. Имеет хэш: " + hashCode());
    }
    @Override
    public String getHumanName(){
        return "";
    }
}
