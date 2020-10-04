package com.studio194;

public class Rooms {

    public static String[][] room1 = {
            {MapObjects.wall, "   ", MapObjects.wall , MapObjects.wall},
            {MapObjects.wall, "   ", "   "           , MapObjects.wall},
            {"   "          , "   ", MapObjects.money , "   "},
            {MapObjects.wall, "   ", MapObjects.wall , MapObjects.wall},
    };

    public static String[][] room2 = {
            {MapObjects.wall, "   ", MapObjects.wall, MapObjects.wall},
            {MapObjects.wall, MapObjects.door, "   "          , MapObjects.wall},
            {MapObjects.wall, "   ", "   "          , "   "},
            {MapObjects.wall, MapObjects.wall, MapObjects.wall, MapObjects.wall},
    };

    public static String[][] room3 = {
            {MapObjects.wall, "   ", "   "          , MapObjects.wall},
            {MapObjects.wall, "   ", "   "          , MapObjects.wall},
            {"   "          , "   ", MapObjects.money, "   "},
            {MapObjects.wall, MapObjects.wall, MapObjects.wall, MapObjects.wall},
    };

    public static String[][] room4 = {
            {MapObjects.wall, "   ", "   "          , MapObjects.wall},
            {MapObjects.wall, "   ", "   "          , MapObjects.wall},
            {"   "          , "   ", MapObjects.key, "   "},
            {MapObjects.wall, MapObjects.wall, MapObjects.wall, MapObjects.wall},
    };

}
