package view;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TestView extends BaseView {
    public TestView(double width, double height) {
        super(width, height);
    }

    public void Draw() {
        gfx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gfx.setFill(Color.RED);
        gfx.setStroke(Color.BLACK);
        gfx.setLineWidth(2);

        gfx.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
        gfx.fillText("Hello, World!", 280, 300);
        gfx.strokeText("Hello, World!", 280, 300);
    }
}
