package dk.easj.anbo.eventhandlerexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "eventing";
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageView = findViewById(R.id.mainMessageTextView);
        Button secondButton = findViewById(R.id.mainSecondButton);
        EditText emailEditText = findViewById(R.id.mainEmailEditText);
        EditText passwordEditText = findViewById(R.id.mainPasswordEditText);

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageView.append("Second button clicked\n");
            }
        });


        secondButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                messageView.append("Second button long clicked\n");
                return false;
            }
        });

        emailEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageView.append("EditText clicked\n");
            }
        });

        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String focus = hasFocus ? "gained" : "lost";
                messageView.append("Email EditText focus " + focus + "\n");
            }
        });

        // A sort of key logger ...
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                messageView.append("Password EditText text changed: " + s + "\n");
            }
        });

    }

    public void buttonClicked(View view) {
        Log.d(TAG, "First button clicked");
        messageView.append("First button clicked\n");
    }
}