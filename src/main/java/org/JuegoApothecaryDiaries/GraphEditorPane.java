import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;
import org.JuegoApothecaryDiaries.DialogueEdge;
import org.JuegoApothecaryDiaries.DialogueNode;

public class GraphEditorPane extends Pane {

    private DialogueNodeView sourceNode = null; // Track the source node for edge creation
    private Line tempLine = null; // Temporary line for edge creation

    public GraphEditorPane() {
        setStyle("-fx-background-color: lightgray;"); // Just for visual indication

        // Mouse click handler for the pane
        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) { // Left click
                if (sourceNode == null) { // Create a new node
                    String newNodeId = "node" + System.currentTimeMillis(); // Generate a unique ID
                    DialogueNodeView nodeView = new DialogueNodeView(newNodeId, 20, this); // Pass GraphEditorPane instance
                    nodeView.setCenterX(event.getX());
                    nodeView.setCenterY(event.getY());
                    getChildren().add(nodeView);

                    // Mouse event handlers for the node
                    nodeView.setOnMousePressed(nodeMousePressedHandler(nodeView));
                    nodeView.setOnMouseDragged(nodeMouseDraggedHandler(nodeView));
                    nodeView.setOnMouseReleased(nodeMouseReleasedHandler(nodeView));

                } else {
                    // Clicked on the pane while creating an edge - cancel edge creation
                    removeTempLine();
                    sourceNode = null;
                }
            }
        });

        // Listener to handle node removal
        getChildren().addListener((ListChangeListener<Node>) c -> {
            while (c.next()) {
                if (c.wasRemoved()) {
                    for (Node removedNode : c.getRemoved()) {
                        if (removedNode instanceof DialogueNodeView) {
                            removeEdgesForNode((DialogueNodeView) removedNode);
                        }
                    }
                }
            }
        });
    }

    private EventHandler<MouseEvent> nodeMousePressedHandler(DialogueNodeView nodeView) {
        return event -> {
            if (event.getButton() == MouseButton.SECONDARY) { // Right click - start edge creation
                sourceNode = nodeView;
                tempLine = new Line(nodeView.getCenterX() + nodeView.getTranslateX(),
                        nodeView.getCenterY() + nodeView.getTranslateY(),
                        event.getSceneX(),
                        event.getSceneY());
                tempLine.setStroke(Color.BLACK);
                getChildren().add(tempLine);
            } else {
                // Start node dragging
                nodeView.startDrag(event);
            }
        };
    }

    private EventHandler<MouseEvent> nodeMouseDraggedHandler(DialogueNodeView nodeView) {
        return event -> {
            if (sourceNode != null && tempLine != null) { // Update the temporary line
                tempLine.setEndX(event.getSceneX());
                tempLine.setEndY(event.getSceneY());
            } else {
                // Drag the node
                nodeView.drag(event);
            }
        };
    }

    private EventHandler<MouseEvent> nodeMouseReleasedHandler(DialogueNodeView nodeView) {
        return event -> {
            if (event.getButton() == MouseButton.SECONDARY && sourceNode != null && tempLine != null) {
                // Check if the mouse is released over another node
                for (javafx.scene.Node target : getChildren()) {
                    if (target instanceof DialogueNodeView && target != sourceNode && target.getBoundsInParent().contains(event.getX(), event.getY())) {
                        DialogueNodeView targetNode = (DialogueNodeView) target;
                        createEdge(sourceNode, targetNode);
                        break;
                    }
                }
                removeTempLine();
                sourceNode = null;
            } else {
                // Stop node dragging
                nodeView.endDrag();
            }
        };
    }

    private void createEdge(DialogueNodeView source, DialogueNodeView target) {
        // Create a DialogueEdge
        DialogueNode sourceDialogueNode = new DialogueNode(source.getNodeId(), "Source Node Text"); // Replace with actual text
        DialogueNode targetDialogueNode = new DialogueNode(target.getNodeId(), "Target Node Text"); // Replace with actual text
        DialogueEdge edgeData = new DialogueEdge("Option Text", targetDialogueNode, 0, 1.0); // Replace with actual values

        // Create the line
        Line edge = new Line(source.getCenterX() + source.getTranslateX(),
                source.getCenterY() + source.getTranslateY(),
                target.getCenterX() + target.getTranslateX(),
                target.getCenterY() + target.getTranslateY());
        edge.setStroke(Color.BLACK);

        // Create the arrowhead
        Polygon arrowhead = createArrowhead(edge.getStartX(), edge.getStartY(), edge.getEndX(), edge.getEndY());

        // Create the weight display
        Text weightText = new Text(String.valueOf(edgeData.getWeight()));
        weightText.setX((edge.getStartX() + edge.getEndX()) / 2);
        weightText.setY((edge.getStartY() + edge.getEndY()) / 2);

        getChildren().addAll(edge, arrowhead, weightText);
        edge.toBack(); // Send the edge to the back so nodes are on top
    }

    private Polygon createArrowhead(double startX, double startY, double endX, double endY) {
        double arrowSize = 10;
        double angle = Math.atan2((endY - startY), (endX - startX));
        double arrowPointX = endX - arrowSize * Math.cos(angle);
        double arrowPointY = endY - arrowSize * Math.sin(angle);

        double arrowBackX1 = arrowPointX + arrowSize / 2 * Math.cos(angle + Math.PI / 2);
        double arrowBackY1 = arrowPointY + arrowSize / 2 * Math.sin(angle + Math.PI / 2);

        double arrowBackX2 = arrowPointX + arrowSize / 2 * Math.cos(angle - Math.PI / 2);
        double arrowBackY2 = arrowPointY + arrowSize / 2 * Math.sin(angle - Math.PI / 2);

        Polygon arrowhead = new Polygon();
        arrowhead.getPoints().addAll(endX, endY, arrowBackX1, arrowBackY1, arrowBackX2, arrowBackY2);
        arrowhead.setFill(Color.BLACK);
        return arrowhead;
    }

    private void removeTempLine() {
        if (tempLine != null) {
            getChildren().remove(tempLine);
            tempLine = null;
        }
    }

    // Method to remove edges connected to a node
    public void removeEdgesForNode(DialogueNodeView node) {
        getChildren().removeIf(n -> n instanceof Line && (
                ((Line) n).getStartX() == node.getCenterX() + node.getTranslateX() && ((Line) n).getStartY() == node.getCenterY() + node.getTranslateY() ||
                        ((Line) n).getEndX() == node.getCenterX() + node.getTranslateX() && ((Line) n).getEndY() == node.getCenterY() + node.getTranslateY()
        ));
    }
}
