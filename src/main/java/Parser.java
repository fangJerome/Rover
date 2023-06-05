import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    public static void main(String[] args) {

        String filePathName = "./src/main/resources/sampleInput.txt";
        if(args!=null && args.length>0){
            filePathName = args[0];
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathName))) {
            String line = reader.readLine();
            if (line != null) {
                // Parsing de la première ligne
                String[] firstLine = line.trim().split("\\s+");
                /*System.out.println("Taille du plateau :");
                for (String element : firstLine) {
                    System.out.println(element);
                }*/
            }

            //System.out.println("\nLignes suivantes par Rovers :");

            String initPositionLine;
            String commandPositionLine;

            while ((initPositionLine = reader.readLine()) != null && (commandPositionLine = reader.readLine()) != null) {
                //System.out.println("Position initiale:"+initPositionLine + "\nListe commandes: " + commandPositionLine);
                moveToNewPosition(initPositionLine, commandPositionLine);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String moveToNewPosition(String initPositionLine, String commandPositionLine) {
        String[] startingParts = initPositionLine.split(" ");

        //Fixe position initiale
        Position position = new Position();
        position.setPositionX(Integer.valueOf(startingParts[0]));
        position.setPositionY(Integer.valueOf(startingParts[1]));
        Direction initDirection = Direction.parseDirection(startingParts[2]);


        //splitter chaque lettre
        String[] letters = new String[commandPositionLine.length()];
        for (int i = 0; i < commandPositionLine.length(); i++) {
            letters[i] = String.valueOf(commandPositionLine.charAt(i));
        }
        //Determiner action
        for (String letter : letters) {
            //System.out.println("Direction actuel : "+initDirection+" Commande recu:"+letter);
            switch (letter) {
                case "L":
                    initDirection = Direction.previousDirection(initDirection);
                    break;
                case "R":
                    initDirection = Direction.nextDirection(initDirection);

                case "M":
                    updatePosition(position, initDirection.toString());
                default:
                    break;
            }
        }
        //System.out.println("Direction en cours: "+initDirection);
        //System.out.println("Nouvelle position post mouvement : Position x:"+position.getPositionX()+" Position Y"+ position.getPositionY());
        //System.out.println("Position finale : Position X:"+position.getPositionX()+" Position Y:"+ position.getPositionY() +" Direction :"+initDirection);
        System.out.println(position.getPositionX()+" "+ position.getPositionY() +" "+initDirection);
        return (position.getPositionX()+" "+ position.getPositionY() +" "+initDirection);
    }

    public static void updatePosition(Position position, String direction) {
        //actualise la position
        switch (direction) {
            case "N":
                position.setPositionY(position.getPositionY() + 1);
                break;
            case "E":
                position.setPositionX(position.getPositionX() + 1);
                break;
            case "S":
                position.setPositionY(position.getPositionY() - 1);
                break;
            case "W":
                position.setPositionX(position.getPositionX() - 1);
                break;
            default:
                throw new IllegalArgumentException("Direction invalide : " + direction);
        }
    }

}
