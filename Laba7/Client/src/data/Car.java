package data;

import java.io.Serializable;

public class Car implements Serializable {
    private Boolean cool;

    public void setCool(Boolean cool) {
        this.cool = cool;
    }

    public Boolean getCool() {
        return cool;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cool=" + cool +
                '}';
    }
}
