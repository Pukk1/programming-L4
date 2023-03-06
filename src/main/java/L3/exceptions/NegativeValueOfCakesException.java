package L3.exceptions;

public class NegativeValueOfCakesException extends RuntimeException {
    private final int startNumberCakesInRoom;
    private final Class<?> classWhereExceptionOccurs;

    public NegativeValueOfCakesException(Class<?> classWhereExceptionOccurs, int startNumberCakesInRoom) {
        this.classWhereExceptionOccurs = classWhereExceptionOccurs;
        this.startNumberCakesInRoom = startNumberCakesInRoom;
    }

    @Override
    public String getMessage() {

        return StandardExceptionMessenger.createStandardExceptionMessage(classWhereExceptionOccurs, this.getClass()) +
                "Ошибка произошла из-за отрицательного количества пирожков в комнате:" + startNumberCakesInRoom + " .";
    }
}
