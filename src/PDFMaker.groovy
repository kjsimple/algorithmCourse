import com.itextpdf.text.Document
import com.itextpdf.text.Jpeg
import com.itextpdf.text.Rectangle
import com.itextpdf.text.pdf.PdfWriter

/**
 *
 */

def foldName = 'd:/temp/swyx'
fileNames = []
new File(foldName).eachFile {
    fileNames.add(it.name)
}

def doc = new Document();
PdfWriter.getInstance(doc, new FileOutputStream("d:/test.pdf"))
doc.setPageSize(new Rectangle(699, 1034))
doc.open()
fileNames.sort({o1, o2-> o1.compareTo(o2)}).each {
    doc.add(new Jpeg(new URL("file:///"+new File('d:/temp/swyx', it).canonicalPath)))
}
doc.close()