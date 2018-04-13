package edu.nccu.misds.stu105306002.hw6;
import java.io.IOException;
import java.util.ArrayList;

public class WebPage
{
	public String URL;
	public String name;
	public WordCounter counter;
	public double score;
	
	public WebPage(String URL, String name)
	{
		this.URL = URL;
		this.name = name;
		this.counter = new WordCounter(URL);
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException
	{
		score = 0;
		for(Keyword k : keywords)
		{
			score += counter.countKeyword(k.name)*k.weight;
		}
	}
}
