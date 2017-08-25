/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devischantier;

import db.business.FacadeDB;
import db.dto.ChantierDto;
import db.dto.DevisDto;
import db.exception.DevisChantierBusinessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Utilitaire;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * FXML Controller class
 *
 * @author Vali
 */
public class DevisFormController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TextField statut;
    @FXML
    private DatePicker dateDevis;
    @FXML
    private TextField designation;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private Label message;
    @FXML
    private ListView<ChantierDto> listChantiers;

    private int idChantier;
    @FXML
    private Button ajoutOuvrier;
    @FXML
    private Button pdf;
    @FXML
    private Button ajoutConducteur;
    @FXML
    private Button ajoutClient;
    @FXML
    private Button ajoutEngin;
    @FXML
    private Button ajoutMateriau;
    @FXML
    private Button ajoutPetitMateriel;
    @FXML
    private Button ajoutCodeReference;
    @FXML
    private Button ajoutVoiture;
    @FXML
    private Button ajoutCamion;
    @FXML
    private Button ajoutChantier;
    @FXML
    private Label messagePdf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayChantiers();
    }

    @FXML
    private void validation(ActionEvent event) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = (java.util.Date) format.parse(dateDevis.getValue().toString());
            java.sql.Date date = new Date(parsed.getTime());

            DevisDto devis = new DevisDto(10000, designation.getText(), statut.getText(), date, idChantier);
            if (Utilitaire.insertDevis(devis)) {
                message.setText("Devis ajouté avec succès !");
                Stage stage = (Stage) pane.getScene().getWindow();
                stage.close();
            } else {
                message.setText("Erreur : le devis n'a pas pu être ajouté ...!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            message.setText("Erreur : le devis n'a pas pu être ajouté !");
        }
    }

    private void displayChantiers() {
        try {
            Collection<ChantierDto> chantiers = FacadeDB.getAllChantier();
            ObservableList<ChantierDto> data = FXCollections.observableArrayList(chantiers);
            listChantiers.setItems(data);
            listChantiers.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    ChantierDto chantier = listChantiers.getSelectionModel().selectedItemProperty().get();
                    idChantier = chantier.getId();
                    System.out.println(idChantier);
                }
            });

        } catch (DevisChantierBusinessException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void annulation(ActionEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void goToDevisAjoutOuvrier(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(DevisChantier.class.getResource("DevisAjoutOuvrier.fxml"));
        AnchorPane ouvrierInfo;
        try {
            ouvrierInfo = (AnchorPane) loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(ouvrierInfo);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void creerPdf(ActionEvent event) {
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Public/DevisChantier.pdf"));
            document.open();

            FontFactory.register("C:/Windows/FONTS/ARIAL.TTF");

            Font fonte = FontFactory.getFont("arial");

            Font maFonte = new Font(fonte);
            maFonte.setColor(36, 68, 92);
            maFonte.setSize(11);

            Font maFonte2 = new Font(fonte);
            maFonte2.setColor(88, 100, 115);
            maFonte2.setSize(14);

            Paragraph p0 = new Paragraph("Melin\nChaussée Provinciale, 85\n1341 Ottignies\nTEL : 010/61.28.47\nFAX : 010/61.13.27\nEmail : info@melinsa.be ", maFonte);
            p0.setAlignment(Element.ALIGN_RIGHT);
            document.add(p0);

            Paragraph p1 = new Paragraph("Devis n° : " + "" + " | Statut : " + "" + " | Date du devis : " + "", maFonte2);
            p1.setAlignment(Element.ALIGN_LEFT);
            document.add(p1);

            String var2 = "ER517";
            String dat1 = "2018-02-15";
            String dat2 = "2018-02-30";
            String desi = "Parc de woluwe";
            Paragraph p2 = new Paragraph("Chantier n°" + var2 + " | Date prévue : " + dat1 + " | Date fin : " + dat2 + "\nDésignation du projet : " + desi + "\nInformations client :", maFonte2);
            p2.setAlignment(Element.ALIGN_LEFT);
            document.add(p2);

            Paragraph p3 = new Paragraph("Numéro :\nNom :\nPrénom :\nTéléphone :\nEmail :\n ", maFonte);
            p3.setAlignment(Element.ALIGN_LEFT);
            document.add(p3);

        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // LOGO MELIN
       Image image = null;
        try {
            image = Image.getInstance("src/images/melin.jpg");
            image.setAbsolutePosition(37, 720);
        } catch (BadElementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            document.add(image);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        float[] columnWidths = {1, 5, 5};
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(100);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
        PdfPCell cell = new PdfPCell(new Phrase("Informations détaillées", f));
        cell.setBackgroundColor(GrayColor.GRAYBLACK);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(3);
        table.addCell(cell);
        table.getDefaultCell().setBackgroundColor(GrayColor.YELLOW);

        table.addCell("#");
        table.addCell("Références");
        table.addCell("Prix HTVA");

        table.setHeaderRows(3);

        table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell("1");
        table.addCell("Conducteur");
        table.addCell("1586");

        table.addCell("2");
        table.addCell("Ouvriers");
        table.addCell("2560");

        table.addCell("3");
        table.addCell("Engins");
        table.addCell("4876");

        table.addCell("4");
        table.addCell("Matériaux");
        table.addCell("589");

        table.addCell("5");
        table.addCell("Petits matériels");
        table.addCell("699");

        table.addCell("6");
        table.addCell("Codes références");
        table.addCell("125");

        table.addCell("7");
        table.addCell("Voitures");
        table.addCell("350");

        table.addCell("8");
        table.addCell("Camions");
        table.addCell("100");

        table.addCell(" ");
        table.addCell(" ");
        table.addCell(" ");

        table.addCell(" ");
        table.addCell("Prix total Hors TVA");
        table.addCell("12350 €");

        table.addCell(" ");
        table.addCell("Prix TVA 21%");
        table.addCell("16520 €");

        try {
            document.add(table);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        messagePdf.setText("Devis créé avec succès vers : C:/Users/Public/DevisChantier.pdf");
        document.close();
    }

    @FXML
    private void goToDevisAjoutConducteur(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutClient(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutEngin(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutMateriau(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutPetitMateriel(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutCodeReference(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutVoiture(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutCamion(ActionEvent event) {
    }

    @FXML
    private void goToDevisAjoutChantier(ActionEvent event) {
    }

}
