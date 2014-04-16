package com.taobao.tc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: hegen
 * Date: 14-4-16
 * Time: ÉÏÎç11:46
 * To change this template use File | Settings | File Templates.
 */
public class Hello extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        //request.setCharacterEncoding("BGK");
        response.setContentType("text/html");
        String userid=request.getParameter("userid");
        PrintWriter out=response.getWriter();
        if (userid=="zzxia"){
            out.print("true");
        }else{
            out.print("flase");
        }
        out.close();
    }
}