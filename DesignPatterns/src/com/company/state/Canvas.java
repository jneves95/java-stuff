package com.company.state;

/**
 * To demonstrate our State pattern, we are going to use an example of a Canvas (like a MS Paint canvas), where we can use different tools that act differently on said canvas.
 *
 * By using this pattern, we are applying the Open Closed Principle - meaning our class (Canvas) is open for extension, but closed for modification.
 */
public class Canvas {
    private ToolType currentToolType;
    private Tool currentTool;

    /**
     * As we can see from these two methods, we have a lot of repetitive code for every case, and for each new tool type, we would have to extend every method manually.
     * This is not very practical nor maintainable.
     */
    public void mouseDownInefficient() {
        switch (currentToolType) {
            case SELECTION:
                System.out.println("Selection icon");
                break;
            case BRUSH:
                System.out.println("Brush icon");
                break;
            case ERASER:
                System.out.println("Eraser icon");
                break;
        }
    }

    public void mouseUpInefficient() {
        switch (currentToolType) {
            case SELECTION:
                System.out.println("Draw dashed rectangle");
                break;
            case BRUSH:
                System.out.println("Draw line");
                break;
            case ERASER:
                System.out.println("Erase something");
                break;
        }
    }

    /**
     * Now for our cleaner methods using polymorphism through the state pattern.
     * Our canvas class is simply delegating now - no more long lists of decision-making statements, so it's more maintainable, and easily extendable.
     */
    public void mouseDown() {
        currentTool.mouseDown();
    }

    public void mouseUp() {
        currentTool.mouseUp();
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }
}
