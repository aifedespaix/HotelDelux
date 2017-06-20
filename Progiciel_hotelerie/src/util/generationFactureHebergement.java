package src.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import src.Metier.Client;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;


public class generationFactureHebergement {
	
	public static void editFactureLauncher(ReservationHotel reservation){
		generationFactureHebergement facture = new generationFactureHebergement();
		facture.editionElementFacture(reservation);
	}

	public static void editionElementFacture(ReservationHotel reservation){
		Client clientReservation = AccesData.getClientById(reservation.getIdClient());
		BaseColor color = new BaseColor(117,117,117);
		BaseColor grisClair = new BaseColor(240,240,240);
		Document document = new Document();
		java.sql.Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		String cheminFichier = Parametre.getCheminFichier(clientReservation.getNom(), clientReservation.getPrenom(), timeNow);
		System.out.println(cheminFichier);
		try{
			PdfWriter.getInstance(document, new FileOutputStream(cheminFichier));
			document.open();
			Font font1 = new Font(Font.FontFamily.COURIER, 12);	
			Font fontWhite = new Font(Font.FontFamily.COURIER, 12);	
			fontWhite.setColor(255,255,255);
			
			//Image
			Image image1 = Image.getInstance ("Progiciel_hotelerie/src/image/Hotel/ghdp.png");
			image1.setAbsolutePosition(35f, 700F);
			document.add(image1);
			
			Paragraph para1 = new Paragraph("Facture de l'hôtel");
			para1.setAlignment(Element.ALIGN_RIGHT);			
			document.add(para1);
			
			Paragraph para2 = new Paragraph("Facture éditée le " + timeNow);			
			para2.setAlignment(Element.ALIGN_RIGHT);			
			document.add(para2);
			
			//Info Habitation
			String nom = clientReservation.getNom();
			String prenom = clientReservation.getPrenom();
			String adresseRue = clientReservation.getAdresseRue();
			String adresseVille = clientReservation.getAdresseVille();
			String cp = clientReservation.getCodePostal();
			
			Paragraph para3 = new Paragraph(nom + " " + prenom + "\n" + adresseRue + "\n" + cp + " " + adresseVille);			
			para3.setIndentationLeft(300);
			para3.setSpacingBefore(100);
			para3.setSpacingAfter(50);	
			
			document.add(para3);
			
			int nbNuits = (int) (reservation.getDateFin().getTime() - reservation.getDateDebut().getTime()) / (1000 * 60 * 60 * 24);
			int numChambre = reservation.getChambreByIdChambre().getNumeroChambre();
			int nbPersonnes = reservation.getNbAdultes() + reservation.getNbEnfants();
			double tarifChambre = reservation.getChambreByIdChambre().getPrix();
			
			PdfPTable table = new PdfPTable(4);
			
			PdfPCell cell1 = new PdfPCell(new Paragraph("Nuit", fontWhite));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Numéro de chambre", fontWhite));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Nombre de personnes", fontWhite));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Total HT", fontWhite));
		
			cell1.setBackgroundColor(color);
			cell2.setBackgroundColor(color);
			cell3.setBackgroundColor(color);
			cell4.setBackgroundColor(color);
	
			cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			
			cell1.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
			cell2.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
			cell3.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
			cell4.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
			
			cell1.setPadding(10);
			cell2.setPadding(10);
			cell3.setPadding(10);
			cell4.setPadding(10);
			
			cell1.setBorder(0);
			cell2.setBorder(0);
			cell3.setBorder(0);
			cell4.setBorder(0);
							
			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);
			
			System.out.println(nbNuits);
			
			for(int j = 0; j < nbNuits; j++){
				
					PdfPCell cell6 = new PdfPCell(new Paragraph(String.valueOf(j)));
					PdfPCell cell7 = new PdfPCell(new Paragraph(String.valueOf(numChambre)));
					PdfPCell cell8 = new PdfPCell(new Paragraph(String.valueOf(nbPersonnes)));
					PdfPCell cell9 = new PdfPCell(new Paragraph(String.valueOf(tarifChambre)));
		
					if(j%2 == 1){
						cell6.setBackgroundColor(grisClair);
						cell7.setBackgroundColor(grisClair);
						cell8.setBackgroundColor(grisClair);
						cell9.setBackgroundColor(grisClair);
					}
					cell6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					cell7.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					cell8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					cell9.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
					
					cell6.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
					cell7.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
					cell8.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
					cell9.setHorizontalAlignment(PdfPCell.ALIGN_MIDDLE);
					
					cell6.setBorder(0);
					cell7.setBorder(0);
					cell8.setBorder(0);
					cell9.setBorder(0);
					
					cell6.setPadding(10);
					cell7.setPadding(10);
					cell8.setPadding(10);
					cell9.setPadding(10);
					
									
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
					table.addCell(cell9);
			}	
			
			table.setSpacingAfter(50);
			
			document.add(table);		
			
			
			/**
			 * 
			 */
			
			
			double prixGlobal = nbNuits * tarifChambre;
			
			PdfPTable table2 = new PdfPTable(4);
			
			double TVA = (double) Math.round((prixGlobal * 0.2) * 100) / 100;
			double totalTTC = prixGlobal + TVA;
			
			PdfPCell cell1Tab2 = new PdfPCell(new Paragraph("Total général HT"));
			cell1Tab2.setColspan(3);
			cell1Tab2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			PdfPCell cell2Tab2 = new PdfPCell(new Paragraph(String.valueOf(prixGlobal)));
			cell2Tab2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			
			PdfPCell cell3Tab2 = new PdfPCell(new Paragraph("Montant TVA"));
			cell3Tab2.setColspan(3);
			cell3Tab2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			PdfPCell cell4Tab2 = new PdfPCell(new Paragraph(String.valueOf(TVA)));
			cell4Tab2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			
			PdfPCell cell5Tab2 = new PdfPCell(new Paragraph("Total TTC"));
			cell5Tab2.setColspan(3);
			cell5Tab2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
			PdfPCell cell6Tab2 = new PdfPCell(new Paragraph(String.valueOf(totalTTC),fontWhite));
			cell6Tab2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			cell6Tab2.setBackgroundColor(color);
			
			cell1Tab2.setBorder(0);
			cell2Tab2.setBorder(0);
			cell3Tab2.setBorder(0);
			cell4Tab2.setBorder(0);
			cell5Tab2.setBorder(0);
			cell6Tab2.setBorder(0);
			
			cell1Tab2.setPadding(10);
			cell2Tab2.setPadding(10);
			cell3Tab2.setPadding(10);
			cell4Tab2.setPadding(10);
			cell5Tab2.setPadding(10);
			cell6Tab2.setPadding(10);
			
			table2.addCell(cell1Tab2);
			table2.addCell(cell2Tab2);
			table2.addCell(cell3Tab2);
			table2.addCell(cell4Tab2);
			table2.addCell(cell5Tab2);
			table2.addCell(cell6Tab2);
			
			
			document.add(table2);
			
			
			
			document.close();
			Runtime.getRuntime().exec("explorer.exe " + Parametre.getCheminFichier(clientReservation.getNom(), clientReservation.getPrenom(), timeNow));
		} catch(DocumentException e){
			e.printStackTrace();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
