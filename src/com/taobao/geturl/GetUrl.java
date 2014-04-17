package com.taobao.geturl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: hegen
 * Date: 14-4-14
 * Time: ????5:01
 * To change this template use File | Settings | File Templates.
 */
public class GetUrl extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
       // request.setCharacterEncoding("BGK");
        response.setContentType("text/html");
        //String userid=request.getParameter("userid");
        String strUrl = "http://hrtsea.com/?p=9819";
        URL url = new URL(strUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(5000);
        urlCon.setReadTimeout(5000);
        InputStream in = urlCon.getInputStream();
        PrintWriter out=response.getWriter();
        int current=in.read();
        while(current!=-1){
            out.write(current);
            current=in.read();
        }
        in.close();
        out.close();
    }

}