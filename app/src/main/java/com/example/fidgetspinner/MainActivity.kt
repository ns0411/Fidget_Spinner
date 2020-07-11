package com.example.fidgetspinner

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {

    lateinit var vibration: Vibrator
    lateinit var fidgetSpinner:ShapeableImageView



    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vibration= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        fidgetSpinner=findViewById(R.id.spinner)

        val animate = RotateAnimation(0f, 10000000f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.6f)
        animate.duration = 500
        animate.repeatCount = Animation.INFINITE
        animate.interpolator = LinearOutSlowInInterpolator()




        fidgetSpinner.setOnTouchListener { v, event ->
            when (event.action) {
                KeyEvent.ACTION_DOWN -> {
                    fidgetSpinner.startAnimation(animate)
                    if(vibration.hasVibrator())
                    vibration.vibrate(40000000)
                }
                KeyEvent.ACTION_UP -> {
                    fidgetSpinner.clearAnimation()
                    if(vibration.hasVibrator())
                    vibration.cancel()
                }
            }


            true
        }


        }
    }
