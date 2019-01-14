package com.hencoder.hencoderpracticedraw4.practice

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw4.R

class Practice11CameraRotateView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    private val point1 = Point(200, 200)
    private val point2 = Point(600, 200)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
    }
}
