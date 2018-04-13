package edu.nccu.misds.stu105306002.hw6;
import java.net.*;
import java.io.*;


public class WordCounter
{	
	private String urlStr;
	private String content;
	
	public WordCounter(String urlStr)
	{
		this.urlStr = urlStr;
	}
	
	private String fetchContent() throws IOException  //web資料抓回來
	{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		
		InputStream in = conn.getInputStream(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String retVal = "";
		String line = null;
		
		while((line = br.readLine()) != null)
		{	
			retVal = retVal + line + "\n";			
		}
		return retVal;
	}
	
	public int countKeyword(String keyword) throws IOException //把抓回來的資料算總共出現幾次
	{
		if(content == null) 
		{
			content = fetchContent();
		}
		
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		
		int retVal = 0;
		int fromIdx = 0;
		int found = -1;
		
		while((found = content.indexOf(keyword , fromIdx ))!= -1)
		{
			retVal++;
			fromIdx = found + keyword.length();
		}
		return retVal;
	}
	
}

