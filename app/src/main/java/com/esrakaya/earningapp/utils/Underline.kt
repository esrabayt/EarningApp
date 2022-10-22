package com.esrakaya.earningapp.utils

import android.graphics.Paint.UNDERLINE_TEXT_FLAG
import android.widget.TextView

fun TextView.underline() {
    paintFlags = paintFlags or UNDERLINE_TEXT_FLAG
}