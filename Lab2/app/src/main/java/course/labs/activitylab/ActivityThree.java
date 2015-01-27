package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityThree extends Activity {
    private static final String TEXT_KEY = "text";
    private final static String TAG = "Lab-ActivityThree";

    String mText = "";

    TextView mainTextView;
    EditText mainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        if (savedInstanceState != null) {
            mText = savedInstanceState.getString(TEXT_KEY);
            Log.i(TAG, "value of mText is " + mText);
        }

        mainTextView = (TextView) findViewById(R.id.textView);
        mainTextView.setText(mText + " is trying the edit view!");


        mainEditText = (EditText) findViewById(R.id.editView);

        Button updateTextButton = (Button) findViewById(R.id.bUpdateTextView);
        updateTextButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mainTextView.setText(mainEditText.getText().toString()
                        + " is trying the edit view!");
            }
        });

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mText = savedInstanceState.getString(TEXT_KEY);
        Log.i(TAG, "saved data: " + mText);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(TEXT_KEY, mainEditText.getText().toString());
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "onSaveInstanceState" + mainEditText.getText().toString());
    }
}