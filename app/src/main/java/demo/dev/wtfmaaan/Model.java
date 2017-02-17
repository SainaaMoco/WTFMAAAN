package demo.dev.wtfmaaan;

import java.io.Serializable;

public class Model implements Serializable {
    private boolean wtfIsSelected = false;
    private String wtfName;

    Model(String wtfName) {
        this.wtfName = wtfName;
    }

    public boolean isWtfIsSelected() {
        return wtfIsSelected;
    }

    public void setWtfIsSelected(boolean wtfIsSelected) {
        this.wtfIsSelected = wtfIsSelected;
    }

    public String getWtfName() {
        return wtfName;
    }
}
