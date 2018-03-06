package com.example.mitch.myapplication2;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mitch on 3/5/2018.
 */

public class GoogleSearchIntentActivity extends Activity {

        private EditText editTextInput;

        @Override
        public void onCreate(Bundle saveInstanceState){
            super.onCreate(saveInstanceState);
            setContentView(R.layout.main);

            editTextInput = (EditText) findViewById(R.id.editTextInput);


        }

        public void onSearchClick(View v){

            try {

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String term = editTextInput.getText().toString();
                intent.putExtra(SearchManager.QUERY, term);

                startActivity(intent);
            } catch (Exception e){
                System.out.println("error");
            }
        }
}
