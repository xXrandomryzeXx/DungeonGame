package com.studio194;
import java.lang.String;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static boolean game_running = true;

    private final static Scanner _input = new Scanner(System.in);
    private final static String[][] _map = new String[10][20];

    private static int playerX = 6, playerY = 6;
    private static int score = 0;
    private static boolean hasKey = false;

    static String[][] room = {
            {MapObjects.wall, MapObjects.wall, MapObjects.wall, MapObjects.wall},
            {MapObjects.wall, MapObjects.door, "   "          , MapObjects.wall},
            {"   "          , MapObjects.money, "   "          , "   "},
            {MapObjects.wall, MapObjects.wall, MapObjects.wall, MapObjects.wall},
    };


    public static void main(String[] args) throws InterruptedException {
        _intro();

        TimeUnit.SECONDS.sleep(5);

        _generateMap();
        addRoomToMap(room, 0, 0);

        while(game_running){
            _render();
            _update();
        }
        _finalScore();
    }

    private static void _generateMap(){
        for(int y = 0; y < _map.length; y++){
            for(int x = 0; x < _map[y].length; x++) {
                if (y == 0 || y == _map.length - 1 || x == 0 || x == _map[y].length - 1){   //Makes default walls
                    _map[y][x] = MapObjects.wall;
                }else{  //Makes air spot
                    _map[y][x] = "   ";
                }

                if (x == playerX && y == playerY){    //Makes player if position matches
                    _map[playerY][playerX] = MapObjects.player;
                }
            }
        }
    }

    private static void addRoomToMap(String[][] room, int posX, int posY){
        for(int y = 0; y < _map.length; y++){
            for(int x = 0; x < _map[y].length; x++){
                if(x < room[0].length && y < room.length) {
                    _map[y + posY][x + posX] = room[y][x];

                    //Check if overlapping room walls(with the map border) have holes. if so fill them
                    if(y + posY == 0 || y + posY == _map.length - 1 || x + posX == 0 || x + posX == _map[y].length - 1){
                        _map[y + posY][x + posX] = MapObjects.wall;
                    }
                }
            }
        }
    }

    private static void _update(){
        String moveCommand = _input.nextLine();

        switch(moveCommand){
            case "left":
                _movePlayer(-1, 0);
                break;
            case "right":
                _movePlayer(1, 0);
                break;
            case "up":
                _movePlayer(0, -1);
                break;
            case "down":
                _movePlayer(0, 1);
                break;
        }
    }

    private static void _render(){
        for (String[] strings : _map) { //Gets a list of the y axis
            for (String string : strings) { //Gets the list of the x axis on the y axis "strings"
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static void _movePlayer(int xMove, int yMove){
        _map[playerY][playerX] = "   ";

        //Check If
        //There is a wall where the player is gonna move?
        if(!_map[playerY + yMove][playerX + xMove].equals(MapObjects.wall) &&
                !(_map[playerY + yMove][playerX + xMove].equals(MapObjects.door) && hasKey == false)) {
            playerX += xMove;
            playerY += yMove;
        }

        if(_map[playerY][playerX].equals(MapObjects.money)){
            score += 10;
        }else if(_map[playerY][playerX].equals(MapObjects.key)){
            hasKey = true;
        }else if(_map[playerY][playerX].equals(MapObjects.door)){
            game_running = false;
        }
        _map[playerY][playerX] = MapObjects.player;
    }


    private static void _intro(){
        System.out.println("Wall: " + MapObjects.wall);
        System.out.println("Player: " + MapObjects.player);
        System.out.println("Money/Score: " + MapObjects.money);
        System.out.println("Key: " + MapObjects.key);
        System.out.println("Finish/Door(needs key): " + MapObjects.door);
    }
    private static void _finalScore(){
        System.out.println("!!!You've finished the game!!!");
        System.out.println("Score: " + score);
        System.out.println();
        System.out.print("Enter any symbol to exit: ");
        String string = _input.nextLine();
    }
}