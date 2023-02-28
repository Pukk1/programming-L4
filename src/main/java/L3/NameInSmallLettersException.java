package L3;

public class NameInSmallLettersException extends Exception {
    private String exceptionName;
    private Class classWhereExceptionOccurs;

    public NameInSmallLettersException(String exceptionName, Class classWhereExceptionOccurs) {
        this.classWhereExceptionOccurs = classWhereExceptionOccurs;
        this.exceptionName = exceptionName;
    }

    @Override
    public String getMessage() {
        String massage = StandardMessageCreator.createStandardExceptionMessage(classWhereExceptionOccurs, this.getClass()) +
                "Ошибка произошла в первой букве: " + exceptionName.charAt(0) + ", которая является маленькой в имени: " + exceptionName + ".";
        return massage;
    }
}
