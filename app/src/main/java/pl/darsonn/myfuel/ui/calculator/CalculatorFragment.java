package pl.darsonn.myfuel.ui.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import pl.darsonn.myfuel.R;
import pl.darsonn.myfuel.databinding.FragmentCalculatorBinding;

public class CalculatorFragment extends Fragment {
    private FragmentCalculatorBinding binding;
    private TextView result;
    private TextView resultText;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalculatorViewModel calculatorViewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button calculateButton = binding.calculatebutton;

        TextView titleText = binding.textCalculatorHeader;
        TextView fuelConsumptionText = binding.textCalculatorFuelconsumption;
        TextView distanceText = binding.textCalculatorDistance;
        TextView fuelPriceText = binding.textCalculatorFuelprice;
        resultText = binding.resultText;

        calculatorViewModel.getTitleText().observe(getViewLifecycleOwner(), titleText::setText);
        calculatorViewModel.getFuelConsumptionText().observe(getViewLifecycleOwner(), fuelConsumptionText::setText);
        calculatorViewModel.getDistanceText().observe(getViewLifecycleOwner(), distanceText::setText);
        calculatorViewModel.getFuelPriceText().observe(getViewLifecycleOwner(), fuelPriceText::setText);
        calculatorViewModel.getResultText().observe(getViewLifecycleOwner(), resultText::setText);

        result = binding.result;

        resultText.setVisibility(View.INVISIBLE);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                EditText fuelConsumptionEditText = binding.getRoot().findViewById(R.id.fuelconsumption);
                EditText fuelPriceEditText = binding.getRoot().findViewById(R.id.fuelprice);
                EditText distanceEditText = binding.getRoot().findViewById(R.id.distance);

                float fuelConsumption = Float.parseFloat(fuelConsumptionEditText.getText().toString());
                float fuelPrice = Float.parseFloat(fuelPriceEditText.getText().toString());
                float distance = Float.parseFloat(distanceEditText.getText().toString());

                float resultValue = (fuelConsumption * distance / 100) * fuelPrice;
                resultValue = (float) (Math.round(resultValue*100.0)/100.0);
                resultText.setVisibility(View.VISIBLE);
                result.setText(resultValue + " zł");
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
