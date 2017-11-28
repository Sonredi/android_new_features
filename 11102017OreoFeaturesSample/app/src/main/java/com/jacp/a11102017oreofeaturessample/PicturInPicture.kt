package com.jacp.a11102017oreofeaturessample

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Rational
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pictur_in_picture.*

class PicturInPicture : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictur_in_picture)
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(a_picture_view)
        a_picture_btn.setOnClickListener{enterPiPMode()}
    }

    private fun enterPiPMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val pipParams = PictureInPictureParams.Builder()
                    .setAspectRatio(Rational(a_picture_view.width, a_picture_view.height))
                    .build()
            enterPictureInPictureMode(pipParams)
        }
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode){
            supportActionBar?.hide()
            a_picture_btn.visibility = View.GONE
        } else {
            supportActionBar?.show()
            a_picture_btn.visibility = View.VISIBLE
        }
    }


}
