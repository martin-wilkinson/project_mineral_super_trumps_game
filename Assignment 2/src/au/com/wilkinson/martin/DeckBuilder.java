package au.com.wilkinson.martin;

/**
 * Created by jimji on 3/10/2016.
 */

        import java.io.File;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.parsers.DocumentBuilder;
        import org.w3c.dom.Document;
        import org.w3c.dom.NodeList;
        import org.w3c.dom.Node;
        import org.w3c.dom.Element;

public class DeckBuilder {

    public static void main(String[] args) {
        GameCard[] test = buildDeck();
        System.out.println(test);
    }
    public static GameCard[] buildDeck() {
        GameCard[] deck = new GameCard[60];
        try {
            File inputFile = new File("D:\\Assignment 1\\src\\au\\com\\wilkinson\\martin\\MstCards_151021.plist");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("dict");
            int deckPos = 0;

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node currentNode = nList.item(temp);
                if (currentNode.getNodeType() == currentNode.ELEMENT_NODE) {
                    Element currentElement = (Element) currentNode;
                    NodeList nlist1 = currentElement.getElementsByTagName("key");
                    NodeList nlist2 = currentElement.getElementsByTagName("string");


                    if (nlist1.item(3).getTextContent().equals("trump")) {
                        deck[deckPos] = new TrumpCard(nlist2.item(2).getTextContent(), nlist2.item(3).getTextContent(), nlist2.item(0).getTextContent());
                        deckPos++;
                    }
                    else if (nlist1.item(3).getTextContent().equals("play")){
                        double hardnesVal = 0;
                        double specGravVal = 0;
                        double convertedVal;
                        String[] occrnceArray = new String[nlist2.getLength() - 11];
                        for (int j = 0; j < nlist2.getLength() - 11; j++) {
                            occrnceArray[j] = nlist2.item(6 + j).getTextContent();
                        }
                        for (int i = 0; i < 2; i++) {
                            if (nlist2.item((6 + i) + occrnceArray.length).getTextContent().contains("-")) {
                                String valToConvert = nlist2.item((6 + i) + occrnceArray.length).getTextContent();
                                if (nlist2.item((6 + i) + occrnceArray.length).getTextContent().contains(" ")) {
                                    convertedVal = Double.parseDouble(valToConvert.substring(valToConvert.lastIndexOf(" ") + 1));
                                }
                                else {
                                    convertedVal = Double.parseDouble(valToConvert.substring(valToConvert.lastIndexOf("-") + 1));
                                }
                                if (i == 0) {
                                    hardnesVal = convertedVal;
                                }
                                else {
                                    specGravVal = convertedVal;
                                }
                            }
                            else {
                                String valToConvert = nlist2.item((6 + i) + occrnceArray.length).getTextContent();
                                if (nlist2.item((6 + i) + occrnceArray.length).getTextContent().contains(" ")) {
                                    convertedVal = Double.parseDouble(valToConvert.substring(valToConvert.lastIndexOf(" ") + 1));
                                }
                                else {
                                    convertedVal = Double.parseDouble(valToConvert);
                                }
                                if (i == 0) {
                                    hardnesVal = convertedVal;
                                }
                                else {
                                    specGravVal = convertedVal;
                                }
                            }
                        }
                        deck[deckPos] = new PlayCard(nlist2.item(2).getTextContent(), nlist2.item(3).getTextContent(), nlist2.item(4).getTextContent(), nlist2.item(5).getTextContent(),
                                occrnceArray, hardnesVal, specGravVal,
                                nlist2.item(8 + occrnceArray.length).getTextContent(), nlist2.item(9 + occrnceArray.length).getTextContent(), nlist2.item(10 + occrnceArray.length).getTextContent(), nlist2.item(0).getTextContent());
                        deckPos++;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deck;
    }
}
