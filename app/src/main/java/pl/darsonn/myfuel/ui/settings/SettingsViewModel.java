package pl.darsonn.myfuel.ui.settings;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {
    private final MutableLiveData<String> wipText;

    public SettingsViewModel() {
        wipText = new MutableLiveData<>();
        wipText.setValue("Nothing to see here yet!");
    }

    public MutableLiveData<String> getWipText() {
        return wipText;
    }
}
