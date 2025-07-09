package org.JuegoApothecaryDiaries;

public class DialogueEdge {
    private String choiceText;
    private String condition; // Opcional
    private DialogueNode target;
    int weight; // Puntos de relación

    DialogueEdge(String choiceText, String condition, DialogueNode target, int weight) {
        this.choiceText = choiceText;
        this.condition = condition;
        this.target = target;
        this.weight = weight;
    }

    public DialogueNode getTarget() {
        return target;
    }

    public void setTarget(DialogueNode target) {
        this.target = target;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }
}
