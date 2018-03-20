package billeterie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

 
public class Fenetre extends JFrame implements ActionListener {
	private JPanel pan = new JPanel();
	private JButton b0 = new JButton("Valider");
	private JTextField b8 = new JTextField();
	private JTextField b9 = new JTextField();
	private JTextField b10 = new JTextField();
	String[] tab = {"BIG", "FLO", "ET", "OLI"};
	private JComboBox b11 = new JComboBox(tab);
	private JRadioButton b12 = new JRadioButton ("Assise");
	private JRadioButton b13 = new JRadioButton ("Debout");
	private ButtonGroup bg = new ButtonGroup();
	
	public Fenetre() {
		this.setTitle("Billeterie");
		this.setSize(1400, 1500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		// Texte Nom
		JPanel p1 = new JPanel();
		JLabel l1 = new JLabel("Nom :");
		p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
		p1.add(l1);
		
		// Champ texte Nom
		JPanel b7 = new JPanel();
		b7.setLayout(new BoxLayout(b7, BoxLayout.LINE_AXIS));
		b7.add(b8); 
		b7.setMaximumSize(new Dimension(600, 60));
		b7.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Texte Prenom
		JPanel p2 = new JPanel();
		JLabel l2 = new JLabel("Prenom :");
		p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
		p2.add(l2);
		p2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		// Champ texte Prenom
		JPanel b6 = new JPanel();
		b6.setLayout(new BoxLayout(b6, BoxLayout.LINE_AXIS));
		b6.add(b9);
		b6.setMaximumSize(new Dimension(600, 60));
		b6.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Texte Email
		JPanel p3 = new JPanel();
		JLabel l3 = new JLabel("Mail :");
		p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
		p3.add(l3);
		p3.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		// Champ texte mail
		JPanel b5 = new JPanel();
		b5.setLayout(new BoxLayout(b5, BoxLayout.LINE_AXIS));
		b5.add(b10);
		b5.setMaximumSize(new Dimension(600, 60));
		b5.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Texte Type concert
		JPanel p4 = new JPanel();
		JLabel l4 = new JLabel("Type concert :");
		p4.setLayout(new BoxLayout(p4, BoxLayout.LINE_AXIS));
		p4.add(l4);
		p4.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		//Menu deroulant
		JPanel b4 = new JPanel();
		b4.setLayout(new BoxLayout(b4, BoxLayout.LINE_AXIS));
		b4.add(b11);
		b4.setMaximumSize(new Dimension(600, 60));
		b4.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Texte Type place
		JPanel p5 = new JPanel();
		JLabel l5 = new JLabel("Type Place:");
		p5.setLayout(new BoxLayout(p5, BoxLayout.LINE_AXIS));
		p5.add(l5);
		p5.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		
		// Bouton Radio
		JPanel b2 = new JPanel();
		b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		bg.add(b12);
		b12.setActionCommand("Assise");
		b13.setActionCommand("Debout");
		bg.add(b13);
		b2.add(b12);
		b2.add(b13);
		b2.setAlignmentX(CENTER_ALIGNMENT);
		b2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		// Bouton Valider
		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		b1.add(b0);
		b1.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
		b0.setName("myButton");
		b0.addActionListener(this);
		
		
		// Agenceur
		JPanel b3 = new JPanel();
		b3.setLayout(new BoxLayout(b3, BoxLayout.PAGE_AXIS));
		b3.add(Box.createRigidArea(new Dimension(0,200)));
		b3.add(p1);
		b3.add(b7);
		b3.add(p2);
		b3.add(b6);
		b3.add(p3);
		b3.add(b5);
		b3.add(p4);
		b3.add(b4);
		b3.add(p5);
		b3.add(b2);
		b3.add(b1);
		
		this.getContentPane().add(b3);
		this.setVisible(true);
	 } 
		
	
	// Recupere le form en fichier XML
		public void actionPerformed(ActionEvent arg0) { 


			try {

				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

				// root elements
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("AchatBillet");
				doc.appendChild(rootElement);

				// infos elements
				Element infos = doc.createElement("infos");
				rootElement.appendChild(infos);

				// set attribute to infos element
				Attr attr = doc.createAttribute("id");
				attr.setValue("1");
				infos.setAttributeNode(attr);

				// name elements
				Element nom = doc.createElement("Nom");
				nom.appendChild(doc.createTextNode(b8.getText()));
				infos.appendChild(nom);

				// prenom elements
				Element prenom = doc.createElement("Prenom");
				prenom.appendChild(doc.createTextNode(b9.getText()));
				infos.appendChild(prenom);

				// email elements
				Element email = doc.createElement("Email");
				email.appendChild(doc.createTextNode(b10.getText()));
				infos.appendChild(email);
				
				// deroulant elements
				Element concert = doc.createElement("concert");
				concert.appendChild(doc.createTextNode(b11.getSelectedItem().toString()));
				infos.appendChild(concert);
				
				// typeplace elements
				Element place = doc.createElement("TypePlace");
				place.appendChild(doc.createTextNode(bg.getSelection().getActionCommand()));
				infos.appendChild(place);
				
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("C:/Users/bruno/Documents/Billeterie/file.xml"));

				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);

				transformer.transform(source, result);

				System.out.println("File saved!");

			  } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			  } catch (TransformerException tfe) {
				tfe.printStackTrace();
			  }

			
		  }
		
		public static void main(String[] args) {
			 
			new Fenetre();
		}
	}