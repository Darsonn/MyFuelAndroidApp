package pl.darsonn.myfuel.ui.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {
    private final MutableLiveData<String> titleText;
    private final MutableLiveData<String> fuelConsumptionText;
    private final MutableLiveData<String> distanceText;
    private final MutableLiveData<String> fuelPriceText;
    private final MutableLiveData<String> resultText;

    public CalculatorViewModel() {
        titleText = new MutableLiveData<>();
        fuelConsumptionText = new MutableLiveData<>();
        distanceText = new MutableLiveData<>();
        fuelPriceText = new MutableLiveData<>();
        resultText = new MutableLiveData<>();

        titleText.setValue("Fuel cost calculator");
        fuelConsumptionText.setValue("Insert fuel consumption");
        distanceText.setValue("Insert distance");
        fuelPriceText.setValue("Insert fuel price");
        resultText.setValue("Fuel price for that trip will cost:");
    }

    public LiveData<String> getTitleText() {
        return titleText;
    }

    public LiveData<String> getFuelConsumptionText() {
        return fuelConsumptionText;
    }

    public LiveData<String> getDistanceText() {
        return distanceText;
    }

    public LiveData<String> getFuelPriceText() {
        return fuelPriceText;
    }

    public LiveData<String> getResultText() {
        return resultText;
    }
}
