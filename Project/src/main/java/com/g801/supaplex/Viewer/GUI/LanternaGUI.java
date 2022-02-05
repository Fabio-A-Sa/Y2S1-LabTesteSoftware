package com.g801.supaplex.Viewer.GUI;

import com.g801.supaplex.Model.Colors;
import com.g801.supaplex.Model.Image;
import com.g801.supaplex.Model.Position;
import com.g801.supaplex.Model.Size;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.MouseCaptureMode;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.List;

public class LanternaGUI implements GUI {

    private final TerminalScreen screen;
    private final Size size;
    protected TextGraphics tg;
    Colors colors ;

    public LanternaGUI(Size size) throws IOException {
        this.size = size;
        Terminal terminal = createTerminal(size.getWidth(), size.getHeight());
        screen = createScreen(terminal);
        this.tg = screen.newTextGraphics();
        this.colors = new Colors();
    }

    private TerminalScreen createScreen(Terminal terminal) throws IOException {
        final TerminalScreen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setTerminalEmulatorTitle("Supaplex");
        terminalFactory.setMouseCaptureMode(MouseCaptureMode.CLICK_RELEASE_DRAG_MOVE);
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setBackgroundColor(TextColor.ANSI.GREEN);
        return terminal;
    }

    @Override
    public KEYACTION getNextAction() throws IOException {

        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return KEYACTION.NONE;

        boolean isCtrlDown = keyStroke.isCtrlDown();
        return switch (keyStroke.getKeyType()) {

            case EOF -> KEYACTION.CLOSE;
            case Enter -> KEYACTION.SELECT;
            case ArrowUp -> isCtrlDown ? KEYACTION.EAT_UP : KEYACTION.UP;
            case ArrowDown -> isCtrlDown ? KEYACTION.EAT_DOWN : KEYACTION.DOWN;
            case ArrowLeft -> isCtrlDown ? KEYACTION.EAT_LEFT : KEYACTION.LEFT;
            case ArrowRight -> isCtrlDown ? KEYACTION.EAT_RIGHT : KEYACTION.RIGHT;
            case Character -> switch (keyStroke.getCharacter()) {
                case 'q' -> KEYACTION.QUIT;
                case 'p' -> KEYACTION.PAUSE;
                case 'r' -> KEYACTION.RESTART;
                case 'h' -> KEYACTION.SKIP;
                default -> KEYACTION.NONE;
            };
            default -> KEYACTION.NONE;
        };
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public Size getSize() {
        return this.size;
    }

    @Override
    public void drawRectangle(Position position) {
        TextGraphics tg = screen.newTextGraphics();
        TerminalPosition tp = new TerminalPosition(position.getX(), position.getY());
        TerminalSize ts = new TerminalSize(size.getWidth(), size.getHeight());
        tg.fillRectangle(tp, ts, TextCharacter.fromCharacter(' ', TextColor.Factory.fromString("#ff00ff"), TextColor.Factory.fromString("#00FF000"))[0]);
    }

    public void drawTextImage(Position position, char[][] textImage) {
        TerminalSize size = new TerminalSize(10, 5);
        BasicTextImage lanternaTextImage = new BasicTextImage(size);
        TextColor color;
        for (int i = 0; i < size.getRows(); i++) {
            for (int j = 0; j < size.getColumns(); j++) {
                color = TextColor.Factory.fromString(colors.getColorString(textImage[i][j]));
                lanternaTextImage.setCharacterAt(j,i, TextCharacter.fromCharacter(textImage[i][j], color, color)[0]);
            }
        }
        TextGraphics tg = screen.newTextGraphics();
        tg.drawImage(new TerminalPosition(position.getX(), position.getY()),  lanternaTextImage);
    }

    @Override
    public TerminalScreen getScreen() {
        return screen;
    }

    public int getCol(String s) {
        return ((screen.getTerminalSize().getColumns() - s.length()) / 2 + 1);
    }

    @Override
    public void drawStringCentered(TextColor color, int row, String s) {
        tg.setForegroundColor(color);
        tg.putString(getCol(s), row, s, SGR.BOLD);
    }

    public void drawString(TextColor color, int col, int row, String s) {
        tg.setForegroundColor(color);
        tg.putString(col, row, s, SGR.BOLD);
    }

    public void drawImages(List<Image> elements) {
        for (Image img : elements) {
            this.drawTextImage(img.getPosition(), img.getBitMap());
        }
    }

    public void drawTitleBorder() {

        TextGraphics tg = getScreen().newTextGraphics();

        //CORNERS
        tg.setForegroundColor(TextColor.ANSI.YELLOW).setCharacter(65,8, Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER);
        tg.setCharacter(65, 5, Symbols.DOUBLE_LINE_TOP_LEFT_CORNER);
        tg.setCharacter(85, 8, Symbols.DOUBLE_LINE_BOTTOM_RIGHT_CORNER);
        tg.setCharacter(85, 5, Symbols.DOUBLE_LINE_TOP_RIGHT_CORNER);

        // HORIZONTAL LINES
        tg.drawLine(66, 8, 84, 8, Symbols.DOUBLE_LINE_HORIZONTAL);
        tg.drawLine(66, 5,84,5, Symbols.DOUBLE_LINE_HORIZONTAL);

        // VERTICAL LINES
        tg.drawLine(65, 7,65 ,6, Symbols.DOUBLE_LINE_VERTICAL);
        tg.drawLine(85,7,85, 6, Symbols.DOUBLE_LINE_VERTICAL);
    }
}