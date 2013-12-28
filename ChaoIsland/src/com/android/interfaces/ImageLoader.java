package com.android.Interfaces;

import android.widget.ImageView;
import com.android.com.android.gallery.ChaoSelection;

/**
 * Created with IntelliJ IDEA.
 * User: Hassan Saleem
 * Date: 24/03/13
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */
public interface ImageLoader<T> {

    ImageView LoadImage(ImageView imageView, T image);
}
