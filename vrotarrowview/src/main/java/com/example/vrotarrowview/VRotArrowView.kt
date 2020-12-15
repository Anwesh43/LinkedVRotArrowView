package com.example.vrotarrowview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas

val parts : Int = 3
val strokeFactor : Float = 90f
val sizeFactor : Float = 3.9f
val backColor : Int = Color.parseColor("#BDBDBD")
val colors : Array<Int> = arrayOf(
    "#F44336",
    "#673AB7",
    "#2196F3",
    "#8BC34A",
    "#795548"
).map {
    Color.parseColor(it)
}.toTypedArray()
val scGap : Float = 0.02f / parts
val rot : Float = 45f
val arrowFactor : Float = 12.3f
val delay : Long = 20