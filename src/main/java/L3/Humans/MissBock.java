package L3.Humans;

import L3.Action.MissBockAction;
import L3.ChangesMadeByPeople;
import L3.DataFromRoom;
import L3.Reaction.MissBockReaction;

public class MissBock extends Human {


    //    поле уровня эмоциональности
    private int level_of_emotionality = 0;
    private boolean missBockTurn = false;

    @Override
    public ChangesMadeByPeople looksListensReacts(DataFromRoom dataFromRoom, String missBockName) {
        MissBockReaction missBockReaction = new MissBockReaction();
        MissBockAction missBockAction = new MissBockAction();


//        запускаем реакцию Фрекен Бок, что получить изменение уровня эмоциональности
        level_of_emotionality = level_of_emotionality + missBockReaction.start(dataFromRoom);

//        запускаем действия, производимые Фрекен Бок, которые возвращают изменения в состоянии комнаты
        ChangesMadeByPeople changesMadeByPeople = missBockAction.start(level_of_emotionality, missBockName);

//        если эмоциональность выще 5 поворацивается
        if (level_of_emotionality > 5) {
            missBockTurn = true;
        }

//        возвращает изменения
        return changesMadeByPeople;
    }

    //    метод вызываемый из room для проверки повернулась ли Мисс Бок
    public boolean isMissBockTurn() {
        return missBockTurn;
    }


    @Override
    public int hashCode() {
        return (11); //1 - Human, 1 - MissBock
    }

    @Override
    public String toString() {
        return ("Это объект missBock, который реагирует на происходящее и в зависимости от этого принимает какие-то действия и сам изменяет среду. Может повернуться и спалить Карлсона. Имеет хэш: " + hashCode());
    }
}
