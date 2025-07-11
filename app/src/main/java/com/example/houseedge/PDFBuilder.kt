package com.example.houseedge

import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import androidx.core.content.ContextCompat
import com.example.houseedge.Hand
import java.io.File
import java.io.FileOutputStream

//LATER Create Hand class and change String to Hand
fun createPDF( context: Context,pageWidth: Int, pageHeight: Int, pageNumber :Int, handData:MutableList<Hand> )
{
    val pdfCreator = PdfDocument()

    val pdfInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()

    val page = pdfCreator.startPage(pdfInfo)

    val canvas = page.canvas
    val text = Paint()
    text.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD))
    text.setColor(ContextCompat.getColor(context,R.color.black))
    text.textSize = 30F
    text.textAlign = Paint.Align.CENTER

    canvas.drawText("House Edge",842F,100F,text)


    var y = 200F
    for (hand in handData) {
        canvas.drawText("Hand #" + hand.handNum.toString(), 842F,y,text)
        y = y +100F
        canvas.drawText("Count: " +hand.count.toString(), 842F,y,text)
        y = y +100F
        canvas.drawText("Result: "+hand.result, 842F,y,text)
        y = y +100F
        canvas.drawText("Wager: "+hand.wager.toString(), 842F,y,text)
        y = y +100F
    }

    pdfCreator.finishPage(page)

    val file = File(
       context.filesDir, "HouseEdge.pdf"
    )

    //Setup saving to external storage so the user can easily access it
    pdfCreator.writeTo(FileOutputStream(file))


    pdfCreator.close()



}



