package edu.psu.ist.hcdd340.pennstateid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "LOG_IN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.button_login);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText emailEditText = findViewById(R.id.editTextEmail);
        String email = emailEditText.getText().toString();

        EditText passwordEditText = findViewById(R.id.editTextPassword);
        String password = passwordEditText.getText().toString();
        Log.d(TAG, "Email: " + email + " and Password: " + password);

        /** toy example — DO NOT do this in production code! **/
        String userAllowed = "hcdd340@psu.edu";
        String correctPassword = "IST";
        if (email.equals(userAllowed) &&
                password.equals(correctPassword)) {
            Button button = findViewById(R.id.button_login);
            Snackbar.make(button,
                    "Logged In!",
                    Snackbar.LENGTH_LONG).show();
        } else {
            AlertDialog.Builder d = new AlertDialog.Builder(this);
            d.setTitle(R.string.login_error_title);
            d.setMessage(R.string.login_error_message);
            d.setPositiveButton(android.R.string.ok, null);
            d.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        if (menuId == R.id.menu_info) {
            Button button = findViewById(R.id.button_login);
            Snackbar.make(button,
                    R.string.app_info,
                    Snackbar.LENGTH_LONG).show();
            return true;
        } else if (menuId == R.id.menu_register) {
            Button button = findViewById(R.id.button_login);
            Snackbar.make(button,
                    "Registration not implemented yet!",
                    Snackbar.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}