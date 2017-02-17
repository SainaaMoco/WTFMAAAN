package demo.dev.wtfmaaan;

import java.util.ArrayList;
import java.util.List;

public class Const {
    public static final String KEY_PAGE_NUMBER = "page_number";
    public static final String KEY_ITEM_NUMBER = "item_number";
    private static List<List<Model>> myDatas = new ArrayList<>();

    public static void setupMyData(int anInt) {
        List<Model> datas = new ArrayList<>();
        for (int itemNumber = 0; itemNumber < 100; itemNumber++) {
            datas.add(new Model("page" + anInt + "-" + itemNumber));
        }
        myDatas.add(datas);
    }

    public static List<Model> getMyData(int position) {
        return myDatas.get(position);
    }
}
