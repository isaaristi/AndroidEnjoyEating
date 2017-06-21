package com.isaaristi.enjoyeating.attrs;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Attrs {


    @BindingAdapter("app:imgUrl")
    public static void loadImage (ImageView img, String url) {
        Picasso.with(img.getContext()).load(Uri.parse(url)).into(img);

    }

}
