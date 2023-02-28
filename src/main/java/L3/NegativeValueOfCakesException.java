package L3;

public class NegativeValueOfCakesException extends RuntimeException {
    private int startNumberCakesInRoom;
    private Class classWhereExceptionOccurs;

    public NegativeValueOfCakesException(Class classWhereExceptionOccurs, int startNumberCakesInRoom) {
        this.classWhereExceptionOccurs = classWhereExceptionOccurs;
        this.startNumberCakesInRoom = startNumberCakesInRoom;
    }

    @Override
    public String getMessage() {

        String massage = StandardMessageCreator.createStandardExceptionMessage(classWhereExceptionOccurs, this.getClass()) +
                "Ошибка произошла из-за отрицательного количества пирожков в комнате:" + startNumberCakesInRoom + " .";
        return massage;
    }
}
