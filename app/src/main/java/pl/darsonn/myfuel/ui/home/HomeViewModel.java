package pl.darsonn.myfuel.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<String> homeText;
    private final MutableLiveData<String> aboutText;
    private final MutableLiveData<String> makeYourLifeEasierText;

    public HomeViewModel() {
        homeText = new MutableLiveData<>();
        aboutText = new MutableLiveData<>();
        makeYourLifeEasierText = new MutableLiveData<>();
        homeText.setValue("Welcome in");
        aboutText.setValue("Application to calculate how much money collect for transport.");
        makeYourLifeEasierText.setValue("Make your life easier with us!");
    }
    public LiveData<String> getHomeText() {
        return homeText;
    }

    public LiveData<String> getAboutText() {
        return aboutText;
    }

    public LiveData<String> getMakeYourLifeEasierText() {
        return makeYourLifeEasierText;
    }
}