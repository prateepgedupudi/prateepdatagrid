package com.prateep;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.prateep.util.Item;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Prateep
 */
public class Prateep extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Item itemdata;
	private List<Item> list=new ArrayList<Item>();
	private String[] possible_item_names={"Mobile", "दूरवाहिनी", "ஸ்மார்ட் டிவி", "Tab", "మొబైల్"};
	private static int NUM_ITEMS = 10000;
	private int id=0;
	Random rn = new Random();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prateep() {
    	for(int i=0;i<=NUM_ITEMS;i++){
    		list.add(new Item(id,possible_item_names[rn.nextInt(3)],rn.nextInt(10),rn.nextInt(100)));
    		id +=1;
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(request.getParameterMap().size()!=0){
			int start=Integer.parseInt(request.getParameter("start"));
			int count=start+Integer.parseInt(request.getParameter("count"));
			String callBackParam=request.getParameter("callback");
			List<Item> listcopy=new ArrayList<Item>();
			for(int i=start;i<=count;i++){
				listcopy.add(list.get(i));
			}
			XStream xstream = new XStream(new JsonHierarchicalStreamDriver() {
			    public HierarchicalStreamWriter createWriter(Writer writer) {
			        return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			    }
			});
			xstream.alias("items", com.prateep.util.Item.class);
			String str=xstream.toXML(listcopy);
			str="{'numRows':10000,'items':"+str+"}";
			if(callBackParam!=null){
				str=callBackParam+"("+str+");";
			}
			out.print(str);
		}else{
			out.print("{'res':'Thanks for your get request'}");
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
