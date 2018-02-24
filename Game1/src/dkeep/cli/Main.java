package dkeep.cli;

import java.util.Scanner;

public class Main {

    private static int mapNumber = 1;

    public static void main(String[] args) {
//Variáveis
        int[] heroCordinates = new int[2];
        int[] guardCordinates = new int[2];
        int[] ogreCordinates = new int[2];
        int[] ogreCordinatesDamage = new int[2];

        char[][] board = new char[][]{{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
        {'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X'},
        {'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
        {'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X'},
        {'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X'},
        {'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
        {'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X'},
        {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

        char[][] board2 = new char[][]{{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
        {'X', ' ', ' ', ' ', ' ', 'O', ' ', ' ', 'k', 'X'},
        {'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
//Código

        printLegend();
        printDirections();
        heroCordinates[0] = 1;
        heroCordinates[1] = 1;
        guardCordinates[0] = 1;
        guardCordinates[1] = 8;
        firstMap(board, heroCordinates, guardCordinates);
        heroCordinates[0] = 8;
        heroCordinates[1] = 1;
        ogreCordinates[0] = 1;
        ogreCordinates[1] = 5;
        ogreCordinatesDamage[0] = 1;
        ogreCordinatesDamage[1] = 1;
        secondMap(board2, heroCordinates, ogreCordinates, ogreCordinatesDamage);

    }

    public static void firstMap(char[][] map, int[] heroCordinates, int[] guardCordinates) {
        int movementDirection, guardStep = 0;
        while (mapNumber == 0) {
            printBoard(map);
            movementDirection = readDirection();
            heroMovement(heroCordinates, map, movementDirection);
            guardMovement(map, guardStep, guardCordinates);
            guardStep++;
            if (guardStep == 24) {
                guardStep = 0;
            }
        }
        printBoard(map);
    }

    public static void secondMap(char[][] map, int[] heroCordinates, int[] ogreCordinates, int[] ogreCordinatesDamage) {
        int movementDirection;
        while (mapNumber == 1) {
        	
            if (map[1][8] == ' ' && map[2][0] == 'I'&& map[heroCordinates[0]][heroCordinates[1]]=='H') {
                map[1][8] = 'k';
            }
            
            printBoard(map);
            movementDirection = readDirection();
            heroMovementKeyTansport(heroCordinates, map, movementDirection);
           
            randomOgreDirection(map, ogreCordinates);
           
            if (map[ogreCordinatesDamage[0]][ogreCordinatesDamage[1]] != 'O') {
            	map[ogreCordinatesDamage[0]][ogreCordinatesDamage[1]] = ' ';
            }
            
            radomOgreDamage(map, ogreCordinates, ogreCordinatesDamage);
        }
        printBoard(map);
    }

    public static void printLegend() {
        System.out.println("Legend:");
        System.out.println("X -> Wall");
        System.out.println("I -> Exit Door");
        System.out.println("H -> Hero");
        System.out.println("G -> Guard");
        System.out.println("O -> Crazy Ogre");
        System.out.println("K -> key");
        System.out.println("empty cell - free space\n");
    }

    public static void printDirections() {
        System.out.println("\nPlease choose a direction for your hero!");
        System.out.println("options: ");
        System.out.println("Left -> press 1");
        System.out.println("Up -> press 2");
        System.out.println("Down -> press 3");
        System.out.println("Right -> press 4\n");

    }

    public static int readDirection() {
        Scanner scanner = new Scanner(System.in);
        int direction = 0;
        while (direction > 4 || direction < 1) {
            direction = scanner.nextInt();
        }
        return direction;
    }

    public static void heroMovement(int[] heroCordinate, char[][] map, int movementDirection) {
        switch (movementDirection) {
            case 1:

                if (map[heroCordinate[0]][heroCordinate[1] - 1] != 'X' && map[heroCordinate[0]][heroCordinate[1] - 1] != 'I') {

                    map = checkLever(map, heroCordinate[0], heroCordinate[1] - 1);
                    map = checkLadders(map, heroCordinate, heroCordinate[0], heroCordinate[1] - 1);

                    map[heroCordinate[0]][heroCordinate[1]] = ' ';
                    map[heroCordinate[0]][heroCordinate[1] - 1] = 'H';
                    heroCordinate[1] = heroCordinate[1] - 1;

                }
                break;
            case 2:

                if (map[heroCordinate[0] - 1][heroCordinate[1]] != 'X' && map[heroCordinate[0] - 1][heroCordinate[1]] != 'I') {

                    map = checkLever(map, heroCordinate[0] - 1, heroCordinate[1]);
                    map = checkLadders(map, heroCordinate, heroCordinate[0] - 1, heroCordinate[1]);

                    map[heroCordinate[0]][heroCordinate[1]] = ' ';
                    map[heroCordinate[0] - 1][heroCordinate[1]] = 'H';
                    heroCordinate[0] = heroCordinate[0] - 1;
                }
                break;
            case 3:

                if (map[heroCordinate[0] + 1][heroCordinate[1]] != 'X' && map[heroCordinate[0] + 1][heroCordinate[1]] != 'I') {

                    map = checkLever(map, heroCordinate[0] + 1, heroCordinate[1]);
                    map = checkLadders(map, heroCordinate, heroCordinate[0] + 1, heroCordinate[1]);

                    map[heroCordinate[0]][heroCordinate[1]] = ' ';
                    map[heroCordinate[0] + 1][heroCordinate[1]] = 'H';
                    heroCordinate[0] = heroCordinate[0] + 1;

                }
                break;
            case 4:

                if (map[heroCordinate[0]][heroCordinate[1] + 1] != 'X' && map[heroCordinate[0]][heroCordinate[1] + 1] != 'I') {

                    map = checkLever(map, heroCordinate[0], heroCordinate[1] + 1);
                    map = checkLadders(map, heroCordinate, heroCordinate[0], heroCordinate[1] + 1);

                    map[heroCordinate[0]][heroCordinate[1]] = ' ';
                    map[heroCordinate[0]][heroCordinate[1] + 1] = 'H';
                    heroCordinate[1] = heroCordinate[1] + 1;

                }
                break;
        }
    }

    public static void heroMovementKeyTansport(int[] heroCordinate, char[][] map, int movementDirection) {
        switch (movementDirection) {
            case 1:

                if (map[heroCordinate[0]][heroCordinate[1] - 1] != 'X' && map[heroCordinate[0]][heroCordinate[1] - 1] != 'I') {
                    if (map[heroCordinate[0]][heroCordinate[1] - 1] == 'S') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0]][heroCordinate[1] - 1] = 'H';
                        heroCordinate[1] = heroCordinate[1] - 1;
                        victory();
                    } else if (map[heroCordinate[0]][heroCordinate[1] - 1] == 'k' || map[heroCordinate[0]][heroCordinate[1]] == 'K') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0]][heroCordinate[1] - 1] = 'K';
                        heroCordinate[1] = heroCordinate[1] - 1;
                    } else {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0]][heroCordinate[1] - 1] = 'H';
                        heroCordinate[1] = heroCordinate[1] - 1;

                    }

                } else {
                    checkUnlockableDoor(map, heroCordinate,heroCordinate);
                }
              //  if (map[1][8] == ' ' && map[2][0] == 'I') {
              //      map[1][8] = 'k';
               // }
                break;
            case 2:

                if (map[heroCordinate[0] - 1][heroCordinate[1]] != 'X' && map[heroCordinate[0] - 1][heroCordinate[1]] != 'I') {
                    if (map[heroCordinate[0] - 1][heroCordinate[1]] == 'S') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0] - 1][heroCordinate[1]] = 'H';
                        heroCordinate[0] = heroCordinate[0] - 1;
                        victory();
                    } else if (map[heroCordinate[0] - 1][heroCordinate[1]] == 'k' || map[heroCordinate[0]][heroCordinate[1]] == 'K') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0] - 1][heroCordinate[1]] = 'K';
                        heroCordinate[0] = heroCordinate[0] - 1;
                    } else {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0] - 1][heroCordinate[1]] = 'H';
                        heroCordinate[0] = heroCordinate[0] - 1;
                    }

                } else {
                    checkUnlockableDoor(map, heroCordinate,heroCordinate);
                }
              //  if (map[1][8] == ' ' && map[2][0] == 'I') {
              //      map[1][8] = 'k';
             //   }
                break;

            case 3:

                if (map[heroCordinate[0] + 1][heroCordinate[1]] != 'X' && map[heroCordinate[0] + 1][heroCordinate[1]] != 'I') {
                    if (map[heroCordinate[0] + 1][heroCordinate[1]] == 'S') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0] + 1][heroCordinate[1]] = 'H';
                        heroCordinate[0] = heroCordinate[0] + 1;
                        victory();
                    } else if (map[heroCordinate[0] + 1][heroCordinate[1]] == 'k' || map[heroCordinate[0]][heroCordinate[1]] == 'K') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0] + 1][heroCordinate[1]] = 'K';
                        heroCordinate[0] = heroCordinate[0] + 1;
                    } else {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0] + 1][heroCordinate[1]] = 'H';
                        heroCordinate[0] = heroCordinate[0] + 1;
                    }

                } else {
                    checkUnlockableDoor(map, heroCordinate,heroCordinate);
                }
             //   if (map[1][8] == ' ' && map[2][0] == 'I') {
              //      map[1][8] = 'k';
              //  }
                break;
            case 4:

                if (map[heroCordinate[0]][heroCordinate[1] + 1] != 'X' && map[heroCordinate[0]][heroCordinate[1] + 1] != 'I') {
                    if (map[heroCordinate[0]][heroCordinate[1] + 1] == 'S') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0]][heroCordinate[1] + 1] = 'H';
                        heroCordinate[1] = heroCordinate[1] + 1;
                        victory();
                    } else if (map[heroCordinate[0]][heroCordinate[1] + 1] == 'k' || map[heroCordinate[0]][heroCordinate[1]] == 'K') {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0]][heroCordinate[1] + 1] = 'K';
                        heroCordinate[1] = heroCordinate[1] + 1;
                    } else {
                        map[heroCordinate[0]][heroCordinate[1]] = ' ';
                        map[heroCordinate[0]][heroCordinate[1] + 1] = 'H';
                        heroCordinate[1] = heroCordinate[1] + 1;
                    }

                } else {
                    checkUnlockableDoor(map, heroCordinate,heroCordinate);
                }

                break;
        }
    }

    public static void checkUnlockableDoor(char[][] map, int[] coordenates, int[] heroCord) {
        if (map[2][0] == 'I' && map[coordenates[0]][coordenates[1]] == 'K') {
            map[2][0] = 'S';
            map[heroCord[0]][heroCord[1]]='H';
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] pushLever(char[][] map) {
        map[5][0] = 'S';
        map[6][0] = 'S';
        return map;
    }

    public static char[][] checkLever(char[][] map, int xCordinate, int yCordinate) {
        if (map[xCordinate][yCordinate] == 'k') {
            pushLever(map);
        }
        return map;
    }

    public static char[][] checkLadders(char[][] map, int[] oldCordinates, int xCordinate, int yCordinate) {
        if (map[xCordinate][yCordinate] == 'S') {
            map[oldCordinates[0]][oldCordinates[1]] = ' ';
            map[xCordinate][yCordinate] = 'H';
            victory();
        }
        return map;
    }

    public static char[][] guardMovement(char[][] map, int guardStep, int[] cordinates) {

        if (guardStep == 0) {
            if (map[cordinates[0]][cordinates[1] - 1] == 'H') {
                changeChar(map, cordinates, cordinates[0], cordinates[1] - 1, 'G');
                loss();
            } else {
                changeChar(map, cordinates, cordinates[0], cordinates[1] - 1, 'G');

                cordinates[1] = cordinates[1] - 1;
            }

        } else if (guardStep < 5) {
            if (map[cordinates[0] + 1][cordinates[1]] == 'H') {
                changeChar(map, cordinates, cordinates[0] + 1, cordinates[1], 'G');
                loss();
            } else {
                changeChar(map, cordinates, cordinates[0] + 1, cordinates[1], 'G');

                cordinates[0] = cordinates[0] + 1;
            }

        } else if (guardStep < 11) {
            if (map[cordinates[0]][cordinates[1] - 1] == 'H') {
                changeChar(map, cordinates, cordinates[0], cordinates[1] - 1, 'G');
                loss();
            } else {
                changeChar(map, cordinates, cordinates[0], cordinates[1] - 1, 'G');

                cordinates[1] = cordinates[1] - 1;
            }

        } else if (guardStep == 11) {
            if (map[cordinates[0] + 1][cordinates[1]] == 'H') {
                changeChar(map, cordinates, cordinates[0] + 1, cordinates[1], 'G');
                loss();
            } else {
                changeChar(map, cordinates, cordinates[0] + 1, cordinates[1], 'G');

                cordinates[0] = cordinates[0] + 1;
            }

        } else if (guardStep < 19) {
            if (map[cordinates[0]][cordinates[1] + 1] == 'H') {
                changeChar(map, cordinates, cordinates[0], cordinates[1] + 1, 'G');
                loss();
            } else {
                changeChar(map, cordinates, cordinates[0], cordinates[1] + 1, 'G');

                cordinates[1] = cordinates[1] + 1;
            }

        } else if (guardStep < 24) {
            if (map[cordinates[0] - 1][cordinates[1]] == 'H') {
                changeChar(map, cordinates, cordinates[0] - 1, cordinates[1], 'G');
                loss();
            } else {
                changeChar(map, cordinates, cordinates[0] - 1, cordinates[1], 'G');

                cordinates[0] = cordinates[0] - 1;
            }
        }

        if (checkHeroPresence(map, cordinates) == true) {
            loss();
        }
        return map;
    }

    public static char[][] changeChar(char[][] map, int[] cordinates, int xCordinates, int yCordinates, char character) {
        map[cordinates[0]][cordinates[1]] = ' ';
        map[xCordinates][yCordinates] = character;
        return map;
    }

    public static boolean checkHeroPresence(char[][] map, int[] cordinates) {
        if (map[cordinates[0] - 1][cordinates[1]] == 'H') {
            //changeChar(map, cordinates, cordinates[0] - 1, cordinates[1], 'G');
            return true;
        }
        if (map[cordinates[0] + 1][cordinates[1]] == 'H') {
            // changeChar(map, cordinates, cordinates[0] + 1, cordinates[1], 'G');
            return true;
        }
        if (map[cordinates[0]][cordinates[1] - 1] == 'H') {
            //changeChar(map, cordinates, cordinates[0], cordinates[1] - 1, 'G');
            return true;
        }
        if (map[cordinates[0]][cordinates[1] + 1] == 'H') {
            // changeChar(map, cordinates, cordinates[0], cordinates[1] - 1, 'G');
            return true;
        }
        return false;
    }

    public static void randomOgreDirection(char[][] map, int[] ogreCordinates) {
        int direction = 0;
        do {
            direction = 1 + (int) (Math.random() * 4);
        } while (checkObstacle(map, ogreCordinates, direction) == true);

        switch (direction) {
            case 1:

                if (map[ogreCordinates[0]][ogreCordinates[1] - 1] == 'H' || map[ogreCordinates[0]][ogreCordinates[1] - 1] == 'K') {
                    loss();
                } else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
                    map[ogreCordinates[0]][ogreCordinates[1] - 1] = 'O';
                    ogreCordinates[1] = ogreCordinates[1] - 1;
                } else if (map[ogreCordinates[0]][ogreCordinates[1] - 1] != '$' && map[ogreCordinates[0]][ogreCordinates[1] - 1] != 'k') {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0]][ogreCordinates[1] - 1] = 'O';
                    ogreCordinates[1] = ogreCordinates[1] - 1;
                } else {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0]][ogreCordinates[1] - 1] = '$';
                    ogreCordinates[1] = ogreCordinates[1] - 1;
                }

                break;
            case 2:

                if (map[ogreCordinates[0] - 1][ogreCordinates[1]] == 'H' || map[ogreCordinates[0] - 1][ogreCordinates[1]] == 'K') {
                    loss();
                } else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
                    map[ogreCordinates[0] - 1][ogreCordinates[1]] = 'O';
                    ogreCordinates[0] = ogreCordinates[0] - 1;
                } else if (map[ogreCordinates[0] - 1][ogreCordinates[1]] != '$' && map[ogreCordinates[0] - 1][ogreCordinates[1]] != 'k') {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0] - 1][ogreCordinates[1]] = 'O';
                    ogreCordinates[0] = ogreCordinates[0] - 1;
                } else {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0] - 1][ogreCordinates[1]] = '$';
                    ogreCordinates[0] = ogreCordinates[0] - 1;
                }

                break;
            case 3:

                if (map[ogreCordinates[0] + 1][ogreCordinates[1]] == 'H' || map[ogreCordinates[0] + 1][ogreCordinates[1]] == 'K') {
                    loss();
                } else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
                    map[ogreCordinates[0] + 1][ogreCordinates[1]] = 'O';
                    ogreCordinates[0] = ogreCordinates[0] + 1;
                } else if (map[ogreCordinates[0] + 1][ogreCordinates[1]] != '$' && map[ogreCordinates[0] + 1][ogreCordinates[1]] != 'k') {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0] + 1][ogreCordinates[1]] = 'O';
                    ogreCordinates[0] = ogreCordinates[0] + 1;
                } else {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0] + 1][ogreCordinates[1]] = '$';
                    ogreCordinates[0] = ogreCordinates[0] + 1;
                }

                break;
            case 4:

                if (map[ogreCordinates[0]][ogreCordinates[1] + 1] == 'H' || map[ogreCordinates[0]][ogreCordinates[1] + 1] == 'K') {
                    loss();
                } else if (map[ogreCordinates[0]][ogreCordinates[1]] == 'k') {
                    map[ogreCordinates[0]][ogreCordinates[1] + 1] = 'O';
                    ogreCordinates[1] = ogreCordinates[1] + 1;
                } else if (map[ogreCordinates[0]][ogreCordinates[1] + 1] != '$' && map[ogreCordinates[0]][ogreCordinates[1] + 1] != 'k') {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0]][ogreCordinates[1] + 1] = 'O';
                    ogreCordinates[1] = ogreCordinates[1] + 1;
                } else {
                    map[ogreCordinates[0]][ogreCordinates[1]] = ' ';
                    map[ogreCordinates[0]][ogreCordinates[1] + 1] = '$';
                    ogreCordinates[1] = ogreCordinates[1] + 1;
                }

                break;
        }
    }


    public static void radomOgreDamage(char[][] map, int[] ogreCordinates, int[] ogreCordinatesDamage) {
        int direction = 0;
        
        do {
            direction = 1 + (int) (Math.random() * 4);
            
        } while (checkObstacle(map, ogreCordinates, direction) == true);

        switch (direction) {
            case 1:
            	
                if (map[ogreCordinates[0]][ogreCordinates[1] - 1] == 'H' || map[ogreCordinates[0]][ogreCordinates[1] - 1] == 'K' ) {
                    map[ogreCordinates[0]][ogreCordinates[1] - 1] = '$';
                    loss();
                
                }else if(map[ogreCordinates[0]][ogreCordinates[1] - 1] == 'k') {
                	 map[ogreCordinates[0]][ogreCordinates[1] - 1] = '$';
                    
                } else {
                	
                    map[ogreCordinates[0]][ogreCordinates[1] - 1] = '*';
                    ogreCordinatesDamage[0]=ogreCordinates[0];
                    ogreCordinatesDamage[1]=ogreCordinates[1]-1;   
                }
                

                break;
            case 2:

            	if (map[ogreCordinates[0]-1][ogreCordinates[1] ] == 'H' || map[ogreCordinates[0]- 1][ogreCordinates[1]] == 'K' ) {
                    map[ogreCordinates[0]-1][ogreCordinates[1] ] = '$';
                    loss();
                
                }else if(map[ogreCordinates[0]-1][ogreCordinates[1]] == 'k') {
                	 map[ogreCordinates[0]-1][ogreCordinates[1]] = '$';
                    
                } else {
                	
                    map[ogreCordinates[0]-1][ogreCordinates[1]] = '*';
                    ogreCordinatesDamage[0]=ogreCordinates[0]-1;
                    ogreCordinatesDamage[1]=ogreCordinates[1];   
                }

                break;
            case 3:
            	
            	if (map[ogreCordinates[0]+1][ogreCordinates[1] ] == 'H' || map[ogreCordinates[0]+ 1][ogreCordinates[1]] == 'K' ) {
                    map[ogreCordinates[0]+1][ogreCordinates[1] ] = '$';
                    loss();
                
                }else if(map[ogreCordinates[0]+1][ogreCordinates[1]] == 'k') {
                	 map[ogreCordinates[0]+1][ogreCordinates[1]] = '$';
                    
                } else {
                	
                    map[ogreCordinates[0]+1][ogreCordinates[1]] = '*';
                    ogreCordinatesDamage[0]=ogreCordinates[0]+1;
                    ogreCordinatesDamage[1]=ogreCordinates[1];   
                }

                break;
            case 4:
            	
            	 if (map[ogreCordinates[0]][ogreCordinates[1] + 1] == 'H' || map[ogreCordinates[0]][ogreCordinates[1] + 1] == 'K' ) {
                     map[ogreCordinates[0]][ogreCordinates[1] + 1] = '$';
                     loss();
                 
                 }else if(map[ogreCordinates[0]][ogreCordinates[1] + 1] == 'k') {
                 	 map[ogreCordinates[0]][ogreCordinates[1] + 1] = '$';
                     
                 } else {
                 	
                     map[ogreCordinates[0]][ogreCordinates[1] + 1] = '*';
                     ogreCordinatesDamage[0]=ogreCordinates[0];
                     ogreCordinatesDamage[1]=ogreCordinates[1]+1;   
                 }
                 

                break;
        }

    }

    public static boolean checkObstacle(char[][] map, int[] cordinates, int direction) {
        if (direction == 2) {
            if (map[cordinates[0] - 1][cordinates[1]] == 'X' || map[cordinates[0] - 1][cordinates[1]] == 'I' || map[cordinates[0] - 1][cordinates[1]] == 'S') {
                return true;
            } else {
                return false;
            }
        }
        if (direction == 3) {
            if (map[cordinates[0] + 1][cordinates[1]] == 'X' || map[cordinates[0] + 1][cordinates[1]] == 'I' || map[cordinates[0] + 1][cordinates[1]] == 'S') {
                return true;
            } else {
                return false;
            }
        }
        if (direction == 1) {
            if (map[cordinates[0]][cordinates[1] - 1] == 'X' || map[cordinates[0]][cordinates[1] - 1] == 'I' || map[cordinates[0]][cordinates[1] - 1] == 'S') {
                return true;
            } else {
                return false;
            }
        }
        if (direction == 4) {
            if (map[cordinates[0]][cordinates[1] + 1] == 'X' || map[cordinates[0]][cordinates[1] + 1] == 'I' || map[cordinates[0]][cordinates[1] + 1] == 'S') {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public static void victory() {
        mapNumber++;
        System.out.println("Victory!");
    }

    public static void loss() {
        mapNumber--;
        System.out.println("Fatality!");
    }

}
