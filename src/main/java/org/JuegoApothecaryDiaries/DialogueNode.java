package org.JuegoApothecaryDiaries;

import java.util.ArrayList;
import java.util.List;

public class DialogueNode {
    private String id;
    private String text;
    private List<DialogueEdge> options = new ArrayList<>();

    DialogueNode(String id, String text) {
        this.id = id;
        this.text = text;
    }

    void addOption(DialogueEdge edge) {
        options.add(edge);
    }

    public void setId(String id){
        this.id = id;
    }

    public void setText(String text){
        this.text=text;
    }

    public String getId (){
        return id;
    }

    public String getText (){
        return text;
    }

    public List<DialogueEdge> getOptions(){
        return options;
    }
}