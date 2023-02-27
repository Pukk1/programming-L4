package L3;

public class StandardMessageCreator {
    public static String createStandardExceptionMessage(Class classWhereExceptionOccurs,
                                                        Class exceptionClass){
        String standardException = "Произошло исключение вида:" + exceptionClass.getName() + ". " +
                "Оно произошло в объекте класса " + classWhereExceptionOccurs.getName() + ". ";
        return standardException;
    }
}
