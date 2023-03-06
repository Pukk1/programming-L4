package L3;

import L3.exceptions.NameInSmallLettersException;
import L3.exceptions.NegativeValueOfCakesException;
import L3.humans.MissBock;
import L3.humans.SmallBoy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Room room = StoryInit.initRoom();
            room.startHistory();
        } catch (NameInSmallLettersException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static class StoryInit {
        private static Scanner scanner;

        private static String initHumanName(StoryCharacter storyCharacter) throws NameInSmallLettersException {
            System.out.println("Какое имя будет у объекта класса " + storyCharacter.getHumanClassMap().getName() + " ?");
            String name = scanner.nextLine();

            if (!Character.isUpperCase(name.charAt(0))) {
                throw new NameInSmallLettersException(name, StoryInit.class);
            }

            return name;
        }

        private static int initStartCakesNumber() {
            System.out.println("Сколько изначально было пирожков");
            int startNumberOfCakesInRoom = scanner.nextInt();

            if (startNumberOfCakesInRoom < 0) {
                throw new NegativeValueOfCakesException(StoryInit.class, startNumberOfCakesInRoom);
            }

            return startNumberOfCakesInRoom;
        }

        public static Room initRoom() throws NameInSmallLettersException {
            scanner = new Scanner(System.in);
            String missBockName = initHumanName(StoryCharacter.MISS_BOCK);
            MissBock missBock = new MissBock(missBockName);

            String smallBoyName = initHumanName(StoryCharacter.SMALL_BOY);
            SmallBoy smallBoy = new SmallBoy(smallBoyName);

            return new Room(missBock, smallBoy, initStartCakesNumber());
        }
    }
}