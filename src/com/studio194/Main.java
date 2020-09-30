package com.studio194;
import java.lang.String;
import java.util.Scanner;

public class Main {
    private final static String RedColor = "\033[0;31m";
    private final static String BlueColor = "\033[0;34m";
    private final static String DefaultColor = "\033[0m";

    private final static String wall = BlueColor + "#  " + DefaultColor;
    private final static String player = RedColor + "@  " + DefaultColor;

    private final static Scanner _input = new Scanner(System.in);
    private final static String[][] _map = new String[10][20];

    private static int playerX = 6, playerY = 6;

    static String[][] room = {
            {wall, wall, wall, wall},
            {wall, "   ", "   ", wall},
            {"   ", "   ", "   ", "   "},
            {wall, wall, wall, wall},
    };

    public static void main(String[] args) {
        _generateMap();
        addRoomToMap(room, 0, 0);

        while(true){
            _render();
            _update();
        }

    }

    private static void _generateMap(){
        for(int y = 0; y < _map.length; y++){
            for(int x = 0; x < _map[y].length; x++) {
                if (y == 0 || y == _map.length - 1 || x == 0 || x == _map[y].length - 1){   //Makes default walls
                    _map[y][x] = wall;
                }else{  //Makes air spot
                    _map[y][x] = "   ";
                }

                if (x == playerX && y == playerY){    //Makes player if posion matches
                    _map[playerY][playerX] = player;
                }
            }
        }
    }

    private static void addRoomToMap(String[][] room, int posX, int posY){
        for(int y = 0; y < _map.length; y++){
            for(int x = 0; x < _map[y].length; x++){
                if(x < room[0].length && y < room.length) {
                    _map[y + posY][x + posX] = room[y][x];

                    if(y + posY == 0 || y + posY == _map.length - 1 || x + posX == 0 || x + posX == _map[y].length - 1){
                        _map[y + posY][x + posX] = wall;
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
        if(_map[playerY][playerX + xMove] != wall)
            playerX += xMove;

        if(_map[playerY + yMove][playerX] != wall)
            playerY += yMove;

        _map[playerY][playerX] = player;
    }
}