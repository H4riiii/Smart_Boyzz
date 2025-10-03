import java.util.*;

enum Type{
    PEN,
    PENCIL,
    ERASER,
    NOTEBOOK,
    PAPER,
    RULER,
    MARKER,
    HIGHLIGHTER,
    STAPLER,
    SCISSORS,
    GLUE,
    FILE,
    CLIPBOARD
}

public class ptaStore {

    int productId;
    String productName;
    private Type type;
    private int stock;

    static List<ptaStore> stockList = new ArrayList<>();

    public ptaStore(int id, String name, Type type, int initialStock){
        this.productId = id;
        this.productName = name;
        this.type = type;
        this.stock = initialStock;
    }

    public void addStock(ptaStore item, int addStockNo){

    }

}
