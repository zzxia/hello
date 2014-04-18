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
        request.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=gbk");
        PrintWriter out=response.getWriter();
        String strUrl=request.getParameter("url");

        URL url = new URL(strUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(5000);
        urlCon.setReadTimeout(5000);
        InputStream in = urlCon.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "gbk"));
        StringBuffer pageBuffer = new StringBuffer();
        String line="";
        while ((line = reader.readLine()) != null)
        {
            pageBuffer.append(line);
        }
        out.println(pageBuffer.toString());
        out.close();
    }

}