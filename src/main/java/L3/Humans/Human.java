package L3.Humans;

import L3.ChangesMadeByPeople;
import L3.DataFromRoom;

public abstract class Human {

    public abstract ChangesMadeByPeople looksListensReacts(DataFromRoom dataFromRoom, String name);

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
