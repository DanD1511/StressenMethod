package com.dand0129.stressenmethod

class StressenMethod2x2 {
    fun main() {
        val coefficientes = mutableListOf<Double>(1.0,2.0,3.0,4.0,4.0,3.0,2.0,1.0)
        val result = stressenMethod2x2(coefficientes)
        println("El resultado es:")
        for (i in result.indices) {
            for (j in result[i].indices) {
                print("${result[i][j]} ")
            }
            println()
        }
    }

    fun stressenMethod2x2(coefficients: List<Double>): Array<DoubleArray> {

        val a11 = coefficients.get(0)
        val a12 = coefficients.get(1)
        val a21 = coefficients.get(2)
        val a22 = coefficients.get(3)
        val b11 = coefficients.get(4)
        val b12 = coefficients.get(5)
        val b21 = coefficients.get(6)
        val b22 = coefficients.get(7)
        val m1 = (a11 + a22) * (b11 + b22)
        val m2 = (a21 + a22) * b11
        val m3 = a11 * (b12 - b22)
        val m4 = a22 * (b21 - b11)
        val m5 = (a11 + a12) * b22
        val m6 = (a21 - a11) * (b11 + b12)
        val m7 = (a12 - a22) * (b21 + b22)
        val c11 = m1 + m4 - m5 + m7
        val c12 = m3 + m5
        val c21 = m2 + m4
        val c22 = m1 - m2 + m3 + m6
        return arrayOf(
            doubleArrayOf(c11, c12),
            doubleArrayOf(c21, c22)
        )
    }
}