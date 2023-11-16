package ru.job4j.odd.osp;

/**
 * Нарушение принципа OCP: добавление новых типов фигур требует изменения существующего кода через if.
 */
public class ShapeWrong {
    private String type;

    public ShapeWrong(String type) {
        this.type = type;
    }

    public void draw() {
        if (type.equals("circle")) {
            drawCircle();
        } else if (type.equals("rectangle")) {
            drawRectangle();
        } else if (type.equals("square")) {
            drawSquare();
        }
    }

    private void drawCircle() {
        System.out.println("Drawing a circle");
    }

    private void drawRectangle() {
        System.out.println("Drawing a rectangle");
    }

    private void drawSquare() {
        System.out.println("Drawing a square");
    }
}
