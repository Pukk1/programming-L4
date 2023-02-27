package L3;

public class NegativeValueOfCakesException extends RuntimeException{
    int startNumberCakesInRoom;
    Class classWhereExceptionOccurs;
    public NegativeValueOfCakesException(Class classWhereExceptionOccurs, int startNumberCakesInRoom){
        this.classWhereExceptionOccurs = classWhereExceptionOccurs;
        this.startNumberCakesInRoom = startNumberCakesInRoom;
    }
    @Override
    public String getMessage(){

        String massage = StandardMessageCreator.createStandardExceptionMessage(classWhereExceptionOccurs, this.getClass()) +
                "Ошибка произошла из-за отрицательного количества пирожков в комнате:" + startNumberCakesInRoom + " .";
        return massage;
    }

//    private String generateMessage(){
//        String createdMessage = "Произошло исключение вида:" + this.getClass().getName() + " ." +
//                "Оно произошло в объекте класса " + classWhereExceptionOccurs.getName() + " ." +
//                "Ошибка произошла из-за отрицательного количества пирожков в комнате:" + startNumberCakesInRoom + " .";
//        return createdMessage;
//    }

}
