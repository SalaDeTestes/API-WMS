package com.wms.api.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.wms.api.models.Etiqueta;
import com.wms.api.repository.EtiquetaRepository;
import com.wms.api.services.EtiquetaService;

//Comunicar com a impressora
//https://www.guj.com.br/t/criar-etiqueta-para-impressora-zebra/141869/6

public class PdfGeneratorEtiqueta {

	public void GerarEtiquetaPDF(HttpServletResponse response, int quantidadeEtiqueta,
			EtiquetaRepository etiquetaRepository) throws DocumentException, IOException {

		List<Etiqueta> listaEtiqueta;

		listaEtiqueta = EtiquetaService.gerarEtiqueta(quantidadeEtiqueta, etiquetaRepository);

		Document pdf = new Document(PageSize.A4);

		PdfWriter.getInstance(pdf, response.getOutputStream());

		// Abre o documento
		pdf.open();

		// Define a font do titulo do documento
		Font fontTiltle = FontFactory.getFont(FontFactory.HELVETICA);

		// Define o tamanho da font
		fontTiltle.setSize(20);

		// Cria um paragrafo
		Paragraph paragraph1 = new Paragraph("Etiquetas Geradas", fontTiltle);

		// Alinha o pargrafo no centro
		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);

		// Adiciona o paragrafo no documento
		pdf.add(paragraph1);

		// Cria uma tabela com 2 colunas
		PdfPTable table = new PdfPTable(2);

		// Configura o tamanho da tabelas e espaços das colunas
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3 });
		table.setSpacingBefore(5);

		// Criar células de tabela para o cabeçalho da tabela
		PdfPCell cell = new PdfPCell();

		// Definindo a cor de fundo e o preenchimento da célula da tabela
		cell.setBackgroundColor(CMYKColor.GREEN);
		cell.setPadding(5);

		// Cria uma nova Fonte
		// Definir estilo e tamanho da fonte
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(CMYKColor.BLACK);

		// Adding headings in the created table cell or header
		// Adding Cell to table
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Descrição", font));
		table.addCell(cell);
		// Iterating the list of Etiquetas
		for (Etiqueta etiqueta : listaEtiqueta) {
			// Adding student id
			table.addCell(String.valueOf(etiqueta.getId()));
			// Adding student name
			table.addCell(etiqueta.getDescricaoEtiqueta());
		}

		// Adding the created table to the document
		pdf.add(table);
		// Closing the document
		pdf.close();

	}
}
