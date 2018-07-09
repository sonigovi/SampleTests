package com.howtodoinjava.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlTest {

    static String module = null;
    static String testClass = null;
    static String testStatus = "PASS";
    static String testMethod = null;
    static String exceptionClass = null;
    static String exceptionMessage = null;

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, org.xml.sax.SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse("testng-results.xml");
        NodeList childNodes = doc.getChildNodes();
        iterateNodes(childNodes);
    }

    private static void iterateNodes(NodeList childNodes) {
        for (int i = 0; i < childNodes.getLength(); ++i) {
            Node node = childNodes.item(i);
            String text = node.getNodeName();
            if (text.equalsIgnoreCase("test")) {
                System.out.println("Module Name = " + module + "; Testcase Name = " + testClass + "; Status = "
                        + testStatus + "; Exception Class = " + exceptionClass + "; Exception = " + exceptionMessage);

                module = null;
                testClass = null;
                testStatus = "PASS";
                testMethod = null;
                exceptionClass = null;
                exceptionMessage = null;
            }
            if (text.equalsIgnoreCase("test")) {
                module = node.getAttributes().getNamedItem("name").getNodeValue();
            }
            if (text.equalsIgnoreCase("class")) {
                testClass = node.getAttributes().getNamedItem("name").getNodeValue();
            }
            if (text.equalsIgnoreCase("test-method") && testStatus.equalsIgnoreCase("PASS")) {
                testMethod = node.getAttributes().getNamedItem("name").getNodeValue();
                testStatus = node.getAttributes().getNamedItem("status").getNodeValue();
            }
            if (text.equalsIgnoreCase("exception")) {
                exceptionClass = node.getAttributes().getNamedItem("class").getNodeValue();
                // exceptionMessage = node.getAttributes().getNamedItem("message").getNodeValue();
            }
            if (node.hasAttributes()) {
                for (int j = 0; j < node.getAttributes().getLength(); j++) {
                    // System.out.println(node.getAttributes().item(j));
                }
            }
            if (node.hasChildNodes()) {
                iterateNodes(node.getChildNodes());
            }
        }
    }
}