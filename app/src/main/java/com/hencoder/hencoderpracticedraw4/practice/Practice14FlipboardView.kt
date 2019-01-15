package com.hencoder.hencoderpracticedraw4.practice

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.hencoder.hencoderpracticedraw4.R

class Practice14FlipboardView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    private val camera = Camera()

    private val animator = ObjectAnimator.ofFloat(this, "degree", 0f, 180f).apply {
        duration = 2500
        interpolator = LinearInterpolator()
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.REVERSE
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
        val centerX = width / 2f
        val centerY = height / 2f
        val x = centerX - bitmapWidth / 2f
        val y = centerY - bitmapHeight / 2f

        canvas.save()
        canvas.clipRect(0, 0, width, height / 2)
        canvas.drawBitmap(bitmap, x, y, paint)
        canvas.restore()

        canvas.save()
        camera.save()
        camera.rotateX(degree)
        if (degree < 90) {
            canvas.clipRect(0, height / 2, width, height)
        } else {
            canvas.clipRect(0, 0, width, height / 2)
        }
        canvas.translate(centerX, centerY)
        camera.applyToCanvas(canvas)
        canvas.translate((-centerX), (-centerY))
        canvas.drawBitmap(bitmap, x, y, paint)
        camera.restore()
        canvas.restore()
    }
}
