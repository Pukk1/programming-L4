package L3.exceptions;

public class StandardExceptionMessenger {
    public static String createStandardExceptionMessage(Class<?> classWhereExceptionOccurs,
                                                        Class<?> exceptionClass) {
        return "Произошло исключение вида:" + exceptionClass.getName() + ". " +
                "Оно произошло в объекте класса " + classWhereExceptionOccurs.getName() + ". ";
    }
}
