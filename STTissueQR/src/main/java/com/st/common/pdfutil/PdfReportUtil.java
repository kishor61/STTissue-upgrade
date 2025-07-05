package com.st.common.pdfutil;

import java.awt.Color;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Utilities;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportUtil {
	private Document document;
	private PdfWriter writer;
	private boolean headerFooter=true;
	private boolean waterMark=true;
	
	public PdfReportUtil() {
		document=new Document();
	}
	
	public PdfReportUtil(float marginLeft,float marginRight,float marginTop,float marginBottom) {
		document=new Document();
		document.setMargins(marginLeft, marginRight, marginTop, marginBottom);
	}
	
	public PdfReportUtil(boolean headerFooter) {
		document=new Document();
		this.headerFooter=headerFooter;
	}
	
	public void setOuputStream(OutputStream outputStream) throws DocumentException{
		
		writer=PdfWriter.getInstance(document, outputStream);
		if(headerFooter){
			HeaderFooter event = new HeaderFooter();
		    writer.setPageEvent(event);
		}
	}

	
	public void setPage(int page){
		if(PdfStyle.PAGE_LEGAL_PORTRAIT==page){
			Rectangle rectangle=new Rectangle(Utilities.inchesToPoints(8.5f), Utilities.inchesToPoints(14f));
			document.setPageSize(rectangle);
		}else if(PdfStyle.PAGE_LEGAL_LANDSCAPE==page){
			Rectangle rectangle=new Rectangle(Utilities.inchesToPoints(14f),Utilities.inchesToPoints(8.5f));
			document.setPageSize(rectangle);
		}else if(PdfStyle.PAGE_LEGAL_PORTRAIT_Receiving_Reports==page){
			Rectangle rectangle=new Rectangle(Utilities.inchesToPoints(7.5f), Utilities.inchesToPoints(13f));
			document.setPageSize(rectangle);
		}
	}
	
	public void setDocumentTitle(String title){
		document.addTitle(title+"-"+new SimpleDateFormat(" MMM dd, yyyy").format(new Date()));
		document.addAuthor("ST Tissue Llc");
		//document.addCreator("ST Tissue Quality Application");
	}
	
	public void newPage(){
		document.newPage();
	}
	public void open(){
		document.open();
	}
	public void close(){
		document.close();
	}
	
	
	public class Section{
		private Paragraph paragraph;
		public Section(float spacingTop,float sapcingBot,int align) {
			paragraph=new Paragraph();
			paragraph.setSpacingBefore(spacingTop);
			paragraph.setSpacingAfter(sapcingBot);
			paragraph.setAlignment(getAlignment(align));
		}
		
		public void addText(String value,int fontType){
			
			Chunk chunk=new Chunk(value,getFont(fontType));
			paragraph.add(chunk);
		}
		
		public void addImage(URL img,float width,float height) throws Exception{
			Image image=Image.getInstance(img);
			image.scaleAbsolute(width, height);
			Chunk chunk=new Chunk(image, 0, 0, true);
			paragraph.add(chunk);
		}
		
		public void finish() throws Exception{
			document.add(paragraph);
		}
		public Paragraph getParagraph(){
			return paragraph;
		}
	}
	
	
	public class Table{
		private PdfPTable pdfPTable;
		public Table(int cols,float[] widths) throws Exception {
			pdfPTable=new PdfPTable(cols);
			pdfPTable.setWidths(widths);
			pdfPTable.setWidthPercentage(100f);
			
		}
		public void setCommonHeader(boolean header){
			if(header){
				pdfPTable.setHeaderRows(1);
			}
		}
		
		public void setCommonHeader(boolean header,int rows){
			if(header){
				pdfPTable.setHeaderRows(rows);
			}
		}
		
		public void addCell(String value,int fontType,int align,int colspan,int rowspan){
			PdfPCell cell=new PdfPCell();
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(0.05f);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPadding(8);
			cell.setPaddingTop(0);
			//Code Done By Roshan Tailor
			cell.setPaddingBottom(2);
			//Code Ends Here
			pdfPTable.addCell(cell);
		}
		public void addCell(String value,int fontType,int align,int colspan,int rowspan,float paddingLeft,float paddingRight,float paddingTop,float paddingBottom){
			PdfPCell cell=new PdfPCell();
			cell.setUseAscender(true);
			
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			
			cell.addElement(paragraph);
			cell.setBorderWidth(0.05f);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPaddingTop(paddingTop);
			cell.setPaddingBottom(paddingBottom);
			cell.setPaddingRight(paddingRight);
			cell.setPaddingLeft(paddingLeft);;
			
			pdfPTable.addCell(cell);
		}
		
		public void addCell(Section section,int colspan,int rowspan,float borderWidth){
			PdfPCell cell=new PdfPCell();
			cell.addElement(section.getParagraph());
			cell.setBorderWidth(borderWidth);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPadding(8);
			cell.setPaddingTop(0);
			pdfPTable.addCell(cell);
		}
		
		
		
		public void addCell(Section section,int colspan,int rowspan,float border,float paddingLeft,float paddingRight,float paddingTop,float paddingBottom){
			PdfPCell cell=new PdfPCell();
			cell.setUseAscender(true);
			
			cell.addElement(section.getParagraph());
			cell.setBorderWidth(border);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			
			cell.setPaddingTop(paddingTop);
			cell.setPaddingBottom(paddingBottom);
			cell.setPaddingRight(paddingRight);
			cell.setPaddingLeft(paddingLeft);
			pdfPTable.addCell(cell);
		}
		
		public void addCell(String value,int fontType,int align,int colspan,int rowspan,float border){
			PdfPCell cell=new PdfPCell();
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(border);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPadding(8);
			cell.setPaddingTop(0);
			//Code By Roshan 
			cell.setPaddingBottom(2);
			//Code Ends Here
			pdfPTable.addCell(cell);
		}
		//Code Starts From Here Done By Roshan Tailor Date:- 07-21-2016
		//Code For Left Border
		public void addCellLeftBorder(String value,int fontType,int align,int colspan,int rowspan,float border){
			PdfPCell cell=new PdfPCell();
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(border);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPadding(8);
			cell.setPaddingTop(0);
			//Code By Roshan 
			cell.setPaddingBottom(4);
			cell.setBorderWidthLeft(1);
			//Code Ends Here
			pdfPTable.addCell(cell);
		}
		//Code For Right Border
		public void addCellRightBorder(String value,int fontType,int align,int colspan,int rowspan,float border){
			PdfPCell cell=new PdfPCell();
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(border);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPadding(8);
			cell.setPaddingTop(0);
			//Code By Roshan 
			cell.setPaddingBottom(2);
			cell.setBorderWidthRight(1);
			//Code Ends Here
			pdfPTable.addCell(cell);
		}
		//Code Ends Here Done By Roshan Tailor Date:- 07-21-2016
		
		public void addCell(String value,int fontType,int align,int colspan,int rowspan,float border,float paddingLeft,float paddingRight,float paddingTop,float paddingBottom,Color color){
			PdfPCell cell=new PdfPCell();
			cell.setUseAscender(true);
			
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(border);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);

			cell.setPaddingTop(paddingTop);
			cell.setPaddingBottom(paddingBottom);
			cell.setPaddingRight(paddingRight);
			cell.setPaddingLeft(paddingLeft);
			
			cell.setBackgroundColor(color);
			pdfPTable.addCell(cell);
		}
		
		public void addCell(String value,int fontType,int align,int colspan,int rowspan,float border,float paddingLeft,float paddingRight,float paddingTop,float paddingBottom){
			PdfPCell cell=new PdfPCell();
			cell.setUseAscender(true);
			
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(border);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);

			cell.setPaddingTop(paddingTop);
			cell.setPaddingBottom(paddingBottom);
			cell.setPaddingRight(paddingRight);
			cell.setPaddingLeft(paddingLeft);

			pdfPTable.addCell(cell);
		}
		
		
		public void addCell(String value,int fontType,int align,int colspan,int rowspan,float paddingLeft,float paddingRight,float paddingTop,float paddingBottom,Color color){
			PdfPCell cell=new PdfPCell();
			cell.setUseAscender(true);
			
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(0.05f);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);

			cell.setPaddingTop(paddingTop);
			cell.setPaddingBottom(paddingBottom);
			cell.setPaddingRight(paddingRight);
			cell.setPaddingLeft(paddingLeft);
			
			cell.setBackgroundColor(color);
			pdfPTable.addCell(cell);
		}
		
		public void addCell(String value,int fontType,int align,int colspan,int rowspan,Color color){
			PdfPCell cell=new PdfPCell();
			Font font=getFont(fontType);
			Paragraph paragraph=new Paragraph(new Chunk(value,font));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(0.05f);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPadding(8);
			cell.setPaddingTop(0);
			cell.setBackgroundColor(color);
			pdfPTable.addCell(cell);
		}
		
		public void addImage(URL image,int x,int y,int align,int colspan,int rowspan) throws Exception{
			PdfPCell cell=new PdfPCell();
			Image img=Image.getInstance(image);
			Paragraph paragraph=new Paragraph(new Chunk(img,x,y));
			paragraph.setAlignment(getAlignment(align));
			cell.addElement(paragraph);
			cell.setBorderWidth(0.05f);
			cell.setColspan(colspan);
			cell.setRowspan(rowspan);
			cell.setPadding(8);
			cell.setPaddingTop(0);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			pdfPTable.addCell(cell);
		}
	
		public void finish() throws Exception{
			document.add(pdfPTable);
		}
		
	}
	

	
	
	private Font getFont(int fontType){
		
		Font font=null;
		if(PdfStyle.FONT_BOLD_12==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 12,Font.NORMAL);
		}else if(PdfStyle.FONT_BOLD_16==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 16,Font.NORMAL);
		}else if(PdfStyle.FONT_BOLD_UNDERLINE_12==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 12,Font.NORMAL|Font.UNDERLINE);
		}else if(PdfStyle.FONT_BOLD_UNDERLINE_16==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 16,Font.NORMAL|Font.UNDERLINE);
		}else if(PdfStyle.FONT_BOLD_14==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 14,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_10==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-R.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 10,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_12==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-R.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 12,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_ITALIC_10==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-RI.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 10,Font.NORMAL|Font.ITALIC);
		}else if(PdfStyle.FONT_NORMAL_ITALIC_12==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-RI.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 12,Font.NORMAL|Font.ITALIC);
		}else if(PdfStyle.FONT_NORMAL_ITALIC_UNDERLINE_12==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-RI.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 12,Font.NORMAL|Font.ITALIC|Font.UNDERLINE);
		}else if(PdfStyle.FONT_NORMAL_UNDERLINE_12==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-R.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 12,Font.NORMAL|Font.UNDERLINE);
		}else if(PdfStyle.FONT_BOLD_8==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 8,Font.NORMAL);
		}else if(PdfStyle.FONT_BOLD_10==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 10,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_8==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-R.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 8,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_ITALIC_8==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-RI.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 8,Font.NORMAL|Font.ITALIC);
		}else if(PdfStyle.FONT_BOLD_9==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 9,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_9==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-R.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 9,Font.NORMAL);
		}else if(PdfStyle.FONT_BOLD_7==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 7,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_7==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-R.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 7,Font.NORMAL);
		}else if(PdfStyle.FONT_BOLD_6==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-B.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 6,Font.NORMAL);
		}else if(PdfStyle.FONT_NORMAL_6==fontType){
			font=FontFactory.getFont("fonts/Ubuntu-R.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED, 6,Font.NORMAL);
		}
		return font;
		
	}
	
	private int getAlignment(int align) {
		if(PdfStyle.ALIGN_CENTER==align){
			return Element.ALIGN_CENTER;
		}else if(PdfStyle.ALIGN_LEFT==align){
			return Element.ALIGN_LEFT;
		}else if(PdfStyle.ALIGN_RIGHT==align){
			return Element.ALIGN_RIGHT;
		}
		return Element.ALIGN_CENTER;
	}
	
		
	public void setWaterMark(boolean waterMark) {
		this.waterMark = waterMark;
	}


	class HeaderFooter extends PdfPageEventHelper{
		Phrase[] header = new Phrase[2];
		int pagenumber;
		
		@Override
		public void onOpenDocument(PdfWriter writer, Document document) {
	        header[0] = new Phrase("Movie history");
	    }
		
		@Override
		public void onChapter(PdfWriter writer, Document document,
	            float paragraphPosition, Paragraph title) {
	        header[1] = new Phrase(title.getContent());
	        pagenumber = 1;
	    }
		
		@Override
		public void onStartPage(PdfWriter writer, Document document) {
	        pagenumber++;
	    }
		@Override
		public void onEndPage(PdfWriter writer, Document document) {
			Rectangle rect = document.getPageSize();
			Font font=FontFactory.getFont(FontFactory.TIMES_ROMAN, 9,Font.NORMAL|Font.ITALIC);
			
			ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_LEFT, new Phrase(String.format("Page | %d", pagenumber),font),
					rect.getWidth()-70, Utilities.pointsToInches(rect.getHeight()), 0);
			
			
			
			/*if(waterMark){
				Phrase watermark = new Phrase("ST Tissue LLC", FontFactory.getFont(FontFactory.TIMES_ROMAN, 80,Font.NORMAL,new Color(225, 225, 225)));
				PdfContentByte canvas = writer.getDirectContentUnder();
				ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, rect.getWidth()/2, rect.getHeight()/2, 45);
		      
			}*/
			
			
	    }
	}	
	
}
