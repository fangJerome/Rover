public enum Direction {
    N, E, S, W;

    public static Direction parseDirection(String directionString) {
        switch (directionString) {
            case "N":
                return Direction.N;
            case "E":
                return Direction.E;
            case "S":
                return Direction.S;
            case "W":
                return Direction.W;
            default:
                throw new IllegalArgumentException("Direction invalide : " + directionString);
        }
    }

    public static Direction nextDirection(Direction actualDirection) {
        switch (actualDirection) {
            case N:
                return Direction.E;
            case E:
                return Direction.S;
            case S:
                return Direction.W;
            case W:
                return Direction.N;
            default:
                return actualDirection; // Pas de changement de direction
        }
    }

    public static Direction previousDirection(Direction actualDirection) {
        switch (actualDirection) {
            case N:
                return Direction.W;
            case E:
                return Direction.N;
            case S:
                return Direction.E;
            case W:
                return Direction.S;
            default:
                return actualDirection; // Pas de changement de direction
        }
    }
}
