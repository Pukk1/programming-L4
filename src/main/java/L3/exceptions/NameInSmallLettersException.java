package L3.exceptions;

public class NameInSmallLettersException extends Exception {
    private final String exceptionName;
    private final Class<?> classWhereExceptionOccurs;

    public NameInSmallLettersException(String exceptionName, Class<?> classWhereExceptionOccurs) {
        this.classWhereExceptionOccurs = classWhereExceptionOccurs;
        this.exceptionName = exceptionName;
    }

    @Override
    public String getMessage() {
        return StandardExceptionMessenger.createStandardExceptionMessage(classWhereExceptionOccurs, this.getClass()) +
                "Ошибка произошла в первой букве: " + exceptionName.charAt(0) + ", которая является маленькой в имени: " + exceptionName + ".";
    }
}
