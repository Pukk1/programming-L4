package L3;

import L3.Humans.MissBock;
import L3.Humans.SmallBoy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        =============================================================
//        Локальный класс
//        Класс принимает данные от пользователя
        class UserInteraction {
            public String missBockName() {
                Scanner scan = new Scanner(System.in);
                System.out.println("Какое имя будет у объекта missBock?");
                return scan.nextLine();
            }

            public String smallBoyName() {
                Scanner scan = new Scanner(System.in);
                System.out.println("Какое имя будет у объекта smallBoy?");
                return scan.nextLine();
            }

            public int startNumberOfCakesInRoom() {
                Scanner scan = new Scanner(System.in);
                System.out.println("Сколько изначально было пирожков");
                https:
//drive.google.com/drive/folders/1JjEhaeYTgelwwVKuEHEV-io17qahks-U?usp=sharing
                return scan.nextInt();
            }
        }
//        =============================================================

        RoomCreator.createRoom(new UserInteraction().missBockName(), new UserInteraction().smallBoyName(), new UserInteraction().startNumberOfCakesInRoom());
    }

    //    =============================================================
//    Вложенный класс
//    Класс создаёт комнату
    private static class RoomCreator {
        public static void createRoom(String missBockName, String smallBoyName, int startNumberOfCakesInRoom) {

            int numberOfMassiveNameInSmallLettersExceptionElement = 0;
            NameInSmallLettersException[] massiveNameInSmallLettersException = new NameInSmallLettersException[2];
            int numberOfMassiveNegativeValueOfCakesExceptionElements = 0;
            NegativeValueOfCakesException[] massiveNegativeValueOfCakesExceptions = new NegativeValueOfCakesException[1];


//            Обработка первого исключения=========================
            try {
                if (!Character.isUpperCase(missBockName.charAt(0))) {
                    throw new NameInSmallLettersException(missBockName, RoomCreator.class);
                }

            } catch (NameInSmallLettersException ne) {
                massiveNameInSmallLettersException[numberOfMassiveNameInSmallLettersExceptionElement] = ne;
                numberOfMassiveNameInSmallLettersExceptionElement++;
                missBockName = (Character.toUpperCase(missBockName.charAt(0)) + missBockName.substring(1, missBockName.length()));
            } finally {
                try {
                    if (!Character.isUpperCase(smallBoyName.charAt(0))) {
                        throw new NameInSmallLettersException(smallBoyName, RoomCreator.class);
                    }

                } catch (NameInSmallLettersException ne) {
                    massiveNameInSmallLettersException[numberOfMassiveNameInSmallLettersExceptionElement] = ne;
                    numberOfMassiveNameInSmallLettersExceptionElement++;
                    smallBoyName = (Character.toUpperCase(smallBoyName.charAt(0)) + smallBoyName.substring(1, smallBoyName.length()));
                }
            }
//            ===================================================

            final String mN /* missName */ = missBockName;
            final String bN /* boyName*/ = smallBoyName;

//            =============================================================
//            Обработка второго исключения
            boolean error = false;
            try {
                if (startNumberOfCakesInRoom < 0) {
                    throw new NegativeValueOfCakesException(RoomCreator.class, startNumberOfCakesInRoom);
                }
            } catch (NegativeValueOfCakesException ne) {
                massiveNegativeValueOfCakesExceptions[numberOfMassiveNegativeValueOfCakesExceptionElements] = ne;
                numberOfMassiveNegativeValueOfCakesExceptionElements++;
                System.out.println("Введено отрицательное число пирожов, программа не может быть выполнена!");
                error = true;
            } finally {
                if (error == false) {
                    new Room(new MissBock() {
                        @Override
                        public String getHumanName() {
                            return mN;
                        }
                    },
                            new SmallBoy() {
                                @Override
                                public String getHumanName() {
                                    return bN;
                                }
                            }, startNumberOfCakesInRoom).startActionInRoom();
                } else {
                    System.out.println("Программа завершилась ошибкой.");
                    for (int i = 0; i < numberOfMassiveNegativeValueOfCakesExceptionElements; i++) {
                        System.out.println(massiveNegativeValueOfCakesExceptions[i].getMessage());
                    }
                }
                if (numberOfMassiveNameInSmallLettersExceptionElement != 0) {
                    for (int i = 0; i < numberOfMassiveNameInSmallLettersExceptionElement; i++) {
                        System.out.println(massiveNameInSmallLettersException[i].getMessage());
                    }
                }
            }
        }
    }
//    =============================================================
}