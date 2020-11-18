package chessObjectGame.board;

import lombok.Value;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Locale;
import java.util.Scanner;

@Value
public class Coordinates {
    int horizontalPositionOnBoard;
    int verticalPositionOnBoard;

    public static Coordinates createCoordinates(String input) {
        try {
            String normalizeInput = normalizeInput(input);
            int vertical = normalizeInput.split("")[0].trim().toUpperCase(Locale.ENGLISH).charAt(0) - 65;
            int horizontal = Integer.parseInt(normalizeInput.split("")[1].trim()) - 1;
            return new Coordinates(horizontal, vertical);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad command, use format eg. 'A1' ");
            Scanner scanner = new Scanner(System.in);
            return createCoordinates(scanner.nextLine());
        }
    }

    private static String normalizeInput(String input) {
        return StringUtils.defaultIfBlank(input.replaceAll("[^a-zA-Z0-9]", ""), "WRONG");
    }

    public static Pair<Integer, Integer> coordinatesDifference(Coordinates coordinates1, Coordinates coordinates2) {
        return Pair.of(coordinates2.getHorizontalPositionOnBoard() - coordinates1.getHorizontalPositionOnBoard(),
                coordinates2.getVerticalPositionOnBoard() - coordinates1.getVerticalPositionOnBoard());
    }

    public Coordinates addToHorizontal(int i) {
        return new Coordinates(this.getHorizontalPositionOnBoard() + i, this.getVerticalPositionOnBoard());
    }

    public Coordinates addToVertical(int i) {
        return new Coordinates(this.getHorizontalPositionOnBoard(), this.getVerticalPositionOnBoard() + i);
    }
}