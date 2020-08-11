package com.ankush.mathsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_inverse_matrix.*

class InverseMatrix : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inverse_matrix)
        arr()
    }

    var size = 0
    var A = Array(0, { IntArray(0) })
    var B = Array(0, { IntArray(0) })
    var C = Array(0, { FloatArray(0) })
    fun arr() {
        rdgrp.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.bu1 -> {
                    A = Array(2, { IntArray(2) })
                    B = Array(2, { IntArray(2) })
                    C = Array(2, { FloatArray(2) })
                    size = 2
                }
                R.id.bu2 -> {
                    A = Array(3, { IntArray(3) })
                    B = Array(3, { IntArray(3) })
                    C = Array(3, { FloatArray(3) })
                    size = 3
                }
            }
        }
    }

    var row = 0
    var col = 0
    fun mat(view: View) {
        A[row][col] = valA.text.toString().toInt()
        if ((col == A[0].size - 1) && (row == A.size - 1)) {
            valA.setText("")
            row = 0
            col = 0
            data.isEnabled = false
        } else if (col == A[0].size - 1) {
            col = 0
            row++
            valA.setText("")
        } else {
            col++
            valA.setText("")
        }

    }

    fun ans(view: View) {
        var p = 0
        var pos = 1
        var neg = 1
        var c = 1
        var det = 0
        when (size) {
            2 -> {
                det = A[0][0] * A[1][1] - A[0][1] * A[1][0]
            }
            3 -> {
                var i = 0
                for (j in 0..2) {
                    for (k in 0..2) {
                        for (l in 0..2) {
                            if (k != i && l != j) {
                                p++
                                if (p == 1 || p == 4)
                                    pos *= A[k][l]
                                else
                                    neg *= A[k][l]
                            }
                        }
                    }
                    det = det + c * A[i][j] * (pos - neg)
                    pos = 1
                    neg = 1
                    c *= -1
                    p=0
                }
            }
        }
        detxt.text = det.toString()
        p=0
        c = 1
        for (i in 0..A[0].size - 1) {
            for (j in 0..A.size - 1) {
                B[j][i] = A[i][j]
            }
        }
        when(size)
        {
            2 -> {
                A[0][0]=B[1][1]
                A[0][1]=-B[1][0]
                A[1][0]=-B[0][1]
                A[1][1]=B[0][0]
            }
            3 ->
            {
                for (i in 0..A[0].size - 1) {
                    for (j in 0..A.size - 1) {
                        for (k in 0..A[0].size - 1) {
                            for (l in 0..A.size - 1) {
                                if (k != i && l != j) {
                                    p++
                                    if (p == 1 || p == 4)
                                        pos *= B[k][l]
                                    else
                                        neg *= B[k][l]
                                }
                            }
                        }
                        A[i][j] = c * (pos - neg)
                        pos = 1
                        neg = 1
                        c *= -1
                        p=0
                    }
                }
            }
        }

        var ch=""
        for (i in 0..A[0].size - 1) {
            for (j in 0..A.size - 1) {
                ch = ch + A[i][j].toString()
                adjoint.text = ch
                ch += " "
            }
            ch += "\n"
        }
        ch=""
        for (i in 0..A[0].size - 1) {
            for (j in 0..A.size - 1) {
                C[i][j]=A[i][j].toFloat()/det.toFloat()
                ch = ch + C[i][j].toString()
                invrs.text = ch
                ch += " "
            }
            ch += "\n"
        }
    }
}