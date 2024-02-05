package com.example.pinchgesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var img: ImageView
    private var scale = 1f
    private lateinit var scaleGestureDetector: ScaleGestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return true // Return true to indicate the event was handled
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor // Update the scale factor
            // Ensure scale factor is within a reasonable range
            scale = 0.1f.coerceAtLeast(scale.coerceAtMost(5.0f))

            // Apply scale factor to ImageView
            img.scaleX = scale
            img.scaleY = scale
            return true
        }
    }
}