package com.android.com.android.gallery;

/**
 * Created with IntelliJ IDEA.
 * User: Hassan Saleem
 * Date: 24/03/13
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class ChaoSelection {



    public String getAlignment() {
        return Alignment;
    }

    public String getFirstEvolution() {
        return FirstEvolution;
    }

    public String getTone() {
        return Tone;
    }

    public String getToneSelection() {
        return ToneSelection;
    }


    ///return image file name always in lower case
    public String getImageFileName()
    {

        String imgName = null;


        imgName = Alignment +FirstEvolution;

        if (Tone.equals("Normal"))
        {
            imgName = imgName + Tone;
        }
        else
        {
            imgName = imgName + Tone + ToneSelection;
            imgName = imgName.toLowerCase();
        }

        imgName = imgName.replace("Normal","");

        return imgName.toLowerCase();
    }

    private String Alignment;
    private String FirstEvolution;
    private String Tone;
    private String ToneSelection;

    public ChaoSelection(String alignment, String firstEvolution, String tone, String toneSelection)
    {
        Alignment = alignment;
        FirstEvolution = firstEvolution;
        Tone = tone;
        ToneSelection = toneSelection;
    }
}
