package com.example.nava.clkmouse.operation;

/**
 * Created by nava on 8/3/17.
 */
import com.google.gson.Gson;
public class CommandParser {

    public static String parseCommand(OperationData operation) {
        Gson gson = new Gson();
        return gson.toJson(operation, OperationData.class);
    }
}
