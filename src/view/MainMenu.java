package view;

import config.Config;
import game.GameData;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import manager.ResourceManager;
import state.SplashState;

import java.util.ArrayList;

public class MainMenu extends BaseView {
    private final GameData data;
    private final Color textFill = Color.RED;
    private final Color textStroke = Color.BLACK;
    private final Color textSelectedFill = Color.GREEN;
    private int selectedOption = 0;
    private int maxIndex = 3;
    private ArrayList<Text> optionsList = new ArrayList<>();

    public MainMenu(GameData data) {
        super(data);
        data.getResourceManager().LoadResourcesFor(ResourceManager.Purpose.MainMenu);
        this.data = data;
    }

    @Override
    public void Draw() {
        gfx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        optionsList.forEach(text -> text.setFill(textFill));
        optionsList.get(selectedOption).setFill(textSelectedFill);
    }

    @Override
    public void Init() {
        data.setCanvas(canvas);
        data.setGfx(canvas.getGraphicsContext2D());
        data.replaceRootCanvas(canvas);

        Text startGame = new Text(Config.MAIN_MENU_START_GAME);
        AddMenuOption(startGame, 50);

        Text options = new Text(Config.OPTIONS);
        AddMenuOption(options, 150);

        Text quit = new Text(Config.QUIT);
        AddMenuOption(quit, 250);
    }

    private void AddMenuOption(Text text, int offsetYFromCenter) {
        optionsList.add(text);
        text.setFill(textFill);
        text.setStroke(textStroke);
        text.setFont(ResourceManager.getInstance().getFont(ResourceManager.CustomFont.Ken));
        centerTextToScene(text);
        text.setY(text.getY() + offsetYFromCenter);
        root.getChildren().add(text);
    }

    @Override
    public void IncrementIndex() {
        selectedOption++;
        if (selectedOption == maxIndex) {
            selectedOption = 0;
        }
    }

    @Override
    public void DecrementIndex() {
        selectedOption--;
        if (selectedOption == -1) {
            selectedOption = maxIndex - 1;
        }
    }

    @Override
    public void ExecuteCurrentOption() {
        switch (selectedOption) {
            case 0:
                System.out.println("Start new game!");
                break;
            case 1:
                System.out.println("Options");
                break;
            case 2:
                data.getStateMachine().AddState(new SplashState(data, Config.QUIT_GAME, true), true);
        }
    }
}
