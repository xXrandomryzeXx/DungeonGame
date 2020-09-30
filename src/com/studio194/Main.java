package com.studio194;
import java.lang.String;

public class Main {
    private static String[][] _map = new String[10][20];

    String [][] array = new String[10][10];

    static String[][] room = {
            {"#  ", "#  ", "#  ", "#  "},
            {"#  ", "   ", "   ", "#  "},
            {"#  ", "   ", "   ", "#  "},
            {"#  ", "#  ", "#  ", "#  "},
    };

    public static void main(String[] args) {
        _generateMap();
        addRoomToMap(room, 0, 0);
        _render();
    }


    private static void _generateMap(){
        for(int y = 0; y < _map.length; y++){
            for(int x = 0; x < _map[y].length; x++){
                if(y == 0 || y == _map.length - 1 || x == 0 || x == _map[y].length - 1)
                    _map[y][x] = "#  ";
                else{
                    _map[y][x] = "   ";
                }
            }
        }
    }

    private static void addRoomToMap(String[][] room, int posX, int posY){
        for(int y = 0; y < _map.length; y++){
            for(int x = 0; x < _map[y].length; x++){
                if(x < room[0].length && y < room.length) {
                    _map[y + posY][x + posX] = room[y][x];
                }
            }
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
}
