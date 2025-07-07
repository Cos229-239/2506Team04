package com.example.houseedge

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream

//LATER Create Hand class and change String to Hand
fun createPDF( context: Context,pageWidth: Int, pageHeight: Int, pageNumber :Int, handData:MutableList<String> )
{
    val pdfCreator = PdfDocument()

    val pdfInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()

    val page = pdfCreator.startPage(pdfInfo)

    val canvas = page.canvas
    val text = Paint()
    text.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL))
    text.setColor(ContextCompat.getColor(context,R.color.teal_200))
    text.textSize = 20F
    text.textAlign = Paint.Align.CENTER

    canvas.drawText("House Edge",200F,100F,text)

    pdfCreator.finishPage(page)

    val file = File(
       context.filesDir, "HouseEdge.pdf"
    )

    //Setup saving to external storage so the user can easily access it
    pdfCreator.writeTo(FileOutputStream(file))


    pdfCreator.close()



}



