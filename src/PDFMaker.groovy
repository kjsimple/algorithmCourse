import com.itextpdf.text.Document
import com.itextpdf.text.Image
import com.itextpdf.text.Rectangle
import com.itextpdf.text.pdf.PdfWriter

/**
 *
 */

def foldName = 'd:/temp/hfjj'
def dest = 'd:/test.pdf'

fileNames = []
new File(foldName).eachFile {
    fileNames.add(it.name)
}

def doc = new Document();
PdfWriter.getInstance(doc, new FileOutputStream(dest))
doc.setPageSize(new Rectangle(991, 1439))
doc.open()
fileNames.sort({o1, o2-> o1.compareTo(o2)}).each {
    doc.add(Image.getInstance(new File(foldName, it).canonicalPath))
}
doc.close()
