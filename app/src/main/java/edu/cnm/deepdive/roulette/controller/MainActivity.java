package edu.cnm.deepdive.roulette.controller;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.roulette.R;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private NavController navController;
  private NavController navController1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BottomNavigationView navView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.navigation_play, R.id.navigation_dashboard, R.id.navigation_notifications)
        .build();
    navController1 = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController1, appBarConfiguration);
    NavigationUI.setupWithNavController(navView, navController1);
  }

  @Override
  public boolean onSupportNavigateUp() {
    return NavigationUI.navigateUp(navController, appBarConfiguration)
        || super.onSupportNavigateUp();
  }
}