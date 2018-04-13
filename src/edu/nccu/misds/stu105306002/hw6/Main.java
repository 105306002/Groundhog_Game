package edu.nccu.misds.stu105306002.hw6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		WebPage rootPage = new WebPage("http://www3.nccu.edu.tw/~yuf" , "Fang Yu");
		WebTree tree = new WebTree(rootPage);
		
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html" , "Publication")));
		tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/research_projects_and_tools.htm\n" , "Project")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("http://www.cs.ucsb.edu/~vlab/stranger/", " Stranger")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("http://nccusoslab.com:280/data-structure/little-boat.html\n" , "LittleBoat")));
		tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/short_biography.htm\n" ,"Biography"))); 
		tree.root.children.get(2).addChild(new WebNode(new WebPage("http://www.cs.ucsb.edu/~vlab\n" ,"Vlab")));
		tree.root.addChild(new WebNode(new WebPage("http://www3.nccu.edu.tw/~yuf/course.htm" , "Course")));
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine())
		{
			int numOfKeywords = scanner.nextInt();
			ArrayList<Keyword> keywords = new ArrayList<Keyword>();
			
			for(int i = 0; i < numOfKeywords; i++)
			{
				String name = scanner.next();
				double weight = scanner.nextDouble();
				Keyword k = new Keyword(name,(float) weight);
				keywords.add(k);
			}
			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		scanner.close();
	}

}
