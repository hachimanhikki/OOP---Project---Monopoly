import java.util.ArrayList;

public class Board {
    private ArrayList<Field> cells;
    public Board() {
        cells = new ArrayList<Field>();
    }
    public void addCell(Field p) {
        this.cells.add(p);
    }
    public void initMove(Player player) {
        int position = player.getPosition();
        if (position >= 16) {
            player.setPosition(position - 16);
            position -= 16;
        }
        if (cells.get(position) instanceof SpecialField) {

        }
    }
}
