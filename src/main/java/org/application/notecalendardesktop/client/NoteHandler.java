package org.application.notecalendardesktop.client;

import java.util.ArrayList;

public class NoteHandler {

    private static final ArrayList<Note> noteList = new ArrayList<>();

    public static ArrayList<Note> getNoteList() {
        return noteList;
    }

}
