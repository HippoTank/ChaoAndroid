package com.android.ChaoIsland;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.android.com.android.gallery.ChaoSelection;

import java.security.PrivateKey;

/**
 * Created with IntelliJ IDEA.
 * User: Hassan Saleem
 * Date: 24/03/13
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class Gallery extends Activity {

    private Spinner AlignmentSpinner;
    private Spinner FirstEvolutionSpinner;
    private Spinner ToneSpinner;
    private Spinner ToneChoiceSpinner;

    private String AlignmentValue;
    private String FirstEvolutionValue;
    private String ToneValue;
    private String ToneChoiceValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        AlignmentSpinner = (Spinner) findViewById(R.id.alignment);
        FirstEvolutionSpinner = (Spinner) findViewById(R.id.firstEvolution);
        ToneSpinner = (Spinner) findViewById(R.id.tone);
        ToneChoiceSpinner = (Spinner) findViewById(R.id.toneChoice);

        InitialiseSpinnerValues();
        SetChaoGalleryImage();

        AlignmentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                AlignmentValue =  parentView.getItemAtPosition(position).toString();
                SetChaoGalleryImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        FirstEvolutionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                FirstEvolutionValue =  parentView.getItemAtPosition(position).toString();
                SetChaoGalleryImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        ToneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selection = parentView.getItemAtPosition(position).toString();
                LinearLayout layout = (LinearLayout)findViewById(R.id.ToneChoiceLO);
                TextView text = (TextView) findViewById(R.id.toneChoiceLabel);


                if (selection.equals("Normal"))
                {
                    layout.setVisibility(View.INVISIBLE);
                }
                else if (selection.equals("Jewel"))
                {
                    text.setText("Jewel");
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Gallery.this, R.array.jewel, android.R.layout.simple_spinner_item );
                    ToneChoiceSpinner.setAdapter(adapter);
                    layout.setVisibility(View.VISIBLE);
                }
                else
                {
                    text.setText("Colour");
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Gallery.this, R.array.colour, android.R.layout.simple_spinner_item );
                    ToneChoiceSpinner.setAdapter(adapter);
                    layout.setVisibility(View.VISIBLE);
                }

                ToneValue =  parentView.getItemAtPosition(position).toString();
                SetChaoGalleryImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        ToneChoiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ToneChoiceValue =  parentView.getItemAtPosition(position).toString();
                SetChaoGalleryImage();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    private void InitialiseSpinnerValues() {
        AlignmentValue = AlignmentSpinner.getItemAtPosition(0).toString();
        FirstEvolutionValue = FirstEvolutionSpinner.getItemAtPosition(0).toString();
        ToneValue = ToneSpinner.getItemAtPosition(0).toString();
        ToneChoiceValue = ToneChoiceSpinner.getItemAtPosition(0).toString();
    }

    private void SetChaoGalleryImage()
   {
       ImageView imageView = (ImageView)  findViewById(R.id.chaoImageView);
       Resources res = getResources();
       String mDrawableName = GetChaoSelection().getImageFileName();
       int resID = res.getIdentifier(mDrawableName , "drawable", getPackageName());
       Drawable drawable = res.getDrawable(resID );
       imageView.setImageDrawable(drawable );
   }

   private ChaoSelection GetChaoSelection()
    {
        String res =  AlignmentSpinner.getSelectedItem().toString();
        ChaoSelection chaoSelection = new ChaoSelection(AlignmentValue,
                                                        FirstEvolutionValue,
                                                        ToneValue,
                                                        ToneChoiceValue);
        return chaoSelection;
    }

}