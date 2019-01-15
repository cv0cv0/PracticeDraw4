package com.hencoder.hencoderpracticedraw4.practice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

import com.hencoder.hencoderpracticedraw4.R

class Practice13CameraRotateHittingFaceView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val point = PointF(200f, 50f)
    private val bitmap by lazy(LazyThreadSafetyMode.NONE) {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        Bitmap.createScaledBitmap(bitmap, bitmap.width * 2, bitmap.height * 2, true)
    }

    private val matrix1 = Matrix()
    private val camera = Camera().apply {
        val newZ = -resources.displayMetrics.density * 6
        setLocation(0f, 0f, newZ)
    }

    private val animator = ObjectAnimator.ofFloat(this, "degree", 0f, 360f).apply {
        duration = 5000
        interpolator = LinearInterpolator()
        repeatCount = ValueAnimator.INFINITE
    }

    private var degree: Float = 0f

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Float) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val centerX = point.x + bitmapWidth / 2f
        val centerY = point.y + bitmapHeight / 2f

        camera.save()
        matrix1.reset()
        camera.rotateX(degree)
        camera.getMatrix(matrix1)
        camera.restore()
        matrix1.preTranslate((-centerX), (-centerY))
        matrix1.postTranslate(centerX, centerY)
        canvas.save()
        canvas.concat(matrix1)
        canvas.drawBitmap(bitmap, point.x, point.y, paint)
        canvas.restore()
    }
}