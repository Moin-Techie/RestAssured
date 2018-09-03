package utilities;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
/*import org.xml.sax.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;*/
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLParsing 
{
	@Test
	public void XMLParse() throws Exception
	{
		Document xmlDoc = getDocument("./Files/Testdata.xml");
		
		System.out.println("Root: "+ xmlDoc.getDocumentElement().getNodeName());
		NodeList listOfCustomer = xmlDoc.getElementsByTagName("address");
		System.out.println("Total Children under selected Nodes: "+listOfCustomer.getLength());
		
		String fname="firstName";
		String lname="lastName";
		String state="state";
		
		getElementAttribute(listOfCustomer,state);
		
	
	}

	private static void getElementAttribute(NodeList listOfCustomer, String node) 
	{
		try 
		{
			for (int i = 0; i < listOfCustomer.getLength(); i++) 
			{
				Node shNode= listOfCustomer.item(i);
				
				Element shEle=(Element) shNode;
				
				NodeList FnameList = shEle.getElementsByTagName(node);
				
				Element fnameEle=(Element) FnameList.item(0);
				
				NodeList eleList = fnameEle.getChildNodes();
				
				System.out.println("Data: "+((Node)eleList.item(0)).getNodeValue().trim());
			}
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

	private static Document getDocument(String docstring) 
	{
		// Since it might throw an error wen the file is not found
		try 
		{
			//Api that lets convert xml into DOM
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			//Define constraints how the DOm should be created
			
			factory.setIgnoringComments(true);//we dont want comments to be stored as node
			factory.setIgnoringElementContentWhitespace(true);// No white psaces
			factory.setValidating(true);//validate the xml
			
			//Providing access to Document data 
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			//return the document object to play aorund by specifying the file name
			
			return builder.parse(new InputSource(docstring));
			
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}
