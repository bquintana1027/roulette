package edu.cnm.deepdive.roulette.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.roulette.R;
import java.security.SecureRandom;
import java.util.Random;

public class HomeViewModel extends AndroidViewModel {

  public static final int POCKETS_ON_WHEEL = (int) 38f;
  private final MutableLiveData<String> rouletteValue;
  private final MutableLiveData<Integer> pocketIndex;
  private final Random rng;
  private final String [] pocketValues;


  public HomeViewModel(@NonNull Application application) {
    super(application);
    rouletteValue = new MutableLiveData<>("00");
    rng = new SecureRandom();
    pocketIndex = new MutableLiveData<>();
    pocketValues = application.getResources().getStringArray(R.array.pocket_values);
  }

  public LiveData<String> getRouletteValue() {
    return rouletteValue;
  }

  public LiveData<Integer> getPocketIndex() {
    return pocketIndex;
  }

  public void spinWheel(int i) {
    int selection = rng.nextInt(POCKETS_ON_WHEEL);
    pocketIndex.setValue(selection);
    rouletteValue.setValue(pocketValues[selection]);
  }
}
