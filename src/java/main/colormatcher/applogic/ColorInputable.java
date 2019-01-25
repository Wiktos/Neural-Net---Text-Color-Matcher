package java.main.colormatcher.applogic;

import java.util.Optional;

/**
 * Created by Wiktor Łazarski on 25.01.2019.
 */
public interface ColorInputable {

    public Optional<Integer> redValue();
    public Optional<Integer> greenValue();
    public Optional<Integer> blueValue();

}
