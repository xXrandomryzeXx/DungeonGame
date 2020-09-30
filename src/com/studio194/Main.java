package com.studio194;
import java.lang.String;

public class Main {
    private static String[][] _map = new String[10][20];

    public static void main(String[] args) {
        _generateMap();
        _render();
    }


    private static void _generateMap(){
        for(int y = 0; y < _map.length; y++){
            for(int x = 0; x < _map[0].length; x++){
                if(y == 0 || y == _map.length - 1 || x == 0 || x == _map[y].length - 1)
                    _map[y][x] = "#  ";
                else{
                    _map[y][x] = "   ";
                }
            }
        }
    }

    private static void _render(){
        for (String[] strings : _map) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
